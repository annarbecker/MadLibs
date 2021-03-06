package com.epicodus.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VacationActivity extends AppCompatActivity {
    private Button mStartButton;
    private EditText mAdjEditText1;
    private EditText mAdjEditText2;
    private EditText mNounEditText1;
    private EditText mNounEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation);


        mAdjEditText1 = (EditText) findViewById(R.id.adjEditText1);
        mAdjEditText2 = (EditText) findViewById(R.id.adjEditText2);
        mNounEditText1 = (EditText) findViewById(R.id.nounEditText1);
        mNounEditText2 = (EditText) findViewById(R.id.nounEditText2);
        mStartButton = (Button) findViewById(R.id.startButton);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adj1 = mAdjEditText1.getText().toString();
                String adj2 = mAdjEditText2.getText().toString();
                String noun1 = mNounEditText1.getText().toString();
                String noun2 = mNounEditText2.getText().toString();
                Intent intent = new Intent(VacationActivity.this, StoryActivity.class);

                intent.putExtra("wholeStory", "A vacation is when you take a trip to some " + adj1 + " place with your " + adj2 + " family. Usually you go to some place that is near a/an " + noun1 + " or up on a/an " + noun2 + ".");

                startActivity(intent);
            }
        });
    }
}
