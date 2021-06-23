package com.example.android.multiplicationntimes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public void generateTimesTable (int timesTableNumber){
        ListView timesTableListView = findViewById(R.id.listView);
        ArrayList<String> timesTableContent = new ArrayList<String>();
        for (int j =1; j<=10; j++){
            timesTableContent.add(Integer.toString(j * timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, R.layout.row, timesTableContent);
        timesTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar timesTableSeekBar = findViewById(R.id.seekBar);
        ListView timesTableListView = findViewById(R.id.listView);

        int max = 50;
        int startingPosition = 1;
        timesTableSeekBar.setMax(max);
        timesTableSeekBar.setProgress(startingPosition);
        generateTimesTable(startingPosition);
        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTableNumber;
                if (i< min) {
                    timesTableNumber = min;
                    timesTableSeekBar.setProgress(min);
                }else {
                    timesTableNumber = i;
                }
                generateTimesTable(timesTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}