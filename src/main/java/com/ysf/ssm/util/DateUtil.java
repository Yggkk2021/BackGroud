package com.ysf.ssm.util;


import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by Tars on 2017/11/18
 */
public class DateUtil {
    /**
     * 格式化时间
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date, String format){
        String result = "";
        //SimpleDateFormat是用来格式化日期的
        SimpleDateFormat sdf = new SimpleDateFormat( format );
        if(date != null){
            result = sdf.format( date );
        }
        return result;
    }

    public static Date formatString(String str,String format) throws ParseException {
        if(StringUtils.isEmpty(str)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(str);
    }

    public static String getCurrentDateStr() throws Exception {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
