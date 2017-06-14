package ware.com.luch_androidtool;

import android.util.Log;

/**
 * The Log unified management class
 *
 * @author luch
 */
public class L {

    private static final String TAG = "PAY++";
    // If you need to print a bug, you can initialize it in the application's onCreate function
    public static boolean isDebug = true;

    private L() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void i(String msg) {
        if (isDebug) {
            Log.i(TAG, StringUtils.object2String(msg));
        }
    }

    public static void d(String msg) {
        if (isDebug) {
            Log.d(TAG, StringUtils.object2String(msg));
        }
    }

    public static void e(String msg) {
        if (isDebug) {
            Log.e(TAG, StringUtils.object2String(msg));
        }
    }

    public static void v(String msg) {
        if (isDebug) {
            Log.v(TAG, StringUtils.object2String(msg));
        }
    }


    public static void i(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, StringUtils.object2String(msg));
        }
    }

    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, StringUtils.object2String(msg));
        }
    }

    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, StringUtils.object2String(msg));
        }
    }

    public static void v(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, StringUtils.object2String(msg));
        }
    }

    public static void print(String msg) {
        if (isDebug) {
            System.out.println(StringUtils.object2String(msg));
        }
    }

    public static void print(Boolean msg) {
        if (isDebug) {
            System.out.println(StringUtils.object2String(msg));
        }
    }

    public static void print(int msg) {
        if (isDebug) {
            System.out.println(StringUtils.object2String(msg));
        }
    }
}