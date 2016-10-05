package de.mvhs.android.waehrungsrechner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText _betrag;
    private Spinner _ausgangWaehrung;
    private Spinner _zielWaehrung;
    private Button _berechnen;
    private EditText _ergebnis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Zuordnung der Layout Datei
        setContentView(R.layout.activity_main);

        // Suchen der Elemente in der Layout XML Datei
        _betrag = (EditText) findViewById(R.id.Betrag);
        _ausgangWaehrung = (Spinner) findViewById(R.id.AusgangsWaehrung);
        _zielWaehrung = (Spinner) findViewById(R.id.ZielWaehrung);
        _berechnen = (Button) findViewById(R.id.Berechnen);
        _ergebnis = (EditText) findViewById(R.id.Ergebnis);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Registrierung der Events / Listener
        _berechnen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Berechnung();
            }
        });
    }

    private void Berechnung() {
        double[] umrechnungsKurse = {
                1.0, // EUR zu EUR
                1.3, // EUR zu USD
                0.85, // EUR zu GBP
                1.27, // EUR zu CHF
                75.0, // EUR zu RUB
        };

        // Auslesen des Betrages
        String betragAlsText = _betrag.getText().toString();

        // Prüfung, Betrag eingegeben
        if (betragAlsText == null || "".equals(betragAlsText)) {
            return;
        }

        // Umwandlung in Nummer
        double betragAslNummer = Double.parseDouble(betragAlsText);

        // Auslesen der ausgewählten Währungen
        int ausgangsWaehrungIndex =
                _ausgangWaehrung.getSelectedItemPosition();
        int zielWahrungIndex =
                _zielWaehrung.getSelectedItemPosition();

        // Bestimmen des Umrechnungskurses
        double ausgangsFaktor =
                umrechnungsKurse[ausgangsWaehrungIndex];
        double zielFaktor =
                umrechnungsKurse[zielWahrungIndex];

        double ergebnis = betragAslNummer / ausgangsFaktor * zielFaktor;

        // Ergebnis ausgeben
        _ergebnis.append("\n" + String.valueOf(ergebnis));
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Deregistrierung der Events / Listener
        _berechnen.setOnClickListener(null);
    }
}
