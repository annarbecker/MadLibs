package com.epicodus.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StoryActivity extends AppCompatActivity {
    public static final String TAG = StoryActivity.class.getSimpleName();
    private TextView mStoryTextView;
    private Button mRestartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mRestartButton = (Button) findViewById(R.id.restartButton);

        Intent intent = getIntent();
        String wholeStory = intent.getStringExtra("wholeStory");

        mStoryTextView.setText(wholeStory);


        mRestartButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StoryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
