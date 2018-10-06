package ru.sorkirill.myhomework.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {

    private static final String PREFERENCES = "preferences";

    public static SharedPreferences getPreferences (Context context){
        return context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
    }

    public static SharedPreferences.Editor getEditor (Context context){
        return getPreferences(context).edit();
    }

    public static void putStrringPreferences(Context context, String key, String value){
        getEditor(context).putString(key,value).apply();
    }

    public static String getStringPreferences(Context context, String key){
        return getPreferences(context).getString(key, "");
    }
}
