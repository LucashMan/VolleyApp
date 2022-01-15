package fr.lucash.scorevolley.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fr.lucash.scorevolley.R;

public class Team_creation_activity extends AppCompatActivity {

    TextView mTextView1;
    TextView mTextView2;
    Button mButton1;
    Button mButton2;
    EditText mEditText1;
    EditText mEditText2;
    EditText mEditText3;
    String mStrig_namematch;
    String mStrig_team1;
    String mStrig_team2;

    private static final int GAME_ACTIVITY_REQUEST_CODE = 42;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_creation);

        //titre de la page
        mTextView1 = findViewById(R.id.title_team_menu);
        mTextView2 = findViewById(R.id.create_two_teams);

        //declaration des edits text
        mEditText1 = findViewById(R.id.edit_name);
        mEditText2 = findViewById(R.id.exantibes);
        mEditText3 = findViewById(R.id.exnice);

        //declaration des buttons
        mButton1 = findViewById(R.id.create_match);
        mButton2 = findViewById(R.id.team_menu_back);


        //mettre button en off tant que les editstext ne sont pas remplis
        mButton1.setEnabled(false);

        mEditText1.addTextChangedListener(loginTextWatcher);
        mEditText2.addTextChangedListener(loginTextWatcher);
        mEditText3.addTextChangedListener(loginTextWatcher);



        /*mEditText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mButton1.setEnabled(!s.toString().isEmpty());
            }
        });*/

        /*mEditText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mButton1.setEnabled(!s.toString().isEmpty());
            }
        });


        mEditText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mButton1.setEnabled(!s.toString().isEmpty());
            }
        });*/


        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent creatematchIntent = new Intent(Team_creation_activity.this, Match_activity.class);
                //nom du match
                mStrig_namematch = mEditText1.getText().toString();
                creatematchIntent.putExtra("Value", mStrig_namematch);

                mStrig_team1 = mEditText2.getText().toString();
                creatematchIntent.putExtra("Antibes", mStrig_team1);

                mStrig_team2 = mEditText3.getText().toString();
                creatematchIntent.putExtra("Nice", mStrig_team2);

                startActivity(creatematchIntent);

            }

        });


        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(Team_creation_activity.this, MainActivity.class);
                startActivityForResult(backIntent, GAME_ACTIVITY_REQUEST_CODE);
            }
        });



    }

    public TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String namematchmInput = mEditText1.getText().toString().trim();
            String nameteam1Input = mEditText2.getText().toString().trim();
            String nameteam2Input = mEditText3.getText().toString().trim();

            mButton1.setEnabled(!namematchmInput.isEmpty() && !nameteam1Input.isEmpty() && !nameteam2Input.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}