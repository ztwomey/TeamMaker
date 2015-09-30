package com.example.zac.teammaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    public static final String TAG = ResultsActivity.class.getSimpleName();
    public EditText mNumOfTeams;
    public Button mCreateTeams;
    public ListView mTeamOne;
    public ListView mTeamTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mNumOfTeams = (EditText) findViewById(R.id.numOfTeams);
        mCreateTeams = (Button) findViewById(R.id.createTeams);
        mTeamOne = (ListView) findViewById(R.id.teamOne);
        mTeamTwo = (ListView) findViewById(R.id.teamTwo);

        Intent intent = getIntent();
        ArrayList<String> names = intent.getStringArrayListExtra("key");
        Log.d(TAG, names.toString());

        mCreateTeams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }

}
