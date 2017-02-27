package com.example.renske.datademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);


    }


    /* Create bundle when onSaveInstanceState is called. */
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        String textViewValue = textView.getText().toString();
        outState.putString("textView", textViewValue);

    }


    /* And do something with the bundle when the state is restored. */
    @Override
    public void onRestoreInstanceState(Bundle inState){
        super.onRestoreInstanceState(inState);

        String textViewValueRestored = inState.getString("textView");
        textView.setText(textViewValueRestored);

    }

    public void setText(View view) {

        String text = editText.getText().toString();
        textView.setText(text);

    }
}
