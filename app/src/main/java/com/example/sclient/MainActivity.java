package com.example.sclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Definindo variavéis
    public Button buttonSec;
    public Button buttonOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set Link page HealthTech
        TextView t = (TextView) findViewById(R.id.contact_s);
        t.setMovementMethod(LinkMovementMethod.getInstance());


        // Set do botão para Acvitity 1 - Buscar
        buttonOne = findViewById(R.id.buttonOne);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),screen1.class);
                startActivity(intent1);
            }
        });


        // Set do botão para Acvitity 2 - QR Code
        buttonSec = findViewById(R.id.buttonSec);
        buttonSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), screen2.class);
                startActivity(intent);
            }
        });

    }
}