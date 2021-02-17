package com.example.sclient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class screen2 extends AppCompatActivity {

    Button btnScan;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        //Definindo Variavéis
        btnScan = (Button) findViewById(R.id.btnScan);
        resultado = (TextView) findViewById(R.id.resultado);
        final Activity activity = this;
        btnScan.setOnClickListener(new View.OnClickListener() {

        //Definindo as intenções e configurações para scan
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setOrientationLocked(false);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Camera Scanning");
                integrator.setCameraId(0);
                integrator.initiateScan();
            }
        });
    }

        //Definindo condições para mostrar resultados ou alertas em caso de erro!
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
            //    alert(result.getContents());
                    resultado.setText(result.getContents());

            }else{
                alert("Scan cancelado");
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    private void alert(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }

}