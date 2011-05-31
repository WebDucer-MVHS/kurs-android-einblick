package de.webducer.mvhs.curconverter;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
   /**
     * OnClick Event for calculate button
     */
    public void onCalculateButtonClick(final View v){
    	// Capture layout views
		Spinner oSourceCurrency = (Spinner)findViewById(R.id.spnSource); // Source Currency
		Spinner oTargetCurrency = (Spinner)findViewById(R.id.spnTarget); // Target Currency
		EditText oSourceValue = (EditText)findViewById(R.id.txtSourceCurrency); // Source Currency value
		TextView oTargetValues = (TextView)findViewById(R.id.txtTargetListing); // Target Currency value list
		
		// Capture values
		// Source Currency rate
		String strTemlValue = getResources().getStringArray(R.array.CurrencyValue)[oSourceCurrency.getSelectedItemPosition()];
		Double dblSourceCurrencyRate = Double.parseDouble(strTemlValue);
		// Target Currency rate
		strTemlValue = getResources().getStringArray(R.array.CurrencyValue)[oTargetCurrency.getSelectedItemPosition()];
		Double dblTargetCurrencyRate = Double.parseDouble(strTemlValue);
		// Source value
		strTemlValue = oSourceValue.getText().toString();
		Double dblSourceValue = Double.parseDouble(strTemlValue);
		
		// Calculate target currency value
		Double dblTargetValue = dblSourceValue / dblSourceCurrencyRate * dblTargetCurrencyRate;
		
		// Show the result in the layout
		String strResult = "";
		DecimalFormat oFormatter = new DecimalFormat("0.####");
		strTemlValue = getResources().getStringArray(R.array.CurrencyName)[oSourceCurrency.getSelectedItemPosition()].substring(0,3);
		strResult = strTemlValue + " " + oFormatter.format(dblSourceValue);
		strTemlValue = getResources().getStringArray(R.array.CurrencyName)[oTargetCurrency.getSelectedItemPosition()].substring(0,3);
		strResult += " = " + strTemlValue + " " + oFormatter.format(dblTargetValue) +  "\n";
		oTargetValues.setText(oTargetValues.getText() + strResult);
    }
    
    /**
     * Main menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu m){
    	getMenuInflater().inflate(R.menu.mainmenu, m);
    	return super.onCreateOptionsMenu(m);
    }
    
    /**
     * Main menu onClick event
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem oItem){
    	switch (oItem.getItemId()) {
    	// Close
		case R.id.cmdClose:
			finish();
			return true;

		// Clear
		case R.id.cmdClear:
			TextView oTargetValues = (TextView)findViewById(R.id.txtTargetListing); // Target Currency value list
			oTargetValues.setText("");
			return true;
			
		default:
			return super.onOptionsItemSelected(oItem);
		}
    }
}