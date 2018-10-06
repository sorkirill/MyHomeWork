package ru.sorkirill.myhomework;


import android.app.Application;
import android.arch.persistence.room.Room;


import com.evernote.android.job.JobManager;
import ru.sorkirill.myhomework.model.DataBase;
import ru.sorkirill.myhomework.jobs.ScheduleJobCreator;



public class App extends Application {

    public static App instance;

    private DataBase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, DataBase.class, "database").build();
        JobManager.create(this).addJobCreator(new ScheduleJobCreator());
    }

    public static App getInstance() {
        return instance;
    }

    public DataBase getDatabase() {
        return database;
    }
}



