package com.epicodus.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MysteryActivity extends AppCompatActivity {
    private Button mStartButton;
    private EditText mVerbEditText1;
    private EditText mVerbEditText2;
    private EditText mNounEditText1;
    private EditText mNounEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mystery);


        mVerbEditText1 = (EditText) findViewById(R.id.verbEditText1);
        mVerbEditText2 = (EditText) findViewById(R.id.verbEditText2);
        mNounEditText1 = (EditText) findViewById(R.id.nounEditText1);
        mNounEditText2 = (EditText) findViewById(R.id.nounEditText2);
        mStartButton = (Button) findViewById(R.id.startButton);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String verb1 = mVerbEditText1.getText().toString();
                String verb2 = mVerbEditText2.getText().toString();
                String noun1 = mNounEditText1.getText().toString();
                String noun2 = mNounEditText2.getText().toString();
                Intent intent = new Intent(MysteryActivity.this, StoryActivity.class);
                intent.putExtra("wholeStory", "'Who " + verb1 + "ed the " + noun1 + ",' the " + noun2 + " " + verb2 + "ed.");


                startActivity(intent);
            }
        });
    }
}
