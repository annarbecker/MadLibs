package com.epicodus.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AnimalsActivity extends AppCompatActivity {
    private Button mStartButton;
    private EditText mVerbEditText1;
    private EditText mNounEditText1;
    private EditText mNounEditText2;
    private EditText mNounEditText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);


        mVerbEditText1 = (EditText) findViewById(R.id.verbEditText1);
        mNounEditText1 = (EditText) findViewById(R.id.nounEditText1);
        mNounEditText2 = (EditText) findViewById(R.id.nounEditText2);
        mNounEditText3 = (EditText) findViewById(R.id.nounEditText3);
        mStartButton = (Button) findViewById(R.id.startButton);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String verb1 = mVerbEditText1.getText().toString();
                String noun1 = mNounEditText1.getText().toString();
                String noun2 = mNounEditText2.getText().toString();
                String noun3 = mNounEditText3.getText().toString();
                Intent intent = new Intent(AnimalsActivity.this, StoryActivity.class);
                intent.putExtra("wholeStory", "If you give a " + noun1 + " a " + noun2 + " he/she is going to ask for a " + noun3 + ". He/she will also want to " + verb1 + ".");

                startActivity(intent);
            }
        });
    }
}
