package com.example.user.smslist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] array = {"Azercell","Zara","Bershka","NarMobile","Saab", "Volvo", "BMW","Banana", "Orange", "Apple", "Mango"};
    private ArrayList<String> smsArrayList ;
    private ListView mySmsList;
    private ArrayAdapter arrayAdapter;
    private ImageView smsImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smsArrayList = new ArrayList<String>();
        mySmsList = (ListView) findViewById(R.id.mySmsList);

        for (String sms:array) {
            smsArrayList.add(sms);
        }

        arrayAdapter = new ArrayAdapter(this,R.layout.activity_my_sms_view,R.id.smsContent,smsArrayList);
        mySmsList.setAdapter(arrayAdapter);

        mySmsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                smsImg = (ImageView) view.findViewById(R.id.smsImg);
                smsImg.setImageResource(R.drawable.open);

                Intent smsViewIntent = new Intent(MainActivity.this,MyMessageView.class);
                smsViewIntent.putExtra("mySms",smsArrayList.get(i));
                startActivity(smsViewIntent);
            }
        });

    }
}
