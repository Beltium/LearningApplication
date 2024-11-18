package fr.beltium.learningapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GenerateActivity extends AppCompatActivity {

    private EditText input;
    private TextView password;
    private Button generate;
    private int nb_charac;

    private ImageView back_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate2);


        this.input = (EditText) findViewById(R.id.input);
        this.password = (TextView) findViewById(R.id.password);
        this.generate = (Button) findViewById(R.id.generate);
        this.back_menu = (ImageView) findViewById(R.id.back_menu);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    nb_charac = Integer.parseInt(input.getText().toString());

                    ArrayList<String> list = new ArrayList<String>();
                    String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789\"\'#&@%£$€{}()~-|`^/\\°=+-*!?:;§<>";

                    for (int i = 0; i < nb_charac; i++) {
                        Random r = new Random();
                        char c = chars.charAt(r.nextInt(chars.length()));
                        list.add("" + c);
                    }
                    password.setText("" + list.toString().replace(",", "").replace("[", "").replace("]", "").replace(" ", ""));
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Vous devez mettre un nombre.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        back_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

    }
}