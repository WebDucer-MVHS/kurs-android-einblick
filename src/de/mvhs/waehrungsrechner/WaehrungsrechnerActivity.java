package de.mvhs.waehrungsrechner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class WaehrungsrechnerActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Button aus der Oberfläche extrahieren
        /* Ist in jeder Activity möglich
         * 
         */
        Button cmdCalculate = (Button)findViewById(R.id.cmdCalculate);
        
        // Click-Ereignis registrieren
        cmdCalculate.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				calculate();				
			}
		});
    }
    
    private void calculate(){
    		// Extrahieren der Oberflächenelemente
    		EditText txtWert = (EditText)findViewById(R.id.txtWert);
    		Spinner selStart = (Spinner)findViewById(R.id.selStart);
    		Spinner selEnd = (Spinner)findViewById(R.id.selEnd);
    		TextView txtResult = (TextView)findViewById(R.id.txtResult);
    		
    		// Konvertierung des eingegebenen Wertes
    		String strWert = txtWert.getText().toString();
    		Double dblWert = 0d;
    		if (!strWert.equals("")) {
				dblWert = Double.parseDouble(strWert);
			}
    		
    		// Bestimmen des ausgewählten Kurses
    		String strStart = getResources()
    				.getStringArray(R.array.waehrungKurs)[selStart.getSelectedItemPosition()];
    		String strEnd = getResources()
    				.getStringArray(R.array.waehrungKurs)[selEnd.getSelectedItemPosition()];
    		Double dblStart = Double.parseDouble(strStart);
    		Double dblEnd = Double.parseDouble(strEnd);
    		
    		// Berechnung
    		Double dblResult = dblWert / dblStart * dblEnd;
    		
    		// Ausgabe
    		txtResult.setText(String.valueOf(dblResult));
    }
}













