package com.example.kurs.whrungsrechner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Klassenvariablen
    private EditText _inputValue;
    private Spinner _inputCurrency;
    private Spinner _outputCurrency;
    private Button _calculateCommand;
    private EditText _outputResult;

    // Wahrungskurse
    private double[] _currencyRates = {
            1.0,    // EUR
            1.06,   // USD
            1.18,   // CHF
            0.96,   // GBP
            45.0    // RUB
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sucher der Oberflächenelemente
        _inputValue = (EditText) findViewById(R.id.InputValue);
        _inputCurrency = (Spinner) findViewById(R.id.InputCurrency);
        _outputCurrency = (Spinner) findViewById(R.id.OutputCurrency);
        _calculateCommand = (Button) findViewById(R.id.CalculateCommand);
        _outputResult = (EditText) findViewById(R.id.ResultOutput);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Registrierung der Events
        _calculateCommand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this, "Klicked!!!", Toast.LENGTH_LONG).show();
                calculateResult();
            }
        });
    }

    private void calculateResult() {
        // Auslesen der Eingabe
        String inputString = _inputValue.getText().toString();

        // Überprüfen, ob Text da ist
        if(inputString == null || inputString.isEmpty()){
            return;
        }

        // String in numerischen Wert konvertieren
        double input = Double.parseDouble(inputString);

        // Bestimmen der ausgewählten Währung
        int inputIndex = _inputCurrency.getSelectedItemPosition();
        int outputIndex = _outputCurrency.getSelectedItemPosition();

        // Währungskurse bestimmen
        double inputRate = _currencyRates[inputIndex];
        double outputRate = _currencyRates[outputIndex];

        // Berechnen des Ergebnisses
        double result = input / inputRate * outputRate;

        // Ergebnis ausgeben
        _outputResult.append(String.valueOf(result));
        _outputResult.append("\n");
        //_outputResult.setText(String.valueOf(result));
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Deregistrieren der Events
        _calculateCommand.setOnClickListener(null);
    }








}
