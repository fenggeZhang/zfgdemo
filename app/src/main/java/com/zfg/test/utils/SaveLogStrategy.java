package com.zfg.test.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static dagger.internal.Preconditions.checkNotNull;


/**
 * Created by zfg on 2018/11/14
 */
public class SaveLogStrategy {

    @NonNull
    private final Handler handler;

    public SaveLogStrategy(@NonNull Handler handler) {
        this.handler = checkNotNull(handler);
    }

    public void log(int level, @Nullable String tag, @NonNull String message) {
        checkNotNull(message);
        handler.sendMessage(handler.obtainMessage(level, message));
    }

    static class WriteHandler extends Handler {

        private final String folder;
        private final int maxFileSize;

        WriteHandler(@NonNull Looper looper, @NonNull String folder, int maxFileSize) {
            super(checkNotNull(looper));
            this.folder = checkNotNull(folder);
            this.maxFileSize = maxFileSize;
        }

        @SuppressWarnings("checkstyle:emptyblock")
        @Override
        public void handleMessage(@NonNull Message msg) {
            String content = (String) msg.obj;
            FileWriter fileWriter = null;
            File logFile = getLogFile(folder, "logs");

            try {
                fileWriter = new FileWriter(logFile, true);

                writeLog(fileWriter, content);

                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                if (fileWriter != null) {
                    try {
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (IOException e1) {

                    }
                }
            }
        }

        private void writeLog(@NonNull FileWriter fileWriter, @NonNull String content) throws IOException {
            checkNotNull(fileWriter);
            checkNotNull(content);
            fileWriter.append("\n").append(content);
        }

        private File getLogFile(@NonNull String folderName, @NonNull String fileName) {
            checkNotNull(folderName);
            checkNotNull(fileName);

            File folder = new File(folderName);
            if (!folder.exists()) {
                if (!folder.mkdirs()) {
                    Log.println(Log.ERROR, "saveLog", "文件未创建成功，可能是读写权限没给");
                }
            }

            int newFileCount = 0;
            File newFile;
            File existingFile = null;

            newFile = new File(folder, String.format("%s_%s.txt", fileName, newFileCount));
            while (newFile.exists()) {
                existingFile = newFile;
                newFileCount++;
                newFile = new File(folder, String.format("%s_%s.txt", fileName, newFileCount));
            }

            if (existingFile != null) {
                if (existingFile.length() >= maxFileSize) {
                    return newFile;
                }
                return existingFile;
            }

            return newFile;
        }
    }
}

