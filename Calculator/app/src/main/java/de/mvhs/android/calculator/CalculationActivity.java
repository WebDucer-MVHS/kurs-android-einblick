package de.mvhs.android.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class CalculationActivity extends ActionBarActivity {
    // UI Elemente
    private EditText _inputValue = null;
    private Spinner _inputCurrency = null;
    private Spinner _outputCurrency = null;
    private Button _calculateButton = null;
    private TextView _outputValue = null;

    // Währungskurse zu Euro
    private final static double[] _currencyRates = {
            1.0,    // Euro zu Euro
            1.2,    // Euro zu USD
            1.02,   // Euro zu CHF
            1.40,   // Euro zu CAD
            50.0,   // Euro zu RUB
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        // Suchen der UI Elemente
        _inputValue = (EditText) findViewById(R.id.InputValue);
        _inputCurrency = (Spinner) findViewById(R.id.InputCurrency);
        _outputCurrency = (Spinner) findViewById(R.id.OutputCurrency);
        _calculateButton = (Button) findViewById(R.id.CalculateButton);
        _outputValue = (TextView) findViewById(R.id.OutputValue);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Registrieren des Button Click-Events (Listener)
        _calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClicked();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Deregistrieren der Listener
        _calculateButton.setOnClickListener(null);
    }

    private void onButtonClicked(){
        // Auslesen des Eingabewertes
        String inputStringValue = _inputValue.getText().toString();

        // Prüfen der Eingaben
        if(inputStringValue == null || inputStringValue.isEmpty()){
            return;
        }

        // Umwandeln des Strings in eine Zahl
        double inputValue = Double.parseDouble(inputStringValue);

        // Währungen bestimmen
        int inputCurrencyIndex = _inputCurrency.getSelectedItemPosition();
        int outputCurrencyIndex = _outputCurrency.getSelectedItemPosition();

        // Währungskurse bestimmen
        double inputRate = _currencyRates[inputCurrencyIndex];
        double outputRate = _currencyRates[outputCurrencyIndex];

        // Berechnen der Ausgabe
        double outputValue = inputValue * (outputRate / inputRate);

        // Ausgabe auf der UI
        _outputValue.setText(String.valueOf(outputValue));
    }

















}
