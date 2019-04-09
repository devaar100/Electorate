package aarnav100.developer.electorateapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

public class Locality extends AppCompatActivity {

    LinearLayout linearLayout;
    int[] c = {1,2,3,4};
    String[] names = {"Male","Female","PwD","Third Gender"};
    int[] colors = new int[]{
            Color.rgb(51,102,204),
            Color.rgb(220,57,18),
            Color.rgb(255,153,0),
            Color.rgb(16,150,24),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locality);
        linearLayout = findViewById(R.id.parent);
        getSupportActionBar().setTitle("Shakur Basti - 1");
        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.google.com/maps/@28.7456736,77.1164689,16z";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        };
        findViewById(R.id.loc_dir).setOnClickListener(ocl);
        findViewById(R.id.loc_img).setOnClickListener(ocl);
        makeBarChart();
    }

    void makeBarChart(){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,600);
        HorizontalBarChart mChart = new HorizontalBarChart(this);
        mChart.setLayoutParams(params);

        mChart.animateY(1500);

        float barWidth = 40f;
        float spaceForBar = 50f;
        YAxis left = mChart.getAxisLeft();
        YAxis right = mChart.getAxisRight();
        XAxis axis = mChart.getXAxis();

        right.setDrawAxisLine(false);
        right.setDrawLabels(false);
        right.setDrawGridLines(false);
        left.setDrawGridLines(false);

        left.setGranularity(2);
        left.setAxisMinimum(0);

        axis.setDrawLabels(false);
        axis.setDrawGridLines(false);

        mChart.setFitBars(true);
        mChart.getDescription().setEnabled(false);
        mChart.getLegend().setCustom(new LegendEntry[]{});
        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        for (int i = 0; i < c.length; i++) {
            yVals1.add(new BarEntry(i * spaceForBar, c[i]));
        }

        BarDataSet set1;

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) mChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "");
            set1.setColors(colors);
            set1.setDrawIcons(false);

            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setBarWidth(barWidth);
            mChart.setData(data);
        }

        linearLayout.addView(mChart);

        for (int i = 0; i < names.length; i++) {
            View v = getLayoutInflater().inflate(R.layout.legend_view, null);
            v.findViewById(R.id.legend_sq).setBackgroundColor(colors[i]);
            String name = names[i];
            ((TextView)v.findViewById(R.id.legend_txt)).setText(name);
            linearLayout.addView(v);
        }
    }

}
