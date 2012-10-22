package de.mvhs.android.waehrungsrechner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button cmdCalculate = (Button)findViewById(R.id.calculate);
        
        // Auf den Click auf den Button hšren
        cmdCalculate.setOnClickListener(new OnClickListener() {
			
			public void onClick(View view) {
				onCalculate();
			}
		});
    }
    
    private void onCalculate(){
    		// Initialisieren der GUI Elemente
    		EditText sourceValue = (EditText)findViewById(R.id.source_value);
    		Spinner sourceCurrency = (Spinner)findViewById(R.id.source_currency);
    		Spinner targetCurrency = (Spinner)findViewById(R.id.target_currency);
    		TextView resultValue = (TextView)findViewById(R.id.result);
    		
    		// Auslesen des Ausgangwertes als String
    		String strSourceValue = sourceValue.getText().toString();
    		
    		// Auslesen der WŠhrungskurse aus den Ressourcen
    		String strSourceCurrency = getResources()
    			.getStringArray(R.array.currency_values)
    			[sourceCurrency.getSelectedItemPosition()];
    		String strTargetCurrency = getResources()
    			.getStringArray(R.array.currency_values)
    			[targetCurrency.getSelectedItemPosition()];
    		
    		// Konvertierung in eine Zahl
    		double dblSourceValue = 0;
    		double dblSourceCurrency = 0;
    		double dblTargetCurrency = 0;
    		
    		dblSourceValue = Double.parseDouble(strSourceValue);
    		dblSourceCurrency = Double.parseDouble(strSourceCurrency);
    		dblTargetCurrency = Double.parseDouble(strTargetCurrency);
    		
    		// Berechnung des Ergebnisses
    		double dblResultValue = (dblSourceValue / dblSourceCurrency)
    				* dblTargetCurrency;
    		
    		// Ausgabe des Ergebnisses
    		resultValue.setText(String.valueOf(dblResultValue)
    				+ "\n" + resultValue.getText().toString());
    }
}
