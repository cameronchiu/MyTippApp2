package com.example.mytippapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    DecimalFormat df = new DecimalFormat("$#####.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void calculateTip(View v){

        // the names of id are wrong, so empty string is causing an exception

        TextView TIP = (TextView) findViewById(R.id.textViewTIP);
        EditText bill = (EditText) findViewById(R.id.editTextBill);
        EditText percentage = (EditText) findViewById(R.id.editTextPercentage);

        double Bill = Double.parseDouble(bill.getText().toString());
        double Percentage = Double.parseDouble(percentage.getText().toString());
        double tip = 0;
        tip = Percentage*.01*Bill;
        TIP.setText("TIP: "+df.format(tip));

    }

    public void calculateQualityTip(View v){

        TextView TIP2 = (TextView) findViewById(R.id.textViewTIP2);
        EditText bill2 = (EditText) findViewById(R.id.editText2);
        EditText percentage2 = (EditText) findViewById(R.id.editTextPercentage2);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        double Bill2 = Double.parseDouble(bill2.getText().toString());
        double Percentage2 = Double.parseDouble(percentage2.getText().toString());
        double tip2 = 0;
        double extra = ratingBar.getRating();
        tip2 = Percentage2*.01*Bill2+extra;
        TIP2.setText("TIP: "+df.format(tip2));
    }
}
