package com.epicodus.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StoryActivity extends AppCompatActivity {
    public static final String TAG = StoryActivity.class.getSimpleName();
    private TextView mStoryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        mStoryTextView = (TextView) findViewById(R.id.storyTextView);

        Intent intent = getIntent();
        String adj1 = intent.getStringExtra("adj1");
        String adj2 = intent.getStringExtra("adj2");
        String noun1 = intent.getStringExtra("noun1");
        String noun2 = intent.getStringExtra("noun2");
        mStoryTextView.setText("A vacation is when you take a trip to some " + adj1 + " place with your " + adj2 + " family. Usually you go to some place that is near a/an " + noun1 + " or up on a/an " + noun2 + ".");

    }
}
