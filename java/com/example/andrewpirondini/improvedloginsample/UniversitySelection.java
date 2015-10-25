package com.example.andrewpirondini.improvedloginsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class UniversitySelection extends Activity implements OnItemSelectedListener {
    Spinner spinnerOsversions;
    TextView selVersion;
    private String[] state = { "Cupcake", "Donut", "Eclair", "Froyo",
            "Gingerbread", "HoneyComb", "IceCream Sandwich", "Jellybean",
            "kitkat" };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_selection);
        System.out.println(state.length);
        selVersion = (TextView) findViewById(R.id.selVersion);
        spinnerOsversions = (Spinner) findViewById(R.id.osversions);
        ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, state);
        adapter_state
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOsversions.setAdapter(adapter_state);
        spinnerOsversions.setOnItemSelectedListener(this);

    }

    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        spinnerOsversions.setSelection(position);
        String selState = (String) spinnerOsversions.getSelectedItem();
        selVersion.setText("Selected Android OS:" + selState);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

}