package com.jobdispather.services;

import android.os.Handler;
import android.util.Log;

/**
 * Created by Ashok on 1/16/2019.
 */

public class MyJobService extends com.firebase.jobdispatcher.JobService {

    private String TAG = MyJobService.class.getSimpleName();
    private Handler handler;
    private Runnable runnable;

    @Override
    public boolean onStartJob(com.firebase.jobdispatcher.JobParameters job) {
        Log.d(TAG, "onStartJob: ");
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: ");
                handler.postDelayed(runnable, 1000);
            }
        };
        handler.postDelayed(runnable, 1000);

        return false;
    }

    @Override
    public boolean onStopJob(com.firebase.jobdispatcher.JobParameters job) {
        Log.d(TAG, "onStopJob: ");
        return false;
    }
}
