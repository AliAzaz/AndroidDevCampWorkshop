package com.aliazaz.workshopintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.aliazaz.workshopintents.Constants.REPLY_MESSAGE;
import static com.aliazaz.workshopintents.Constants.SEND_MESSAGE;

public class SecondActivity extends AppCompatActivity {

    TextView labelMRecv, msgRecv;
    private Button btnReply;
    private EditText txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initialize();
        listeners();

        msgRecv.setText(getIntent().getStringExtra(SEND_MESSAGE));

    }

    private void initialize() {
        btnReply = findViewById(R.id.btnReply);
        txtMessage = findViewById(R.id.txtMessage);
        labelMRecv = findViewById(R.id.labelMRecv);
        msgRecv = findViewById(R.id.msgRecv);
    }

    private void listeners() {
        btnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondIntent = new Intent();
                secondIntent.putExtra(REPLY_MESSAGE, txtMessage.getText().toString());
                setResult(RESULT_OK, secondIntent);
                finish();
            }
        });
    }
}
