package com.example.zac.teammaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class TeamMaker extends AppCompatActivity {

    public EditText mNameField;
    public Button mAddButton;
    public Button mSubmitButton;
    public ListView mNameList;
    public ArrayList<String> mPlayerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_maker);

        mNameField = (EditText) findViewById(R.id.playerNames);
        mAddButton = (Button)findViewById(R.id.addPlayer);
        mSubmitButton = (Button)findViewById(R.id.subPlayers);
        mNameList = (ListView) findViewById(R.id.nameList);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getName = mNameField.getText().toString();
                mPlayerList.add(getName);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(TeamMaker.this, android.R.layout.simple_list_item_1, mPlayerList);
                mNameList.setAdapter(adapter);
                mNameField.setText("");
            }
        });

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendResults();
            }
        });
    }

    private void sendResults() {
        Intent intent = new Intent(this, ResultsActivity.class);
        intent.putStringArrayListExtra("key",mPlayerList);
        startActivity(intent);
    }

}
