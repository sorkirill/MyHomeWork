package ru.sorkirill.myhomework.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface EventDao {

    @Query("SELECT * FROM Event")  //операции с бд
    List<Event> getAll();
    @Query("SELECT * FROM Event WHERE id = :id")
    Event getById(long id);
    @Insert
    void insert(Event event);
    @Update
    void update(Event event);
    @Delete
    void delete(Event event);
}
