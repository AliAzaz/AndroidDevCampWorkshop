package com.aliazaz.workshopintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.aliazaz.workshopintents.Constants.REPLY_MESSAGE;
import static com.aliazaz.workshopintents.Constants.SEND_MESSAGE;
import static com.aliazaz.workshopintents.Constants.TEXT_REQUEST;

public class FirstActivity extends AppCompatActivity {

    TextView labelRRecv, repRecv;
    private Button btnSend;
    private EditText txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        initialize();
        listeners();
        dataSetting(savedInstanceState);
    }

    private void dataSetting(Bundle savedInstanceState) {

        if (savedInstanceState != null) {

            if (savedInstanceState.getBoolean("rep_visible")) {
                repRecv.setText(savedInstanceState.getString("rep_text"));
                labelRRecv.setVisibility(View.VISIBLE);
                repRecv.setVisibility(View.VISIBLE);

            }


        }

    }

    private void listeners() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent firstIntent = new Intent(FirstActivity.this, SecondActivity.class);
                firstIntent.putExtra(SEND_MESSAGE, txtMessage.getText().toString());
                startActivityForResult(firstIntent, TEXT_REQUEST);
            }
        });
    }

    private void initialize() {
        btnSend = findViewById(R.id.btnSend);
        txtMessage = findViewById(R.id.txtMessage);
        labelRRecv = findViewById(R.id.labelRRecv);
        repRecv = findViewById(R.id.repRecv);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {

            if (resultCode == RESULT_OK) {
                String msg = data.getStringExtra(REPLY_MESSAGE);
                repRecv.setText(msg);
                repRecv.setVisibility(View.VISIBLE);
                labelRRecv.setVisibility(View.VISIBLE);
            }

        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (labelRRecv.getVisibility() == View.VISIBLE) {
            outState.putBoolean("rep_visible", true);
            outState.putString("rep_text", repRecv.getText().toString());
        }

    }
}
