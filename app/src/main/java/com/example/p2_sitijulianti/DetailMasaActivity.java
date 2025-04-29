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

public class DetailMasaActivity extends AppCompatActivity {

    Spinner spMasa;
    EditText edInputMasa;
    TextView txtHasilMasa;
    Button tbHitung;
    float hasilConversi = 0;
    int posConversi = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_masa);
        // Deklarasi Komponen
        edInputMasa = findViewById(R.id.edInputMasa);
        txtHasilMasa = findViewById(R.id.txtHasilMasa);
        tbHitung = findViewById(R.id.tbHitung);
        spMasa = findViewById(R.id.spMasa);

        /* Data Array
        Kilogram ke Gram = kg * 1000
        Gram ke Kilogram = g / 1000
        Kilogram ke Ton = kg / 1000
        Ton ke Kilogram = ton * 1000
         */
        String[] dataMasa = new  String[]{"kg to gr", "gr to kg", "kg to ton", "ton to kg"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataMasa);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMasa.setAdapter(adapter);

        spMasa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
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
                if (posConversi==0){
                    hasilConversi = (float)(Integer.parseInt(edInputMasa.getText().toString())* 1000); // KG TO GR
                    txtHasilMasa.setText("" + hasilConversi);
                }else if (posConversi==1){
                    hasilConversi = (float)(Integer.parseInt(edInputMasa.getText().toString())/ 1000) ; //GR TO KG
                    txtHasilMasa.setText("" + hasilConversi);
                }else if (posConversi==2){
                    hasilConversi = (float)(Integer.parseInt(edInputMasa.getText().toString())/ 1000 ) ; // KG TO TON
                    txtHasilMasa.setText("" + hasilConversi);
                }else if (posConversi==3){
                    hasilConversi = (float)(Integer.parseInt(edInputMasa.getText().toString())* 1000) ; // TON TO KG
                    txtHasilMasa.setText("" + hasilConversi);
                } else {
                    txtHasilMasa.setText("Input Massa Tidak boleh kosong");
                }
            }
        });
    }
}