package com.aliazaz.workshopintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView lstMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        settingValue();
        settingListener();
    }

    private void settingListener() {
        lstMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {

                    case 0:
                        startActivity(new Intent(MainActivity.this, FirstActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, ImplicitActivity.class));
                        break;
                }
            }
        });
    }

    private void settingValue() {
        lstMenu.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                Arrays.asList("Explicit Intent", "Implicit Intent")));
    }

    private void initialize() {
        lstMenu = findViewById(R.id.lstMenu);
    }
}
