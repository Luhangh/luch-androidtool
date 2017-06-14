package ware.com.luch_androidtool;

import android.content.Context;
import android.widget.Toast;


/**
 * Toast unified management class
 */
public class Ts {

    public static boolean isShow = true;
    public static boolean isShowLOG = true;
    private Ts() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * Short time to display the Toast log
     */
    public static void showShortLog(Context context, CharSequence message) {
        if (isShowLOG && null != context) {
            Toast.makeText(context, "LOG==" + StringUtils.object2String(message),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * A short period of time shows the Toast
     */
    public static void showShort(Context context, CharSequence message) {
        if (isShow && null != context) {
            Toast.makeText(context, StringUtils.object2String(message), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * A short period of time shows the Toast
     */
    public static void showShort(Context context, int message) {
        if (isShow && null != context) {
            Toast.makeText(context, StringUtils.object2String(message + ""),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Display the Toast for a long time
     */
    public static void showLong(Context context, CharSequence message) {
        if (isShow && null != context) {
            Toast.makeText(context, StringUtils.object2String(message), Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Display the Toast for a long time
     */
    public static void showLong(Context context, int message) {
        if (isShow && null != context) {
            Toast.makeText(context, StringUtils.object2String(message + ""),
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * The custom displays the Toast time
     */
    public static void show(Context context, CharSequence message, int duration) {
        if (isShow && null != context) {
            Toast.makeText(context, StringUtils.object2String(message), duration).show();
        }
    }

    /**
     * The custom displays the Toast time
     */
    public static void show(Context context, int message, int duration) {
        if (isShow && null != context) {
            Toast.makeText(context, StringUtils.object2String(message + ""), duration).show();
        }
    }

    /**
     * A global display of Toast
     */
    public static void showMessage(String msg) {
        if (AppManager.getAppManager()==null)return;
        Toast.makeText(AppManager.getAppManager().currentActivity(), msg,
                Toast.LENGTH_SHORT).show();
    }
}