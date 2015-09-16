package com.example.zac.teammaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TeamMaker extends AppCompatActivity {

    private EditText mNameField;
    private Button mAddButton;
    private Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_maker);

        mNameField = (EditText) findViewById(R.id.playerNames);
        mAddButton = (Button)findViewById(R.id.addPlayer);
        mSubmitButton = (Button)findViewById(R.id.subPlayers);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameField.getText().toString();
                sendNames(name);
            }
        });

    }
    private void sendNames(String name) {
        Intent intent = new Intent(this, Names.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }

}
