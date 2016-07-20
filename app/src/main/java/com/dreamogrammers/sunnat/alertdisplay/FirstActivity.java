package com.dreamogrammers.sunnat.alertdisplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    CoordinatorLayout coordinatorLayoutF;
    Button buttonToastSnack, buttonCircularProgress, buttonAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initializationForLayout();

        buttonToastSnack.setOnClickListener(this);
        buttonCircularProgress.setOnClickListener(this);
        buttonAlertDialog.setOnClickListener(this);
    }

    private void initializationForLayout() {
        coordinatorLayoutF = (CoordinatorLayout) findViewById(R.id.coordinatorLayoutF);
        buttonToastSnack = (Button) findViewById(R.id.buttonToastSnack);
        buttonCircularProgress = (Button) findViewById(R.id.buttonCircularProgress);
        buttonAlertDialog = (Button) findViewById(R.id.buttonAlertDialog);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.buttonToastSnack:
                Intent goToToastSnack = new Intent(this, ToastSnackbarActivity.class);
                startActivity(goToToastSnack);
                break;
            case R.id.buttonCircularProgress:
                Intent goToCircularProgressButton = new Intent(this, CircularProgressButton.class);
                startActivity(goToCircularProgressButton);
                break;

            case R.id.buttonAlertDialog:
                Intent goToAlertDialog = new Intent(this, AlertDialogActivity.class);
                startActivity(goToAlertDialog);
                break;
        }
    }
}
