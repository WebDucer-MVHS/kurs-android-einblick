package com.example.kurs.whrungsrechner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button _calculateButton;
    private TextView _source_value;
    private Spinner _source_currency;
    private Spinner _target_currency;
    private TextView _result_value;

    private final static double[] _currency_ratio = {
            1.0, // EUR
            1.12, // USD
            1.05, // CHF
            65.0, // RUB
            1.35 // GBP
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Suchen des Button im Layout
        _calculateButton = (Button) findViewById(R.id.w_caculate);

        // Andere Elemente suchen
        _source_value = (TextView) findViewById(R.id.w_source_value);
        _source_currency = (Spinner) findViewById(R.id.w_source_currency);
        _target_currency = (Spinner) findViewById(R.id.w_target_currency);
        _result_value = (TextView) findViewById(R.id.w_result);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Click-Event verarbeiten
        _calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
            }
        });
    }

    private void Calculate() {
        // Auslesen des Ausgangsbetrages
        String value = _source_value.getText().toString();

        // Prüfung des Wertes
        if(value == null || "".equals(value)){
            return;
        }

        // Konvertierung des Eingabewertes
        double sourceValue = Double.parseDouble(value);

        // Asulesen der ausgewählten Währungen
        int sourceCurrencyIndex = _source_currency.getSelectedItemPosition();
        int targetCurrencyIndex = _target_currency.getSelectedItemPosition();

        // Währungskurse bestimmen
        double sourceRatio = _currency_ratio[sourceCurrencyIndex];
        double targetRatio = _currency_ratio[targetCurrencyIndex];

        // Berechnung des Ergebnisses
        double resultValue = sourceValue / sourceRatio * targetRatio;

        // Ausgabe des Ergebnisses
        _result_value.setText(String.valueOf(resultValue));
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Click-Event deregistrieren
        _calculateButton.setOnClickListener(null);
    }
}
