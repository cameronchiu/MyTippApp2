package com.example.mytippapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    DecimalFormat df = new DecimalFormat("##%");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void calculateTip(View v){
        TextView TIP = (TextView) findViewById(R.id.textViewTIP);
        EditText bill = (EditText) findViewById(R.id.editTextBill);
        EditText percentage = (EditText) findViewById(R.id.editTextPercentage);

        double Bill = Double.parseDouble(bill.getText().toString());
        double Percentage = Double.parseDouble(percentage.getText().toString());
        double tip = 0;
        tip = Percentage*.01*Bill;
        TIP.setText(tip);

    }
}
