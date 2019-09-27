package com.hfad.mymessenger;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Getting data from MainActivity
        Intent intent = getIntent();
        double ans = intent.getDoubleExtra("value", 0);
        double[] list = intent.getDoubleArrayExtra("values");
        String result = new Double(ans).toString();

        //Displaying results
        TextView tv = (TextView)findViewById(R.id.message);
        tv.setText("The result of your investment is: "+result);

        //Creating graph
        GraphView graph = (GraphView) findViewById(R.id.graph);
        DataPoint[] dp = new DataPoint[list.length];
        for(int i=0;i<list.length;i++){
            dp[i] = new DataPoint(i+1, list[i]);
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dp);
        graph.addSeries(series);
    };
}
