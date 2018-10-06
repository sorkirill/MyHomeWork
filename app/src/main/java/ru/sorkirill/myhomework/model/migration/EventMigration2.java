package ru.sorkirill.myhomework.model.migration;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;

public class EventMigration2 extends Migration {

    public EventMigration2() {
        super(1,2);
    }

    @Override
    public void migrate(@NonNull SupportSQLiteDatabase database) {
        database.execSQL("ALTER TABLE event ADD COLUMN startDate TEXT");
        database.execSQL("ALTER TABLE event ADD COLUMN endDate TEXT");
    }
}
