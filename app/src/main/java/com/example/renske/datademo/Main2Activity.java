package com.example.renske.datademo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

public class Main2Activity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize views
        editText = (EditText) findViewById(R.id.editText);

        loadFromSharedPrefs();
    }

    /* Add things to sharedprefs */
    public void saveToSharedPrefs(View view) {

        String editTextValue = editText.getText().toString();

        SharedPreferences prefs = this.getSharedPreferences("settings", this.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("editText", editTextValue);
        editor.commit();

    }

    /* Fetch data from sharedPreferences */
    public void loadFromSharedPrefs(){

        SharedPreferences prefs = this.getSharedPreferences("settings", this.MODE_PRIVATE);

        String editTextValueRestored = prefs.getString("editText", null);

        if(editTextValueRestored != null){
            editText.setText(editTextValueRestored);
        }
    }


    public void makeIntent(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
