package com.example.renske.datademo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

public class Main2Activity extends AppCompatActivity {

    EditText editText;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize views
        editText = (EditText) findViewById(R.id.editText);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        loadFromSharedPrefs();
    }

    /* Add things to sharedprefs */
    public void saveToSharedPrefs(View view) {

        // Get rating value
        int ratingBarValue = ratingBar.getNumStars();

        // Get edittext value and add it to the bundle
        String editTextValue = editText.getText().toString();


        // Initialize sharedpreferences
        SharedPreferences prefs = this.getSharedPreferences("settings", this.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putInt("ratingBar", ratingBarValue);
        editor.putString("editText", editTextValue);


    }

    /* Haal de data op uit sharedPreferences */
    public void loadFromSharedPrefs(){

        // ALWAYS CHECK FOR NULL
        SharedPreferences prefs = this.getSharedPreferences("settings", this.MODE_PRIVATE);

        if(prefs != null) {
            int ratingBarValue2 = prefs.getInt("ratingBar", -1);
            String editTextValue2 = prefs.getString("editText", null);

            // Re set the values
            if(ratingBarValue2 != -1){
                ratingBar.setNumStars(ratingBarValue2);
            }
            if(editTextValue2 != null){
                editText.setText(editTextValue2);
            }
        }
    }
}
