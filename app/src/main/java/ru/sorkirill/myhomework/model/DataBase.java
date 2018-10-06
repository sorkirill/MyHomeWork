package ru.sorkirill.myhomework.model;
//Описывает БД
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Event.class}, version = 2, exportSchema = false)
public abstract class DataBase extends RoomDatabase{
    public abstract EventDao eventDao();
}