package com.example.p2_sitijulianti;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class DetailLuasActivity extends AppCompatActivity {

    Spinner spLuas;
    EditText edInputLuas;
    TextView txtHasilLuas;
    Button tbHitung;
    float hasilConversi = 0;
    int posConversi = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_luas);
        edInputLuas = findViewById(R.id.edInputLuas);
        txtHasilLuas = findViewById(R.id.txtHasilLuas);
        tbHitung = findViewById(R.id.tbHitung);
        spLuas = findViewById(R.id.spLuas);

        /* Data Array Konversi Luas
        1 m² = 10,000 cm²
        1 cm² = 0.0001 m²
        1 ha = 10,000 m²
        */

        String[] dataMasa = new  String[]{"m² to cm²", "cm² to m²", "m² to ha", "ha to m²"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataMasa);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLuas.setAdapter(adapter);

        spLuas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                posConversi = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
        tbHitung.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String inputText = edInputLuas.getText().toString();

                if (inputText.isEmpty()) {
                    txtHasilLuas.setText("Input Luas tidak boleh kosong");
                    return;
                }

                float inputLuas = Float.parseFloat(inputText);

                switch (posConversi) {
                    case 0: // m² to cm²
                        hasilConversi = inputLuas * 10000;
                        break;
                    case 1: // cm² to m²
                        hasilConversi = inputLuas / 10000;
                        break;
                    case 2: // m² to ha
                        hasilConversi = inputLuas / 10000;
                        break;
                    case 3: // ha to m²
                        hasilConversi = inputLuas * 10000;
                        break;
                    default:
                        hasilConversi = 0;
                        break;
                }

                txtHasilLuas.setText("" + hasilConversi);
            }
        });
    }
}