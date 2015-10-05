package com.example.kurs.whrungsrechner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Klassenvariablen
    private EditText _eingabe;
    private Spinner _ausgangsWaehrung;
    private Spinner _zielWaehrung;
    private Button _berechnen;
    private TextView _ergebnis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Suchen der UI Elemente
        _eingabe = (EditText) findViewById(R.id.Eingabewert);
        _ausgangsWaehrung = (Spinner) findViewById(R.id.Ausgangswaehrung);
        _zielWaehrung = (Spinner) findViewById(R.id.Zielwaehrung);
        _berechnen = (Button) findViewById(R.id.Berechnen);
        _ergebnis = (TextView) findViewById(R.id.Ergebnis);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Registrieren von Events
        _berechnen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _ergebnis.setText(_eingabe.getText());
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Deregistrieren von Events
        _berechnen.setOnClickListener(null);
    }
}
