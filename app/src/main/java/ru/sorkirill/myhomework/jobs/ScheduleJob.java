package ru.sorkirill.myhomework.jobs;

import android.app.NotificationManager;
import android.support.annotation.NonNull;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.support.PersistableBundleCompat;
import ru.sorkirill.myhomework.notifications.NotificationsManager;

public class ScheduleJob extends Job {

    @NonNull
    @Override
    protected Result onRunJob(@NonNull Params params) {

        PersistableBundleCompat persistableBundleCompat = params.getExtras();

        String titleString = persistableBundleCompat.getString("titleString", "titleString default");
        String msgString = persistableBundleCompat.getString("msgString", "msgString default");
        String bodyString = persistableBundleCompat.getString("bodyString", "bodyString default");

        NotificationsManager.showNotification(getContext(), 1, titleString, msgString, bodyString);
        return Result.SUCCESS;

    }

    public static void scheduleMe(long time, PersistableBundleCompat persistableBundleCompat) {
        new JobRequest.Builder(ScheduleJobCreator.SCHEDULE_TAG)
                //.setExtras(PersistableBundleCompat.fromXml(persistableBundleCompat.getString("msgString", "msgString"))) /*не понял как пользоваться*/
                .addExtras(persistableBundleCompat)
                .setExact(time)
                .build()
                .schedule();

    }
}


/*
*
* чтобы запустить
                JobScheduler jobScheduler = (JobScheduler) getApplicationContext().getSystemService(Context.JOB_SCHEDULER_SERVICE);
                ComponentName componentName = new ComponentName(v.getContext(), SheduleJobsService.class);//для системы

                JobInfo startJobInfo = new JobInfo.Builder(1, componentName).setMinimumLatency(startTimeMillis).build();
                JobInfo endJob = new JobInfo.Builder(2, componentName).setMinimumLatency(endTimeMiliis).build();


                int firstJob = jobScheduler.schedule(startJobInfo);
                int secondJob = jobScheduler.schedule(endJob);

                jobScheduler.schedule(startJobInfo);
                jobScheduler.schedule(endJob);
*
* */