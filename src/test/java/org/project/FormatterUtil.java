package org.project;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatterUtil {

    private static SimpleDateFormat TIME_UTIL = new SimpleDateFormat("HH-mm-ss");
    private static SimpleDateFormat DATE_UTIL = new SimpleDateFormat("yyyy-MM-dd");


    public SimpleDateFormat getTimeUtil() {
        return this.TIME_UTIL;
    }

    public SimpleDateFormat getDateUtil() {
        return this.DATE_UTIL;
    }

    public String getCurrentTime() {
        return this.TIME_UTIL.format(new Date());
    }

    public String getCurrentDate() {
        return this.DATE_UTIL.format(new Date());
    }
}
