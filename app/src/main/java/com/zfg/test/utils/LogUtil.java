/*
 * Copyright © YOLANDA. All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zfg.test.utils;

import android.util.Log;

import com.zfg.test.BuildConfig;
import com.zfg.test.data.http.config.HttpConfig;


public class LogUtil {

    /**
     * library debug tag
     */
    private static String mTag = "LogUtil";

    /**
     * library debug sign
     */
    private static boolean mDebug = BuildConfig.DEBUG;

    public static void setTag(String tag) {
        mTag = tag;
        HttpConfig.LOG_TAG = tag;
    }

    public static void setDebug(boolean debug) {
        mDebug = debug;
        HttpConfig.IS_DEBUG = debug;
    }

    public static void setTagAndDebug(String tag, boolean debug) {
        setTag(tag);
        setDebug(debug);
    }

    public static void i(String msg) {
        if (mDebug) {
            Log.i(mTag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (mDebug) {
            Log.i(tag, msg);
        }
    }

    public static void i(Throwable e) {
        if (mDebug) {
            Log.i(mTag, "", e);
        }
    }

    public static void i(String tag, Throwable e) {
        if (mDebug) {
            Log.i(tag, "", e);
        }
    }

    public static void i(Throwable e, String msg) {
        if (mDebug) {
            Log.i(mTag, msg, e);
        }
    }

    public static void i(String tag, String msg, Throwable e) {
        if (mDebug) {
            Log.i(tag, msg, e);
        }
    }

    public static void v(String msg) {
        if (mDebug) {
            Log.v(mTag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (mDebug) {
            Log.v(tag, msg);
        }
    }

    public static void v(Throwable e) {
        if (mDebug) {
            Log.v(mTag, "", e);
        }
    }

    public static void v(String tag, Throwable e) {
        if (mDebug) {
            Log.v(tag, "", e);
        }
    }

    public static void v(Throwable e, String msg) {
        if (mDebug) {
            Log.v(mTag, msg, e);
        }
    }

    public static void v(String tag, String msg, Throwable e) {
        if (mDebug) {
            Log.v(tag, msg, e);
        }
    }

    public static void d(String msg) {
        if (mDebug) {
            Log.d(mTag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (mDebug) {
            Log.d(tag, msg);
        }
    }

    public static void d(Throwable e) {
        if (mDebug) {
            Log.d(mTag, "", e);
        }
    }

    public static void d(String tag, Throwable e) {
        if (mDebug) {
            Log.d(tag, "", e);
        }
    }

    public static void d(Throwable e, String msg) {
        if (mDebug) {
            Log.d(mTag, msg, e);
        }
    }

    public static void d(String tag, String msg, Throwable e) {
        if (mDebug) {
            Log.d(tag, msg, e);
        }
    }

    public static void e(String msg) {
        if (mDebug) {
            Log.e(mTag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (mDebug) {
            Log.e(tag, msg);
        }
    }

    public static void e(Throwable e) {
        if (mDebug) {
            Log.e(mTag, "", e);
        }
    }

    public static void e(String tag, Throwable e) {
        if (mDebug) {
            Log.d(tag, "", e);
        }
    }

    public static void e(Throwable e, String msg) {
        if (mDebug) {
            Log.e(mTag, msg, e);
        }
    }

    public static void e(String tag, String msg, Throwable e) {
        if (mDebug) {
            Log.e(tag, msg, e);
        }
    }

    public static void w(String msg) {
        if (mDebug) {
            Log.w(mTag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (mDebug) {
            Log.w(tag, msg);
        }
    }

    public static void w(Throwable e) {
        if (mDebug) {
            Log.w(mTag, "", e);
        }
    }

    public static void w(String tag, Throwable e) {
        if (mDebug) {
            Log.w(tag, "", e);
        }
    }

    public static void w(Throwable e, String msg) {
        if (mDebug) {
            Log.w(mTag, msg, e);
        }
    }

    public static void w(String tag, String msg, Throwable e) {
        if (mDebug) {
            Log.w(mTag, msg, e);
        }
    }

    public static void wtf(String msg) {
        if (mDebug) {
            Log.wtf(mTag, msg);
        }
    }

    public static void wtf(String tag, String msg) {
        if (mDebug) {
            Log.wtf(tag, msg);
        }
    }

    public static void wtf(Throwable e) {
        if (mDebug) {
            Log.wtf(mTag, "", e);
        }
    }

    public static void wtf(String tag, Throwable e) {
        if (mDebug) {
            Log.wtf(tag, "", e);
        }
    }

    public static void wtf(Throwable e, String msg) {
        if (mDebug) {
            Log.wtf(mTag, msg, e);
        }
    }

    public static void wtf(String tag, String msg, Throwable e) {
        if (mDebug) {
            Log.wtf(tag, msg, e);
        }
    }
}