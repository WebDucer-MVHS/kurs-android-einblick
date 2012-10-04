	package de.mvhs.android.waehrungsrechner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
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
        
        Button cmdCalculate = (Button)findViewById(R.id.cmd_calculate);
        
        // Click Event zuordnen
        cmdCalculate.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// W�hrung berechnen
				calculate();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
		case R.id.mnu_exit:
			this.finish();
			break;
			
		case R.id.mnu_clear:
			TextView output = (TextView)findViewById(R.id.txt_output);
			output.setText("");
			break;

		default:
			break;
		}
    	return super.onOptionsItemSelected(item);
    }
    
    private void calculate(){
    		// GUI Elemente initialisieren
    		EditText txtInput = (EditText)findViewById(R.id.txt_input);
    		TextView txtOutput = (TextView)findViewById(R.id.txt_output);
    		Spinner spnSource = (Spinner)findViewById(R.id.spn_source);
    		Spinner spnTarget = (Spinner)findViewById(R.id.spn_target);
    		
    		// Werte auslesen
    		String input = txtInput.getText().toString();
    		int source = spnSource.getSelectedItemPosition();
    		int target = spnTarget.getSelectedItemPosition();
    		
    		// W�hrungswerte ermitteln
    		String sourceValue =
    			getResources().getStringArray(R.array.currency_value)[source];
    		String targetValue =
    			getResources().getStringArray(R.array.currency_value)[target];
    		
    		// Konvertierung in Double
    		double inputNumber = 0d;
    		double sourceNumber = 0d;
    		double targetNumber = 0d;
    		double outputNumber = 0d;
    		if(input == null || "".equals(input.trim())){
    			// Fehlermeldung ausgeben
    			txtInput.setHint(getString(R.string.msg_no_input));
    		}
    		else{
	    		inputNumber = Double.parseDouble(input);
	    		sourceNumber = Double.parseDouble(sourceValue);
	    		targetNumber = Double.parseDouble(targetValue);
	    		
	    		// Berechnung
	    		if (sourceNumber != 0) {
				outputNumber = (inputNumber / sourceNumber) * targetNumber;
			}
	    		
	    		// Ergebnisausgabe
	    		txtOutput.setText(String.valueOf(outputNumber) + "\n" + txtOutput.getText());
    		}
    }
}















