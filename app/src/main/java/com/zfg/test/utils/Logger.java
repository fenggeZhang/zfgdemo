package com.zfg.test.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

import com.zfg.test.BuildConfig;

import java.io.File;

/**
 * Created by zfg on 2018/11/14
 */
public class Logger {
    public final static String tag = "";
    private static SaveLogStrategy saveLogStrategy;
    private final static boolean logFlag = true;
    private static Logger logger;
    private int logLevel = Log.VERBOSE;
    private static boolean isDebug = BuildConfig.DEBUG;
    private String customTag = null;

    private Logger(String customTag) {
        this.customTag = customTag;
    }

    public void initSaveStrategy(Context context) {
        if (saveLogStrategy != null || !isDebug) {
            return;
        }
        final int MAX_BYTES = 1024 * 1024;
        String diskPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        File cacheFile = context.getCacheDir();
        if (cacheFile != null) {
            diskPath = cacheFile.getAbsolutePath();
        }
        String folder = diskPath + File.separatorChar + "log";
        HandlerThread ht = new HandlerThread("Logger." + folder);
        ht.start();
        Handler handler = new SaveLogStrategy.WriteHandler(ht.getLooper(), folder, MAX_BYTES);
        saveLogStrategy = new SaveLogStrategy(handler);
    }

    public static Logger getLogger(String tag) {
        if (logger == null) {
            logger = new Logger(tag);
        }
        return logger;
    }

    public static Logger getLogger() {
        if (logger == null) {
            logger = new Logger(tag);
        }
        return logger;
    }

    /**
     * Verbose(2) 级别日志
     *
     * @param str String
     */
    public void v(Object str) {
        logLevel = Log.VERBOSE;
        logPrint(logLevel, str);
    }

    /**
     * Debug(3) 级别日志
     *
     * @param str String
     */
    public void d(Object str) {
        logLevel = Log.DEBUG;
        logPrint(logLevel, str);
    }

    /**
     * Info(4) 级别日志
     *
     * @param str String
     */
    public void i(Object str) {
        logLevel = Log.INFO;
        logPrint(logLevel, str);
    }

    /**
     * Warn(5) 级别日志
     *
     * @param str String
     */
    public void w(Object str) {
        logLevel = Log.WARN;
        logPrint(logLevel, str);
    }

    /**
     * Error(6) 级别日志
     *
     * @param str String
     */
    public void e(Object str) {
        logLevel = Log.ERROR;
        logPrint(logLevel, str);
    }

    private void logPrint(int logLevel, Object msg) {
        if (isDebug) {
            String name = getFunctionName();
            if (saveLogStrategy != null) {
                saveLogStrategy.log(Log.ERROR, customTag, name + " - " + msg);
            }
            Log.println(logLevel, customTag, name + " - " + msg);
        }
    }

    /**
     * 获取当前方法名
     *
     * @return 方法名
     */
    private String getFunctionName() {
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        if (sts == null) {
            return null;
        }

        for (StackTraceElement st : sts) {
            if (st.isNativeMethod()) {
                continue;
            }
            if (st.getClassName().equals(Thread.class.getName())) {
                continue;
            }
            if (st.getClassName().equals(this.getClass().getName())) {
                continue;
            }

            Thread t = Thread.currentThread();
            return "[Thread(id:" + t.getId() +
                    ", name:" + t.getName() +
                    ", priority:" + t.getPriority() +
                    ", groupName:" + t.getThreadGroup().getName() +
                    "): " + st.getFileName() + ":"
                    + st.getLineNumber() + " " + st.getMethodName() + " ]";
        }
        return "";
    }
}
