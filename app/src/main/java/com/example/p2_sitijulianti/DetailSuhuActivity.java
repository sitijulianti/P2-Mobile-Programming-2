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

public class DetailSuhuActivity extends AppCompatActivity {
    Spinner spSuhu;
    EditText edinputSuhu;
    TextView txtHasilSuhu;
    Button btHitung;
    float hasilConversi = 0;
    int posConversi = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_suhu);

        //Deklarasi Komponen
        edinputSuhu=findViewById(R.id.edinputSuhu);
        txtHasilSuhu=findViewById(R.id.txtHasilSuhu);
        spSuhu=findViewById(R.id.spSuhu);
        btHitung=findViewById(R.id.btHitung);

        /*Data Array Suhu
        0=Cel to Re, rumus 4/5 * Cel
        1=Cel to Far, rumus (9/5 x °Cel) + 32;
        dst
         */
        String[] dataSuhu = new String[] {"Cel to Re", "Cel to Far", "Re to Cel", "Re to Far"};
        spSuhu = findViewById(R.id.spSuhu);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, dataSuhu);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSuhu.setAdapter(adapter);
        spSuhu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                posConversi = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btHitung.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTexttI18n")
            @Override
            public void onClick(View view){
                if(posConversi==0){
                    hasilConversi = (float)(Integer.parseInt(edinputSuhu.getText().toString())*4)/5;
                    txtHasilSuhu.setText(""+hasilConversi);
                } else if (posConversi==1){
                    //proses Cel to Far
                }else if (posConversi==2){
                    //proses Re to Cel
                }else if (posConversi==3){
                    //proses Re to Far
                }
            }
        });
    }
}