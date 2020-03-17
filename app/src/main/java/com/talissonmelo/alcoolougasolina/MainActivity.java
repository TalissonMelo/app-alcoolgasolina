package com.talissonmelo.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editAlcool, editGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcool = findViewById(R.id.textAlcool);
        editGasolina = findViewById(R.id.textGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view){

        String precoAlcool = editAlcool.getText().toString();
        String precoGasolina = editGasolina.getText().toString();
        Boolean resultado = validarCampos(precoAlcool,precoGasolina);

        if(resultado){

            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            //Se (valorAlcool / valorGasolina) >= 0.7 melhor utilizar gasolina

            Double resul = valorAlcool / valorGasolina;
            if(resul >= 0.7){
                textResultado.setText("Melhor Utilizar Gasolina");
            }else{
                textResultado.setText("Melhor Utilizar Álcool.");
            }

        }else{
            textResultado.setText("Peencha os preços Álcool e Gasolina");
        }
    }

    public Boolean validarCampos(String alcool, String gasolina){

        Boolean camposValidados = true;

        if(alcool == null || alcool.equals("")){
            camposValidados = false;
        }else if(gasolina == null || gasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }
}
