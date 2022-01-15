package fr.lucash.scorevolley.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import fr.lucash.scorevolley.R;

public class MainActivity extends AppCompatActivity {

     TextView mTextView;
     Button mButton1;
     Button mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        mTextView = findViewById(R.id.title);
        mButton1 = findViewById(R.id.create_match);
        mButton2 = findViewById(R.id.quit);


        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teamcreationactivityIntent = new Intent(MainActivity.this, Team_creation_activity.class);
                startActivity(teamcreationactivityIntent);
                }
            });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);

            }
        });
    }
}