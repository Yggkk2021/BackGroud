package com.ysf.ssm.util;

/**
 * Create by Tars on 2017/11/18
 */
public class StringUtil {

    public static boolean isEmpty(String str) {
        if(str == null || "".equals( str )) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        if ((str != null) && !"".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param str
     * @return
     */
    public static String formatLike(String str) {
        if (isNotEmpty(str)) {
            return "%" + str + "%";
        } else {
            return null;
        }
    }
}
