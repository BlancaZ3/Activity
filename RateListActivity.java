package com.example.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class RateListActivity extends AppCompatActivity {

    private static final String TAG = "RateListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //准备数据
        String[] data ={"hello","android","studio","listview"};
        List<String> list_data = new ArrayList<String>(100);
        for(int i=1;i<=100;i++){
            list_data.add("Item"+i);
        }

        Handler handler = new Handler(Looper.myLooper()){
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
        };

        //构造适配器
        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list_data);

        //绑定
        ListView.setAdapter(adapter);

        //开启线程

        Thread t = new Thread(new MyTask(handler));
        t.start();
        Log.i(TAG,"oncreate:启动线程");
    }
}