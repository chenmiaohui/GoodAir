package air.chenmh.com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具
 * Created by 陈苗辉 on 2017/5/12.
 */
public class TimeUtil {

    private static final SimpleDateFormat YYYYMMDDHHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat HHMM = new SimpleDateFormat("HH:mm");
    //2100-00-00 00:00:00转成00:00
    public static final String getHourTime(String time){
        if (time==null||"".equals(time)){
            return "";
        }
        try {
            Date parse = YYYYMMDDHHMMSS.parse(time);
            return HHMM.format(parse);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}
