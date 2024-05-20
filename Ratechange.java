package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.net.URL;

public class RateChangeActivity extends AppCompatActivity {
    double rateDollar, rateEuro, rateWon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        Intent tent = getIntent();
        rateDollar = tent.getDoubleExtra("rateDollar", 0);
        rateEuro = tent.getDoubleExtra("rateEuro", 0);
        rateWon = tent.getDoubleExtra("rateWon", 0);

        //获取对象
        TextView changeDollar = findViewById(R.id.change_dollar);
        TextView changeEuro = findViewById(R.id.changeeuro);
        TextView changeWon = findViewById(R.id.change_won);

        //写入当前汇率
        changeDollar.setText(String.valueOf(rateDollar));
        changeEuro.setText(String.valueOf(rateEuro));
        changeWon.setText(String.valueOf(rateWon));
    }


    public void changeSave(View v) {
        //获取对象
        TextView changeDollar = findViewById(R.id.change_dollar);
        TextView changeEuro = findViewById(R.id.changeeuro);
        TextView changeWon = findViewById(R.id.change_won);

        //获取修改值
        String rateDollarS = changeDollar.getText().toString();
        String rateEuroS = changeEuro.getText().toString();
        String rateWonS = changeWon.getText().toString();

        //如果修改内容不对，即空值，设为原来的值
        if (rateDollarS.length() == 0) rateDollarS = String.valueOf(rateDollar);
        if (rateEuroS.length() == 0) rateEuroS = String.valueOf(rateEuro);
        if (rateWonS.length() == 0) rateWonS = String.valueOf(rateWon);

        //传输回去
        Intent tent = new Intent(this, MoneyActivity.class);
        tent.putExtra("rateDollar", rateDollarS);
        tent.putExtra("rateEuro", rateEuroS);
        tent.putExtra("rateWon", rateWonS);

        //startActivity(tent);
        setResult(547, tent);
        finish();

    }
}
