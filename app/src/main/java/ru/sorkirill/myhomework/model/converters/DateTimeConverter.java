package ru.sorkirill.myhomework.model.converters;

import android.arch.persistence.room.TypeConverter;
import android.text.TextUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeConverter {
    private static final DateFormat EVENT_DATE = new SimpleDateFormat("dd MM yyyy HH:mm ", Locale.getDefault());

    @TypeConverter
    public Date toDate(String date) {
        try {
            if (!TextUtils.isEmpty(date)) {
                return EVENT_DATE.parse(date);
            } else {
                return new Date();
            }
        } catch (Throwable throwable) {
            return new Date();
        }
    }

    @TypeConverter
    public String toString(Date date) {
        if (date != null) {
            return EVENT_DATE.format(date);
        } else {
            return "";
        }
    }

}
