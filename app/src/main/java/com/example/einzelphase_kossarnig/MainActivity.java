package com.example.einzelphase_kossarnig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
        Button Berechne = findViewById(R.id.calculateMat);

        button_send_Mtnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                response.setVisibility(View.VISIBLE);   //macht die anzeige für den Server status visible
                int mtnrInt = Integer.parseInt(mtnr.getText().toString());   // ließt die eingabe als int aus und speichert sie
                //String mtnrString = mtnr.getText().toString();
                RequestThread uniconnection = new RequestThread(Integer.toString(mtnrInt));
                uniconnection.start();
                try {
                    uniconnection.join();
                } catch (InterruptedException ie) {

                }
                response.setText("Der Server sagt: " + uniconnection.getAnswer());
            }
        });

        Berechne.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                response.setVisibility(View.VISIBLE);
                response.setText("Die Alternierende Quersummer von " + mtnr.getText().toString() + " ist: " +berechneMat(Integer.parseInt(String.valueOf(mtnr.getText()))));
            }

        });


    }

    private int berechneMat(int mtnr) {
        char[] digits = String.valueOf(mtnr).toCharArray();
        int sum = digits[0] - digits[1] + digits[2] - digits[3] + digits[4] - digits[5] + digits[6] - digits[7];

        return sum;
    }
}