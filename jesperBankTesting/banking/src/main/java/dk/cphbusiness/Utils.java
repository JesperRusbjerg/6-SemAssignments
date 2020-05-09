package dk.cphbusiness;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String convertFromEpochToDate(long date){
        Date dates = new Date(date*1000);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(dates);
        return strDate;
    }

    public static long getEpochTime(){
     return System.currentTimeMillis()/1000;
    }

}
