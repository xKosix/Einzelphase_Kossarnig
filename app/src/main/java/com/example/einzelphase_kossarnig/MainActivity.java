package com.example.einzelphase_kossarnig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //speichern der verschiedenen Komponenten als variablen
        TextView response = findViewById(R.id.textView);
        EditText mtnr = (EditText) findViewById(R.id.editTextNumber);
        Button button_send_Mtnr = findViewById(R.id.sendMat);
        Button quersumme = findViewById(R.id.calculateMat);



    }
}