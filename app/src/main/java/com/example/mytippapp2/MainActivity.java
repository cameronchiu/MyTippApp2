/*
 * @project TippApp
 * @name Cameron Chiu
 * @teacher Denna
 * @period 5
 * @date 8/27/19
 */

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

    /*
       calculates the normal tip given a bill and a percentage; displays the tip and the total
     */
    public void calculateTip(View v){

        TextView TIP = (TextView) findViewById(R.id.textViewTip);
        EditText bill = (EditText) findViewById(R.id.editTextBill);
        EditText percentage = (EditText) findViewById(R.id.editTextPercentage);

        if(bill.getText().length()<=0||percentage.getText().length()<=0){
            TIP.setText("TIP:    TOTAL:");
        }

        else{
        double Bill = Double.parseDouble(bill.getText().toString());
        double Percentage = Double.parseDouble(percentage.getText().toString());
        double tip = 0;
        tip = Percentage*.01*Bill;
        TIP.setText("TIP: "+df.format(tip)+" TOTAL: "+df.format(tip+Bill));

        }

    }


    /*
      calculates the quality-based tip given a bill, a percentage, and a rating out of 5; displays the tip and the total
    */
    public void calculateQualityTip(View v){

        TextView TIP2 = (TextView) findViewById(R.id.textViewTip2);
        EditText bill2 = (EditText) findViewById(R.id.editTextBill2);
        EditText percentage2 = (EditText) findViewById(R.id.editTextPercentage2);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        if(bill2.getText().length()<=0||percentage2.getText().length()<=0){
            TIP2.setText("TIP:    TOTAL:");
        }

        else {

            double Bill2 = Double.parseDouble(bill2.getText().toString());
            double Percentage2 = Double.parseDouble(percentage2.getText().toString());
            double tip2 = 0;
            double extra = ratingBar.getRating();
            tip2 = (Percentage2 + .6 * extra) * .01 * Bill2;
            TIP2.setText("TIP: " + df.format(tip2) + " TOTAL: " + df.format(tip2 + Bill2));
        }
    }

    /*
       diplays a random message from an array filled with random acts of kindness
     */
    public void randomAct(View v){
        TextView message = (TextView) findViewById(R.id.textViewMessage);
        String[] acts = {"Tip your server 2 dollars more!","Buy an extra meal for a homeless person near you!",
                "Ask your server how their day was!","If you are out with friends, offer to pay!","Be kind to the planet and finish your leftovers!",
                "Have a conversation with your table without checking your phone!","Be nice to yourself and treat yourself with something more expensive! You deserve it!",
                "Start a conversation with your server!"};
        int random = (int)(Math.random()*8);
        message.setText(acts[random]);
    }
}
