package com.hfad.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Call onCalculate() when the button is clicked
    public void onCalculate(View view){

        //Transferring user input to doubles
        EditText p = (EditText)findViewById(R.id.investment);
        String text = p.getText().toString();
        double initial = Double.parseDouble(text);
        EditText r = (EditText)findViewById(R.id.rate);
        String text2 = r.getText().toString();
        double rate = Double.parseDouble(text2);
        EditText n = (EditText)findViewById(R.id.number);
        String text3 = n.getText().toString();
        double number = Double.parseDouble(text3);
        EditText t = (EditText)findViewById(R.id.years);
        String text4 = t.getText().toString();
        double years = Double.parseDouble(text4);

        //Creating array
        double[] list = new double[(int)years];

        //Calculations for base result
        double answer1 = (rate/number) + 1;
        double answer2 = (number*years);
        double answer3 = Math.pow(answer1,answer2);
        double answer = answer3 * initial;

        //Calculating additional results and putting them in the array
        for (int i = 0; i < years; i++){
            double answer4 = (rate/number) + 1;
            double answer5 = (number*years);
            double answer6 = Math.pow(answer4,answer5);
            double result = answer6 * initial;
            list[i] = result;
        }

        //Sending data to ResultActivity
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("value", answer);
        intent.putExtra("values", list);
        startActivity(intent);
    }
}
