package de.mvhs.android.wrechner;

import java.text.BreakIterator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button cmdBerechnen = (Button) findViewById(R.id.btn_berechnen);
        
        cmdBerechnen.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				berechnen();
			}
		});
    }
    
    private void berechnen(){
    		// Views aus dem Layout auslesen
    		EditText txtWert = (EditText)findViewById(R.id.txt_wahrung1);
    		Spinner selWaehrung1 = (Spinner)findViewById(R.id.sel_waehrung1);
    		Spinner selWaehrung2 = (Spinner)findViewById(R.id.sel_waehrung2);
    		TextView txtErgebnis = (TextView)findViewById(R.id.txt_ergebnis);
    		
    		// Werte auslesen
    		String strWert = txtWert.getText().toString();
    		int w1 = selWaehrung1.getSelectedItemPosition();
    		int w2 = selWaehrung2.getSelectedItemPosition();
    		
    		// Werte aus Umrechnungskurs-Array auslesen
    		String strW1 = getResources().getStringArray(R.array.waehrung_wert)[w1];
    		String strW2 = getResources().getStringArray(R.array.waehrung_wert)[w2];
    		
    		// Konvertierung der Strings
    		double wert = 0;
    		double dW1 = 1;
    		double dW2 = 1;
    		
    		try{
    			wert = Double.parseDouble(strWert);
    			dW1 = Double.parseDouble(strW1);
    			dW2 = Double.parseDouble(strW2);
    		}
    		catch (NumberFormatException e) {
		}
    		
    		// Berechnung
    		double ergebnis = wert / dW1 * dW2;
    		
    		// Ausgabe des Ergebnises
    		txtErgebnis.append(String.valueOf(ergebnis) + "\n");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
