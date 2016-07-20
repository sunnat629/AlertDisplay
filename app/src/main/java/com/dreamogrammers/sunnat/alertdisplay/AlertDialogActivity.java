package com.dreamogrammers.sunnat.alertdisplay;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.dreamogrammers.sunnat.alertdisplay.R.array.cities;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

    }

    /**
     * This is the simple alert dialog with three buttons.
     */
    public void simpleAlert(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // This is responsible for sowing the icon
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher);

        // This is responsible for sowing the title
        alertDialogBuilder.setTitle("Alert Dialog");

        // This is responsible for sowing the message
        alertDialogBuilder.setMessage("This is a simple alert dialog.");

        // if you remove this or replace with the TRUE then This dialog will disappear if you click outside of the box
        alertDialogBuilder.setCancelable(false);

        // This button is responsible for POSITIVE reason, like OK, YES, DISAGREE, BACK etc.
        alertDialogBuilder.setPositiveButton("Positive", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(getApplicationContext(), "You clicked POSITIVE button", Toast.LENGTH_LONG).show();
            }
        });

        // This button is responsible for NEGATIVE reason, like CANCEL, NO, DISAGREE, BACK etc.
        alertDialogBuilder.setNegativeButton("Negative", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You clicked NEGATIVE button", Toast.LENGTH_LONG).show();
            }
        });

        // This button is optional most of the time; but you can use this for BACK option.
        alertDialogBuilder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You clicked NEUTRAL button", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    /**
     * This is an alert dialog with a EditText to get a String.
     */
    public void alertWithEditText(View view) {
        // Get edittext_alert.xml view
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.edittext_alert, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // set edittext_alert.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView.findViewById(R.id.input_name);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Submit",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // get user input and set it to result
                                // edit text
                                ((TextView) findViewById(R.id.Namedisplay)).setText(userInput.getText());
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }

    /**
     * This is an alert dialog with a Listview to select a String from the list.
     */
    public void showAlertDialogWithListview(View view) {

        // The array of cities comes from string.xml
        final String[] citiesArr = getResources().getStringArray(cities);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher);
        alertDialogBuilder.setTitle("Cities");
        alertDialogBuilder.setItems(citiesArr, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {

                String selectedText = citiesArr[item].toString();  //Selected item in listview
                ((TextView) findViewById(R.id.Namedisplay_list)).setText(selectedText);
            }
        });
        //Create alert dialog object via builder
        AlertDialog alertDialogObject = alertDialogBuilder.create();
        //Show the dialog
        alertDialogObject.show();
    }

    /**
     * This is an alert dialog with Multiple Choice to select an array of String.
     */
    public void showAlertDialogWithMultipleChoice(View view) {

        final List<String> mSelectedItems = new ArrayList();  // Where we track the selected items
        final String[] citiesArr = getResources().getStringArray(cities);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // Set the dialog title
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher);
        alertDialogBuilder.setTitle("Cities")
                // Specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive callbacks when items are selected
                .setMultiChoiceItems(citiesArr, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    mSelectedItems.add(citiesArr[which]);
                                } else if (mSelectedItems.contains(which)) {
                                    // Else, if the item is already in the array, remove it
                                    mSelectedItems.remove(Integer.valueOf(which));
                                }
                            }
                        })
                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK, so save the mSelectedItems results somewhere
                        // or return them to the component that opened the dialog
                        ((TextView) findViewById(R.id.namedisplay_multiplechoice)).setText(mSelectedItems.toString());
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        AlertDialog alertDialogObject = alertDialogBuilder.create();
        //Show the dialog
        alertDialogObject.show();

    }


    /**
     * This is an alert dialog with a Radio Button to select a String from the list.
     * Listview is better than this Radio Button
     */
    public void showAlertDialogWithRadioButton(View view){

        final String[] citiesArr = getResources().getStringArray(cities);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher);
        alertDialogBuilder.setTitle("Select a City");
        alertDialogBuilder.setSingleChoiceItems(citiesArr, -1, new DialogInterface
                .OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                ((TextView) findViewById(R.id.namedisplay_radiobttn)).setText(citiesArr[item]);
                dialog.dismiss();
            }
        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
}
