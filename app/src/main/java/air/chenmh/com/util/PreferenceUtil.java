package air.chenmh.com.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 轻量级保存sp
 * Created by 陈苗辉 on 2017/5/7.
 */
public class PreferenceUtil {
    private static final String PREFS_NAME = "ONE-PLATFORM";
    public static void saveSession(Context c, String s) {
        SharedPreferences settings = c.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("session", s);
        editor.commit();
    }
    public static String getSession(Context c) {
        SharedPreferences settings = c.getSharedPreferences(PREFS_NAME, 0);
        return settings.getString("session", "");
    }

    public static void saveUsername(Context c,String s){
        SharedPreferences settings = c.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("user", s);
        editor.commit();
    }
    public static String getUsername(Context c){
        SharedPreferences settings = c.getSharedPreferences(PREFS_NAME, 0);
        return settings.getString("user", "");
    }

    public static void savePassword(Context c,String s){
        SharedPreferences settings = c.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("password", s);
        editor.commit();
    }
    public static String getPassword(Context c){
        SharedPreferences settings = c.getSharedPreferences(PREFS_NAME, 0);
        return settings.getString("password", "");
    }
}
