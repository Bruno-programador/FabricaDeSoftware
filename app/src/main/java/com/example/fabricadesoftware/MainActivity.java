package com.example.fabricadesoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    private Button botao;

    EditText inputWatts;
    EditText inputDias;
    EditText inputHoras;
    EditText inputTarifas;

    static double res = 0;
    static double cus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = findViewById(R.id.id_avancar);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String erros = calcular(botao);

                if (erros.equals("")){
                    Intent intent = new Intent(MainActivity.this,Tela2.class);
                    startActivity(intent);
                }
                else {
                    Alerta(botao, erros);
                }

            }
        });

        botao = findViewById(R.id.id_voltar);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Tela1.class);
                startActivity(intent);
            }
        });



        inputWatts = findViewById(R.id.input_watts);
        inputDias = findViewById(R.id.input_dias);
        inputHoras = findViewById(R.id.input_horas);
        inputTarifas = findViewById(R.id.input_tarifa);
    }


    public String calcular(View v) {
        String erros = "";

        double watts = 0;
        double dias = 0;
        double horas = 0;
        double tarifa = 0;

        try {
            watts = Double.parseDouble(inputWatts.getText().toString());
        } catch (Exception e) {
            erros += "\n    Potencia em Watts";
        }
        try {
            dias = Double.parseDouble(inputDias.getText().toString());
        } catch (Exception e) {
            erros += "\n    Dias por mês";
        }
        try {
            horas = Double.parseDouble(inputHoras.getText().toString());
        } catch (Exception e) {
            erros += "\n    Tempo de funcionamento";
        }
        try {
            tarifa = Double.parseDouble(inputTarifas.getText().toString());
        } catch (Exception e) {
            erros += "\n    Tarifas";
        }

        if (erros.equals("")) {
            res = watts * dias * horas / 1000;
            cus = res * tarifa;
        }

        return erros;
    }

    public void Alerta(View v, String mensagem) {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Erro");
        builder.setMessage("Alguns dados foram preenchido incorretamente.\n" + mensagem);

        // add a button
        builder.setPositiveButton("OK", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}