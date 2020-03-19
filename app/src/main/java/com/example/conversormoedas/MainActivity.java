package com.example.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private  viewHolder mViewHolder = new viewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculator = findViewById(R.id.button_calculator);
        //chamando o onClick
        this.mViewHolder.buttonCalculator.setOnClickListener(this);
        //metodo para tirar o valor em dólar e em euro
        this.clearValues();

    }

    @Override
    public void onClick(View v) {
        //metodo do onClick
        if (v.getId() == R.id.button_calculator) {
            //Lógica
            String value = this.mViewHolder.editValue.getText().toString();
            if ("".equals(value)) {
                //mostra a mensagem para o usurio
                Toast.makeText( this, R.string.informe_valor, Toast.LENGTH_LONG).show();
            } else {
                //convertendo o valor para real
                Double real = Double.valueOf(value);
                this.mViewHolder.textDolar.setText(String.format("%.2f", ( real / 4.61)));
                this.mViewHolder.textEuro.setText(String.format("%.2f", (real / 5.23)));
            }
        }
    }

    private void clearValues() {
        //limpando os elementos no texto do celular
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
    }

    private static class viewHolder {
        //usando classe viewHolder
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculator;
    }
}
