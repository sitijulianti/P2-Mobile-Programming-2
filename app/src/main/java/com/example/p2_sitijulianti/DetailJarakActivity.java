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

public class DetailJarakActivity extends AppCompatActivity {

    Spinner spJarak;
    EditText edInputJarak;
    TextView txtHasilJarak;
    Button tbHitung;
    float hasilConversi = 0;
    int posConversi = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jarak);
        edInputJarak = findViewById(R.id.edInputJarak);
        txtHasilJarak = findViewById(R.id.txtHasilJarak);
        tbHitung = findViewById(R.id.tbHitung);
        spJarak = findViewById(R.id.spJarak);

        /* Data Array Konversi Jarak
        1 km = 1000 m
        1 m = 100 cm
        */

        String[] dataMasa = new  String[]{"km to m", "m to km", "m to cm", "cm to m"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataMasa);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spJarak.setAdapter(adapter);

        spJarak.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
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
                String inputText = edInputJarak.getText().toString();

                if (inputText.isEmpty()) {
                    txtHasilJarak.setText("Input jarak tidak boleh kosong");
                    return;
                }

                float inputJarak = Float.parseFloat(inputText);

                switch (posConversi) {
                    case 0: // km to m
                        hasilConversi = inputJarak * 1000;
                        break;
                    case 1: // m to km
                        hasilConversi = inputJarak / 1000;
                        break;
                    case 2: // m to cm
                        hasilConversi = inputJarak * 100;
                        break;
                    case 3: // cm to m
                        hasilConversi = inputJarak / 100;
                        break;
                    default:
                        hasilConversi = 0;
                        break;
                }

                txtHasilJarak.setText("" + hasilConversi);
            }
        });
    }
}