package com.mailchimp.automation.reports;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFunctions {

    private static final SimpleDateFormat format;

    static {
        format = new SimpleDateFormat("dd MMM, yyyy hh:mm:ss");
    }

    public static String dateToDayAndTime(Date date, boolean flug){
        return format.format(date);
    }

    public static String dateToDayAndTime(Date date){
        return  dateToDayAndTime(date, true);
    }

    public static String dateToDayAndTimeForFileName(Date date){
        return dateToDayAndTime(date);
    }
}
