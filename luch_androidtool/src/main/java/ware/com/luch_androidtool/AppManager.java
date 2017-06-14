package ware.com.luch_androidtool;


import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;


/**
 * Application Activity management class: for Activity management and application exit
 */
public class AppManager {

    private static Stack<Activity> activityStack;
    private static AppManager instance;

    private AppManager() {
    }

    /**
     * A single instance
     */
    public static AppManager getAppManager() {
        if (instance == null) {
            instance = new AppManager();
        }
        return instance;
    }

    /**
     * The Activity is added to the stack
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
        Object[] obj = activityStack.toArray();
        for (int i = 0; i < obj.length; i++) {
            Activity acti = (Activity) obj[i];
        }
    }


    /**
     *Get the current Activity (the last one in the stack)
     */
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * End the current Activity (the last one in the stack)
     */
    public void finishActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * The end of the specified Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * End the Activity that specifies the class name
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }


    /**
     * End all activities except the first Activity page
     * Modify the delete sequence
     */
    public void finishActivityExceptFirst() {
        for (int i = 0; i < activityStack.size(); i++) {
            L.print("....." + activityStack.get(i).toString());
        }
        for (int i = activityStack.size(); i > 1; i--) {
            if (null != activityStack.get(i - 1)) {
                activityStack.get(i - 1).finish();
            }
        }
    }

    /**
     * Disable all activities except for the specified activity if the CLS do not exist in the stack,
     * the stack is completely empty
     */
    public void finishOthersActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (!(activity.getClass().equals(cls))) {
                finishActivity(activity);
            }
        }
    }

    /**
     * End all the Activity
     */
    public void finishAllActivity() {
        for (int i = activityStack.size(); i > 0; i--) {
        }
        for (int i = activityStack.size(); i > 0; i--) {

            if (null != activityStack.get(i - 1)) {
                activityStack.get(i - 1).finish();
            }
        }
        activityStack.clear();
        if (!activityStack.empty()) {
            for (int i = 0; i < activityStack.size(); i++) {
                L.print(activityStack.get(i).toString());
            }
        }
    }

    /**
     * Exit application
     */
    public void AppExit(Context context) {
        try {
            finishAllActivity();
            ActivityManager activityMgr = (ActivityManager) context.getSystemService(
                    Context.ACTIVITY_SERVICE);
            activityMgr.restartPackage(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
        }
    }
}