package com.example.zac.teammaker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TeamMaker extends AppCompatActivity {

    public static final String TAG = ResultsActivity.class.getSimpleName();
    public EditText mNameField;
    public Button mAddButton;
    public Button mChooseWinner;
    public ListView mNameList;
    public TextView mShowWinner;
    public ArrayList<String> mPlayerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_maker);

        mNameField = (EditText) findViewById(R.id.playerNames);
        mAddButton = (Button)findViewById(R.id.addPlayer);
        mChooseWinner = (Button)findViewById(R.id.chooseWinner);
        mNameList = (ListView) findViewById(R.id.nameList);
        mShowWinner = (TextView) findViewById(R.id.showWinner);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(TeamMaker.this, android.R.layout.simple_list_item_1, mPlayerList);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getName = mNameField.getText().toString();
                if(getName.isEmpty()){
                    Toast.makeText(TeamMaker.this, "Name field is empty. Please type a name", Toast.LENGTH_LONG).show();
                } else {
                    mPlayerList.add(getName);
                    mNameList.setAdapter(adapter);
                    mNameField.setText("");
                }
            }
        });

        mChooseWinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.shuffle(mPlayerList);
                Log.d(TAG, mPlayerList.toString());

                if (mPlayerList.isEmpty()){
                    Toast.makeText(TeamMaker.this, "Please add names to the contestant list", Toast.LENGTH_LONG).show();
                } else{
                    Random random = new Random();
                    String winner = mPlayerList.get(random.nextInt(mPlayerList.size()));
                    mShowWinner.setText(winner);
                    mPlayerList.remove(winner);
                    Log.d(TAG, mPlayerList.toString());
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

//    private void sendResults() {
//        Intent intent = new Intent(this, ResultsActivity.class);
//        intent.putStringArrayListExtra("key",mPlayerList);
//        startActivity(intent);
//    }

}
