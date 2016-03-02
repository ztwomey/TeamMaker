package com.example.zac.teammaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ResultsActivity extends AppCompatActivity {

    public static final String TAG = ResultsActivity.class.getSimpleName();
    public Button mChooseWinner;
    public ListView mContestantList;
    public TextView mShowWinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mChooseWinner = (Button) findViewById(R.id.chooseWinner);
        mContestantList = (ListView) findViewById(R.id.contestantList);
        mShowWinner = (TextView) findViewById(R.id.showWinner);

        Intent intent = getIntent();
        final ArrayList<String> names = intent.getStringArrayListExtra("key");
        Log.d(TAG, names.toString());




        mChooseWinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.shuffle(names);
                Log.d(TAG, names.toString());

                Random random = new Random();
                String winner = names.get(random.nextInt(names.size()));
                mShowWinner.setText(winner);
                names.remove(winner);
                Log.d(TAG, names.toString());
            }

        });
    }

}
