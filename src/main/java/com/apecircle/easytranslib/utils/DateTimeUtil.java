package com.apecircle.easytranslib.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateTimeUtil {
    /**
     *
     * 转化毫秒时为显示时长
     * @param timeMillis 毫秒时
     * @return
     */
    public static String getDisplayLength(long timeMillis){
        long allSecond = timeMillis / 1000;
        long second = allSecond % 60;
        if (allSecond < 60) {
            return second + "秒";
        }
        long minute = allSecond / 60 % 60;
        if (allSecond < 60 * 60) {
            return minute + "分" + second + "秒";
        }
        long hour = allSecond / (60 * 60);
        return hour + "时"+ minute + "分" + second + "秒";
    }
}
