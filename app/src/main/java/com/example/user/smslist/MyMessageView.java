package com.example.user.smslist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyMessageView extends AppCompatActivity {
    private TextView mySms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_message_view);

        mySms = (TextView) findViewById(R.id.mySms);

        Intent intent = getIntent();
        String messageText = intent.getStringExtra("mySms");
        mySms.setText(messageText);
    }

}
