package fr.lucash.scorevolley.controller;



import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import fr.lucash.scorevolley.R;

public class Match_activity extends AppCompatActivity {

    TextView mTextView1;
    TextView mTextView2;
    TextView mTextView3;
    TextView mTextView4;
    TextView mTextView5;
    TextView mTextView6;
    TextView mTextView7;
    TextView mTextView8;
    String name_match;
    String name_team1;
    String name_team2;
    Button mButton1;
    Button mButton2;
    Button mButton3;
    Button mButton4;
    Button mButton5;
    int win_set1;
    int win_set2;
    int nb_set_1;
    int nb_set_2;
    int points_1;
    int points_2;
    int curent_set;
    //int end_set = curent_set - 1;

    public void restart_set () {
        points_1 = 0;
        mTextView4.setText(points_1 +"");

        points_2 = 0;
        mTextView5.setText(points_2 +"");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        //champs de texte a remplir par les edits text
        mTextView1 = findViewById(R.id.match_name);
        mTextView2 = findViewById(R.id.team_name_1);
        mTextView3 = findViewById(R.id.team_name_2);

        //champs des set
        mTextView6 = findViewById(R.id.set_team1);
        mTextView7 = findViewById(R.id.set_team2);

        //champ compteur set en cours
        mTextView8 = findViewById(R.id.counter_set);

        //champs des scores
        mTextView4 = findViewById(R.id.score_team1);
        mTextView5 = findViewById(R.id.score_team2);

        //declaration des buttons
        mButton1 = findViewById(R.id.button_team1);
        mButton2 = findViewById(R.id.button_team2);
        mButton3 = findViewById(R.id.match_back_home);
        mButton4 = findViewById(R.id.match_back);
        mButton5 = findViewById(R.id.button_undo);

        //changement des textview par les edittext
        name_match = getIntent().getExtras().getString("Value");
        mTextView1.setText(name_match);

        name_team1 = getIntent().getExtras().getString("Antibes");
        mTextView2.setText(name_team1);

        name_team2 = getIntent().getExtras().getString("Nice");
        mTextView3.setText(name_team2);


        win_set1 = 1;
        win_set2 = 25;
        nb_set_1 = 0;
        nb_set_2 = 0;
        points_1 = 0;
        points_2 = 0;
        curent_set = 1;


        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // score operation like score += increment_value;
                points_1++;
                mTextView4.setText(points_1 + "");

                if (nb_set_1 <= 2 && nb_set_2 <= 2) {
                     if (nb_set_1 == 2 && nb_set_2 == 2) {
                         if (points_1 >= 14 && points_2 >= 14) {
                             if (points_1 == points_2 + 2) {
                                 nb_set_1++;
                                 mTextView6.setText(nb_set_1 + "");
                                 //curent_set++;
                                 //mTextView8.setText(curent_set +"");
                             } else if (points_2 == points_1 + 2) {
                                 nb_set_2++;
                                 mTextView7.setText(nb_set_2 + "");
                                 //curent_set++;
                                 //mTextView8.setText(curent_set +"");
                             }
                         } else  if (points_1 == 15) {
                             nb_set_1++;
                             mTextView6.setText(nb_set_1 + "");
                             //curent_set++;
                             //mTextView8.setText(curent_set +"");
                             restart_set();
                         }
                     }
                    if (points_1 >= 24 && points_2 >= 24) {
                        if (points_1 == points_2 + 2) {
                            nb_set_1++;
                            mTextView6.setText(nb_set_1 + "");
                            curent_set++;
                            mTextView8.setText(curent_set +"");
                            restart_set();
                        } else if (points_2 == points_1 + 2) {
                            nb_set_2++;
                            mTextView7.setText(nb_set_2 + "");
                            curent_set++;
                            mTextView8.setText(curent_set +"");
                            restart_set();
                        }
                    } else if (points_1 == 25) {
                        nb_set_1++;
                        mTextView6.setText(nb_set_1 + "");
                        curent_set++;
                        mTextView8.setText(curent_set +"");
                        restart_set();
                    }
                }

                if (nb_set_1 >= 3) {
                    AlertDialog.Builder popuwin = new AlertDialog.Builder(Match_activity.this);
                    popuwin.setTitle("Congrats team "+ name_team1 +" win the match");

                    popuwin.setNegativeButton("BACK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent endhomeIntent = new Intent(Match_activity.this, Team_creation_activity.class);
                            startActivity(endhomeIntent);
                        }
                    });

                    popuwin.setPositiveButton("HOME", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent endhomeIntent = new Intent(Match_activity.this, MainActivity.class);
                            startActivity(endhomeIntent);
                        }
                    });

                    popuwin.show();
                }

            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // score operation like score += increment_value;
                points_2++;
                mTextView5.setText(points_2 + "");

                if (nb_set_1 <= 2 && nb_set_2 <= 2) {
                    if (nb_set_1 == 2 && nb_set_2 == 2) {
                        if (points_1 >= 14 && points_2 >= 14) {
                            if (points_1 == points_2 + 2) {
                                nb_set_1++;
                                mTextView6.setText(nb_set_1 + "");
                                //curent_set++;
                                //mTextView8.setText(curent_set +"");
                            } else if (points_2 == points_1 + 2) {
                                nb_set_2++;
                                mTextView7.setText(nb_set_2 + "");
                                //curent_set++;
                                //mTextView8.setText(curent_set +"");
                            }
                        } else if (points_2 == 15) {
                            nb_set_2++;
                            mTextView7.setText(nb_set_2 + "");
                            //curent_set++;
                            //mTextView8.setText(curent_set +"");
                            restart_set();
                        }
                    }
                    if (points_1 >= 24 && points_2 >= 24) {
                        if (points_1 == points_2 + 2) {
                            nb_set_1++;
                            mTextView6.setText(nb_set_1 + "");
                            curent_set++;
                            mTextView8.setText(curent_set +"");
                            restart_set();
                        } else if (points_2 == points_1 + 2) {
                            nb_set_2++;
                            mTextView7.setText(nb_set_2 + "");
                            curent_set++;
                            mTextView8.setText(curent_set +"");
                            restart_set();
                        }
                    } else if (points_2 == 25) {
                        nb_set_2++;
                        mTextView7.setText(nb_set_2 + "");
                        curent_set++;
                        mTextView8.setText(curent_set +"");
                        restart_set();
                    }
                }

                if (nb_set_2 >= 3) {
                    AlertDialog.Builder popuwin = new AlertDialog.Builder(Match_activity.this);
                    popuwin.setTitle("Congrats team "+ name_team2 +" win the match");
                    popuwin.setNegativeButton("BACK MENU", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent backmenuIntent = new Intent(Match_activity.this, Team_creation_activity.class);
                            startActivity(backmenuIntent);
                        }
                    });
                    popuwin.setPositiveButton("HOME", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent endhomeIntent = new Intent(Match_activity.this, MainActivity.class);
                            startActivity(endhomeIntent);
                        }
                    });
                    popuwin.show();
                }
            }
        });


        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(Match_activity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });

        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(Match_activity.this, MainActivity.class);
                startActivity(backIntent);
            }
        });

        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder undopopup = new AlertDialog.Builder(Match_activity.this);
                undopopup.setTitle("Count Error:");
                undopopup.setMessage("Select one button to remove one point to the team if you made an error!");
                undopopup.setNegativeButton("-1 Team:" + name_team1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        points_1--;
                        mTextView4.setText(points_1 +"");
                    }
                });
                undopopup.setPositiveButton("-1 Team: " + name_team2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        points_2--;
                        mTextView5.setText(points_2 +"");
                    }
                });
                undopopup.show();
            }
        });


    }
}