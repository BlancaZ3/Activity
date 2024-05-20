package com.example.activity;


import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//计算汇率以及改变汇率程序
public class MoneyActivity extends AppCompatActivity {
    //初始变量，设为全局，方便更改
    double rateDollar = 1.1, rateEuro = 1.2, rateWon = 1.3;

    public double changeDouble(String s) {
        //处理函数，将浮点数转为保留两位的浮点数
        double res;
        res = Double.parseDouble(String.format("%.2f", Double.parseDouble(s)));
        return res;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        //如果接收到数据，那么说明进行了改变汇率的操作，进行汇率的保存
        //Intent tent = getIntent();
        //if(tent.getStringExtra("rateDollar") != null) getChangeRate();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 569 && resultCode == 547) {
            rateDollar = changeDouble(data.getStringExtra("rateDollar"));
            rateEuro = changeDouble(data.getStringExtra("rateEuro"));
            rateWon = changeDouble(data.getStringExtra("rateWon"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /*
    public void getChangeRate() {
        //对改变汇率的请求进行保存
        Intent tent = getIntent();
        Log.i(TAG, "getChangeRate: ok");
        rateDollar = changeDouble(tent.getStringExtra("rateDollar"));
        rateEuro = changeDouble(tent.getStringExtra("rateEuro"));
        rateWon = changeDouble(tent.getStringExtra("rateWon"));
    }
    */

    public void configbtu(View v) {
        //跳转改变汇率界面
        Intent tent = new Intent(this, RateChangeActivity.class);

        //传输原始数据，一是方便打印，二是处理输入为空的情况
        tent.putExtra("rateDollar", rateDollar);
        tent.putExtra("rateEuro", rateEuro);
        tent.putExtra("rateWon", rateWon);

    }

    public void moneybtu(View v) {
        //没有转之前是范式，所以不能进行findViewById(R.id.inputmon).getText()的操作
        EditText mon = findViewById(R.id.inputmon);
        String monS = mon.getText().toString();

        //输入为空的处理，提示界面
        if(monS.length() == 0) {
            Toast.makeText(this, "请输入金额后转换", Toast.LENGTH_LONG).show();
            return;
        }

        //获取输入金额得出答案
        int id = v.getId();
        double res = 0;
        if(id == R.id.btu_dollar) res = Double.parseDouble(monS) * rateDollar;
        else if(id == R.id.btu_euro) res = Double.parseDouble(monS) * rateEuro;
        else res = Double.parseDouble(monS) * rateWon;

        TextView changemon = findViewById(R.id.monchange);
        changemon.setText(String.valueOf(String.format("%.2f", res)));

    }

};

