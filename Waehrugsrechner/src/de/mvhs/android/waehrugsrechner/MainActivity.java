package de.mvhs.android.waehrugsrechner;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	private final static double[] _CurrencyFactors = {
		1.0, // EUR
		1.28, // USD
		0.85, // GBP
		38, // RUB
		1.1 // CHF
	};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    @Override
    protected void onStart() {
    		super.onStart();
    		
    		Button calculate = (Button) findViewById(R.id.CalculateCommand);
    		
    		// Klick Listener hinzufügen
    		calculate.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					onCalculate();
				}
			});
    }
    
    @Override
    protected void onStop() {
    		super.onStop();
    		
    		Button calculate = (Button) findViewById(R.id.CalculateCommand);
    		
    		calculate.setOnClickListener(null);
    }
    
    private void onCalculate(){
    		EditText inputValue = (EditText) findViewById(R.id.InputValue);
    		
    		String inputString = inputValue.getText().toString();
    		
    		double inputDouble = 0;
    		
    		try {
    			inputDouble = Double.parseDouble(inputString);
    		} catch (NumberFormatException ex){
    			ex.printStackTrace();
    		}
    		
    		Spinner inputCurrency = (Spinner) findViewById(R.id.InputCurrencySelector);
    		Spinner outputCurrency = (Spinner)findViewById(R.id.OutputCurrencySelector);
    		
    		int selectedInputCurrency = inputCurrency.getSelectedItemPosition();
    		int selectedOutputCurrency = outputCurrency.getSelectedItemPosition();
    		
    		double outputDouble = inputDouble /
    				_CurrencyFactors[selectedInputCurrency] *
    				_CurrencyFactors[selectedOutputCurrency];
    		
    		TextView outputValue = (TextView) findViewById(R.id.OutputValue);
    		outputValue.setText(String.valueOf(outputDouble));
    }
}
