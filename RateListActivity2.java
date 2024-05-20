package com.example.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RateListActivity2 extends AppCompatActivity {

    ListView listView;
    Handler handler;

    @Override
    public void handleMessage(@NonNull Message msg){
        if (msg.what==5){
            Bundle bundle =(Bundle) msg.obj;
            ArrayList<String> relist =bundle.getStringArrayList("mylist");
            ListAdapter adapter=new ArrayAdapter<String>(RateListActivity.this, android.R.layout.simple_list_item_1,relist);

            //绑定
            setListAdapter(adapter);
        }
        super.handleMessage(msg);
    }
    public void onclick(View btn){
        //启动线程
    }
}