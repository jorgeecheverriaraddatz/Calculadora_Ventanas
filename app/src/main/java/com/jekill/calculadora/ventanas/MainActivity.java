package com.jekill.calculadora.ventanas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    EditText altoJ;
    EditText anchoJ;
    RadioButton l15J;
    RadioButton l20J;
    RadioButton l25J;
    RadioGroup  botonesJ;
    TextView resultadoJ;
    TextView textoPrecioJ;
    Button calcularJ;
    Calculo calc;

    int contador;
    TextView pruebaJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        altoJ = (EditText) findViewById(R.id.alto);
        anchoJ = (EditText) findViewById(R.id.ancho);
        l15J = (RadioButton) findViewById(R.id.l15);
        l20J = (RadioButton) findViewById(R.id.l20);
        l25J = (RadioButton) findViewById(R.id.l25);
        botonesJ = (RadioGroup) findViewById(R.id.botones);
        resultadoJ = (TextView) findViewById(R.id.resultado);
        textoPrecioJ = (TextView) findViewById(R.id.textoPrecio);
        calcularJ = (Button) findViewById(R.id.calcular);

        calc = new Calculo();

        contador = 0;
        pruebaJ = (TextView) findViewById(R.id.prueba);
        pruebaJ.setVisibility(View.GONE);

    }

    public void onClick(View view){

        resultadoJ.setText("");

        if (contador<6) {

            if (altoJ.getText().toString().isEmpty() || anchoJ.getText().toString().isEmpty()) {

                Toast error = Toast.makeText(getApplicationContext(), "Uno o mas campos vacíos", Toast.LENGTH_SHORT);
                error.show();

            } else {

                double alto = Double.parseDouble(altoJ.getText().toString());
                double ancho = Double.parseDouble(anchoJ.getText().toString());

                if (l15J.isChecked()) {

                    calc.l15Comprobacion100(alto, ancho);
                    resultadoJ.setText(calc.getPrecio());

                }

                if (l20J.isChecked()) {

                    calc.l20Comprobacion100(alto, ancho);
                    resultadoJ.setText(calc.getPrecio());

                }

                if (l25J.isChecked()) {

                    calc.l25Comprobacion100(alto, ancho);
                    resultadoJ.setText(calc.getPrecio());

                }

            }

            contador = contador + 1;
        }

        else{

            altoJ.setVisibility(View.GONE);
            anchoJ.setVisibility(View.GONE);
            l15J.setVisibility(View.GONE);
            l20J.setVisibility(View.GONE);
            l25J.setVisibility(View.GONE);
            botonesJ.setVisibility(View.GONE);
            resultadoJ.setVisibility(View.GONE);
            textoPrecioJ.setVisibility(View.GONE);
            calcularJ.setVisibility(View.GONE);

            pruebaJ.setText("Licencia expirada");
            pruebaJ.setVisibility(View.VISIBLE);

        }
    }

}
