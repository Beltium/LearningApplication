package fr.beltium.learningapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CookieActivity extends AppCompatActivity {

    private TextView points;
    private ImageView cookie;
    private ImageView livai;
    private int clicks = 0;

    private ImageView back_menu_egg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookie2);

        this.points = (TextView) findViewById(R.id.points);
        this.cookie = (ImageView) findViewById(R.id.cookie);
        this.livai = (ImageView) findViewById(R.id.livai);
        this.back_menu_egg = (ImageView) findViewById(R.id.back_menu_egg);

        cookie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicks++;
                points.setText("" + clicks);

                if (clicks > 99) {
                    livai.setVisibility(View.VISIBLE);
                }
            }
        });

        back_menu_egg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

    }
}