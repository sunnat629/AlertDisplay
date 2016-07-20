package com.dreamogrammers.sunnat.alertdisplay;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;

import com.mikhaellopez.circularfillableloaders.CircularFillableLoaders;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class CircularProgressButton extends AppCompatActivity {
    ProgressDialog progressDialog;
    CircularProgressBar circularProgressBar;
    CircularFillableLoaders circularFillableLoaders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_progress_button);

        circularProgressBar = (CircularProgressBar)findViewById(R.id.CustomCircularProgressbar);
        circularFillableLoaders = (CircularFillableLoaders)findViewById(R.id.CProgressDialogwithImage);

        ((SeekBar) findViewById(R.id.seekBarCProgressDialogwithImage))
                .setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        circularFillableLoaders.setProgress(100-i);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

        ((SeekBar) findViewById(R.id.seekBarCProgressDialog))
                .setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        circularProgressBar.setProgress(i);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

    }


    public void showProgressDialog(View view) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Click outside of this display to exit.");
//        progressDialog.setProgressStyle(R.style.Custom);
        progressDialog.show();
    }

    // To see the animation of CProgressDialog, call this via a Button

    public void refreshCProgressDialog(View view) {
        circularProgressBar.setProgress(0);
        int animationDuration = 2000; // 2000ms = 2s
        circularProgressBar.setProgressWithAnimation(100, animationDuration);
    }

}
