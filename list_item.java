package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

public class list_item extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item2);
        list_items = new ArrayList<HashMap<String, String>>();
        for(int i=0;i<10;i++){
            HashMap<String,String>map=new HashMap<String, String>();
            map.put("ItemTitle","Rate:"+i);
            map.put("ItemDetail","datail"+i);
            list_items.add(map);
        }
        listItemAdapter=new SimpleAdapter(this,
                listitems,
                R.layout.activity_list_item,
                new String[]{"ItemTitle","ItemDetail"},
                new int[]{R.id.itemTitle,R.id.itemDetail}
        );
    }
}
