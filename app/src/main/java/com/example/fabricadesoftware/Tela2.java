package com.example.fabricadesoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Tela2 extends AppCompatActivity {

    private Button botao;

    TextView resultado;
    TextView custo;


    private static final DecimalFormat df = new DecimalFormat("0.00");

    String res = df.format(MainActivity.res);
    String cus = df.format(MainActivity.cus);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        resultado = findViewById(R.id.resultado);
        custo = findViewById(R.id.custo);


        resultado.setText(res);
        custo.setText(cus);

        botao = findViewById(R.id.id_voltar2);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Tela2.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}