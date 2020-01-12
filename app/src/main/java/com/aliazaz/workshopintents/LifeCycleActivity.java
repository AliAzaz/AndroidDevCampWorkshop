package com.aliazaz.workshopintents;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class LifeCycleActivity extends AppCompatActivity {

    private static final String TAG = LifeCycleActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        Log.i(TAG, "onCreate: event");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: event");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: event");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: event");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: event");
    }
}
