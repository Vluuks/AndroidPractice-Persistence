package com.example.renske.datademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Switch aSwitch; // switch is a protected name, you cannot use it since it also refers to an expression
    EditText editText;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editText = (EditText) findViewById(R.id.editText);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

    }


    /* Create bundle when onSaveInstanceState is called. */
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        // Get rating value
        int ratingBarValue = ratingBar.getNumStars();
        outState.putInt("ratingBar", ratingBarValue);

        // Get edittext value and add it to the bundle
        String editTextValue = editText.getText().toString();
        outState.putString("editText", editTextValue);

    }


    @Override
    public void onRestoreInstanceState(Bundle inState){
        super.onRestoreInstanceState(inState);

        // Extract values
        int ratingBarValue2 = inState.getInt("ratingBar");
        String editTextValue2 = inState.getString("editText");

        editText.setText(editTextValue2);
        ratingBar.setNumStars(ratingBarValue2);
    }
}
