package de.mvhs.android.waehrungsrechner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	// Klassen Variablen
	private double[] _WahrungsKurse =  {
		1, // Euro : Euro
		0.86, // USD : Euro
		1.34, // BPD : Euro
		0.03 // RUB : Euro
	};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Suchen des Buttons im eingebundenen Layout
        Button berechnen = (Button) findViewById(R.id.berechnen);
        
        // Einbinden des Listeners (Hörers) auf den Click
        berechnen.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				berechneZielWert();
			}
		});
    }
    
    // Berechnung des Zielwertes
    private void berechneZielWert(){
    		// Ausgangswert
    		EditText eingabeWert = (EditText)findViewById(R.id.ausgangs_wert);
    		// Ausgangswährung
    		Spinner waehrung1 = (Spinner)findViewById(R.id.waehrung_1);
    		// Zielwährung
    		Spinner waehrung2 = (Spinner)findViewById(R.id.wahrung_2);
    		// Ergebnis
    		TextView ergebnis = (TextView)findViewById(R.id.ergebnis);
    		
    		if (eingabeWert.getText().toString() != null && 
    			!"".equals(eingabeWert.getText().toString())) {
    				// Text in Zahl konvertieren
				double eingabeAlsZahl = 0;
				eingabeAlsZahl = Double.parseDouble(eingabeWert.getText().toString());
				
				// Ausgewählter Eintrag für Ausgangswährung
				int waehrungIndex1 = waehrung1.getSelectedItemPosition();
				double waehrungsKurs1 = _WahrungsKurse[waehrungIndex1];
				
				// Ausgewählter Eintrag für die Zielwährung
				int waehrungIndex2 = waehrung2.getSelectedItemPosition();
				double waehrungsKurs2 = _WahrungsKurse[waehrungIndex2];
				
				// Ergebnis berechnen
				double ergebnisWert = eingabeAlsZahl * (waehrungsKurs1 / waehrungsKurs2);
				
				// Ergebnis ausgeben
				ergebnis.setText(String.valueOf(ergebnisWert));
		}
    }
    
    
    
    
    
    
    
    
}
