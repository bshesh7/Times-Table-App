package com.example.timestableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTablesListView;
    private void generateTimesTable(int timesTableNumber) {
        ArrayList<String> timesTableContent = new ArrayList<String>();
        for(int j=1;j<=10;j++){
            timesTableContent.add(Integer.toString(j*timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timesTableContent);
        timesTablesListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTableSeekBar = findViewById(R.id.timesTableSeekBar);
        timesTablesListView = findViewById(R.id.timesTableListView);

        int max = 20;
        int startingPosition = 10;
        timesTableSeekBar.setMax(max);
        timesTableSeekBar.setProgress(startingPosition);

        generateTimesTable(startingPosition);
        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                int min = 1;
                int timesTableNumber;

                if(i<min){
                    timesTableNumber = min;
                    timesTableSeekBar.setProgress(min);
                }else{
                    timesTableNumber = i;
                }
                Log.i("seekbar value", Integer.toString(timesTableNumber));
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
