package ru.sorkirill.myhomework.jobs;

import android.app.Notification;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

import com.example.onrename.notifications.NotificationsManager;


public class SheduleJobsService extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {


        switch (params.getJobId()){
            case 1:
                Toast.makeText(this, "Start Time Job 1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
               Toast.makeText(this, "Start Time Job 2", Toast.LENGTH_SHORT).show();
            break;
        }
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }






}
