package de.mvhs.android.waehrungsrechner;

import android.app.Activity;
import android.os.Bundle;
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
		
		setContentView(R.layout.main_activity);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		
		Button berechnen = (Button) findViewById(R.id.Berechnen);
		
		berechnen.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Unsere Berechnung
				
				berechne();
				
				Toast.makeText(
						MainActivity.this,
						"Ich wurde geklickt!",
						Toast.LENGTH_LONG).show();
			}
		});
	}
	
	private void berechne(){
		double[] waherungFaktor = {
				1,
				1.27,
				37,
				1.57
		};
		
		// UI Elemente suchen
		Spinner waehrung1 = (Spinner) findViewById(R.id.Waehrung1Auswahl);
		Spinner waehrung2 = (Spinner) findViewById(R.id.Waehrung2Auswahl);
		EditText ausgangsbetrag = (EditText) findViewById(R.id.Asgangsbetrag);
		
		// Währung bestimmen
		int waehrung1Index = waehrung1.getSelectedItemPosition();
		int waehrung2Index = waehrung2.getSelectedItemPosition();
		String betragWert = ausgangsbetrag.getText().toString();
		
		double betrag = 0;
		betrag = Double.parseDouble(betragWert);
		
		// Aktoren Zuordnung
		double waehrung1Faktor = waherungFaktor[waehrung1Index];
		double waehrung2Faktor = waherungFaktor[waehrung2Index];
		
		// Ergebnis berechnen
		double ergebnis = betrag / waehrung1Faktor * waehrung2Faktor;
		
		// Ergebnis Ausgabe
		TextView ergebinsAusgabe = (TextView) findViewById(R.id.Zielbetrag);
		ergebinsAusgabe.append(String.valueOf(ergebnis) + "\n");
	}
	
	
	
	
	
	
	
	
	
}
