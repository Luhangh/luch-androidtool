package ware.com.luch_androidtool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Creator lh on 2017/3/31 15:52.
 * Email:luchefg@gamil.com
 * Description: String manipulation toolkit
 */

public class StringUtils {
    private final static Pattern emailer = Pattern
            .compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
    // private final static SimpleDateFormat dateFormater = new
    // SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // private final static SimpleDateFormat dateFormater2 = new
    // SimpleDateFormat("yyyy-MM-dd");

    private final static ThreadLocal<SimpleDateFormat>
            dateFormater = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    private final static ThreadLocal<SimpleDateFormat>
            dateFormater2 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static boolean isNotEmpty(String s) {
        return s != null && !"".equals(s.trim());
    }


    /**
     * Type the string translocation date
     */
    public static Date toDate(String sdate) {
        try {
            return dateFormater.get().parse(sdate);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * The current time is accurate to milliseconds
     *
     * @return boolean
     */
    public static String longdate() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss:SSS");
        return formatter.format(new Date());
    }

    /**
     * The current time is accurate to the number of milliseconds and is converted to date
     *
     * @return boolean
     */
    public static Date longdate2() {
        Date time = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss:SSS");
        try {
            time = formatter.parse(formatter.format(new Date()));
        } catch (ParseException e) {
        }
        return time;
    }

    /**
     * Determine whether a given string time is today
     *
     * @return boolean
     */
    public static boolean isToday(String sdate) {
        boolean b = false;
        Date time = toDate(sdate);
        Date today = new Date();
        if (time != null) {
            String nowDate = dateFormater2.get().format(today);
            String timeDate = dateFormater2.get().format(time);
            if (nowDate.equals(timeDate)) {
                b = true;
            }
        }
        return b;
    }

    /**
     * Determine whether the String array is empty
     *
     * @return boolean
     */
    public static boolean isNull(String[] v) {
        for (int i = 0; i < 5; i++) {
            if (v[i] != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determine whether a given string is a blank string.A blank string is a string that consists of Spaces,
     * tabs, carriage returns, newline characters,and returns true if the input string is null or empty string
     *
     * @return boolean
     */
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input)) {
            return true;
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }

    /**
     * Determine whether a legitimate E-mail address is valid
     */
    public static boolean isEmail(String email) {
        if (email == null || email.trim().length() == 0) {
            return false;
        }
        return emailer.matcher(email).matches();
    }

    /**
     * String integer
     */
    public static int toInt(String str, int defValue) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
        }
        return defValue;
    }

    /**
     * Object to turn the integer
     *
     * @return int : 0
     */
    public static int toInt(Object obj) {
        if (obj == null) {
            return 0;
        }
        return toInt(obj.toString(), 0);
    }

    /**
     * Object to turn the long
     *
     * @return obj
     */
    public static long toLong(String obj) {
        try {
            return Long.parseLong(obj);
        } catch (Exception e) {
        }
        return 0;
    }

    /**
     * String transboolean value
     *
     * @return true : false
     */
    public static boolean toBool(String b) {
        try {
            return Boolean.parseBoolean(b);
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * Turn the string lowercase to uppercase (including the number)
     */

    public static String exChange(String str) {
        StringBuffer sb = new StringBuffer();
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (Character.isUpperCase(c)) {
                    sb.append(Character.toLowerCase(c));
                } else if (Character.isLowerCase(c)) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }

    /**
     * Hide the asterisk in the middle of the string
     *
     * @param start From which one began to hide
     * @param end   The last few
     */
    public static String hideString(String str, int start, int end) {
        if (start < 0 || end < 0) {
            return str;
        } else if ((start + end) > str.length()) {
            return str;
        } else {
            int length = str.length();
            String strStart = str.substring(0, start);
            String strMid = str.substring(start, length - end);
            String strEnd = str.substring(start + strMid.length(), length);
            StringBuffer s = new StringBuffer();
            for (int i = 0; i < strMid.length(); i++) {
                s.append("*");
            }
            return strStart + s.toString() + strEnd;
        }
    }

    /**
     * Determine if the object calling the toString method is null to avoid the null pointer exception
     *
     * @return If the passed parameter is null, return an empty string, otherwise return obj. ToString ()
     *
     * Null can be understood as a primitive type and it is only a special rule to have null as a parameter
     */
    public static String object2String(Object obj) {
        String str;
        try {
            str = obj == null ? "" : obj.toString();
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }

        return str;
    }

    /**
     * Use regular expressions to change the middle four of the phone number****
     * @return String
     */
    public String Phonexx(String input) {
        return input.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    public static <T> T checkNotNull(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        return obj;
    }

}
