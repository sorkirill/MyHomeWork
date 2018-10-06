package ru.sorkirill.myhomework.jobs;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

public class ScheduleJobCreator implements JobCreator {
    static final String SCHEDULE_TAG = "scheduleTag";

    @Nullable
    @Override
    public Job create(@NonNull String tag) {

        switch (tag) {
            case SCHEDULE_TAG:
                return new ScheduleJob();
            default:
                return null;
        }

    }
}

