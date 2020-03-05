package br.edu.ifsp.arq.dmos5_2020s1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button bntCelsius, bntFahrenheit;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bntCelsius = findViewById(R.id.button_celsius);
        bntFahrenheit = findViewById(R.id.button_fahrenheit);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.text_view);

        bntCelsius.setOnClickListener(this);
        bntFahrenheit.setOnClickListener(this);
        editText.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(bntCelsius == v){

            converterTemperature();

        }

        else if(editText == v){

            clearScreen();

        }

        else if(bntFahrenheit == v){

            converterFahrenheit();

        }
    }

    private void converterFahrenheit() {

        double temperature;

        try {

            temperature = readInput();

        }catch (NumberFormatException e){

            temperature = 0;
            showExeption();
        }

        textView.setText(String.format("%.2f °F",(1.8 * temperature) + 32));

    }

    private void clearScreen() {

        textView.setText("");
    }

    private void converterTemperature() {
        double temperature;

        try {

            temperature = readInput();

        }catch (NumberFormatException e){

            temperature = 0;
            showExeption();
        }

        textView.setText(String.format("%.2f °C",(temperature-32)/1.8));
    }

    private void showExeption() {
        Toast.makeText(this, "Digito inválido", Toast.LENGTH_SHORT).show();
    }

    private double readInput() throws NumberFormatException{

        double input;

        try {

            input = Double.valueOf(editText.getText().toString());

        }catch (NumberFormatException e){
            showExeption();
            input = 0;
            throw e;

        }

        return input;


    }
}
