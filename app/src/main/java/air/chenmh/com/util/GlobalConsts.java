package air.chenmh.com.util;

import air.chenmh.com.R;

/**
 * 获取数据提示
 * Created by 陈苗辉 on 2017/5/14.
 */
public class GlobalConsts {

    public static int getAqiStateDrawable(String aqiLevel){
        if (aqiLevel.equals("1")){
            return R.drawable.uicornerbg_air_level1;
        }
        if (aqiLevel.equals("2")) {
            return R.drawable.uicornerbg_air_level2;
        }
        if (aqiLevel.equals("3")) {
            return R.drawable.uicornerbg_air_level3;
        }
        if (aqiLevel.equals("4")) {
            return R.drawable.uicornerbg_air_level4;
        }
        if (aqiLevel.equals("5")) {
            return R.drawable.uicornerbg_air_level5;
        }
        if (aqiLevel.equals("6")) {
            return R.drawable.uicornerbg_air_level6;
        }
        return R.drawable.uicornerbg_air_level1;
    }

}
