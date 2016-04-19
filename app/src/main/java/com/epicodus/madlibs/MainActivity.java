package com.epicodus.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         final Spinner spinner = (Spinner) findViewById(R.id.storySpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.story_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String spinner_story_value = spinner.getSelectedItem().toString();
                if (spinner_story_value.equals("Vacation")) {
                    Intent intent = new Intent(MainActivity.this, VacationActivity.class);
                    startActivity(intent);
                } else if (spinner_story_value.equals("Mystery")) {
                    Intent intent = new Intent(MainActivity.this, MysteryActivity.class);
                    startActivity(intent);
                } else if(spinner_story_value.equals("Animals")) {
                    Intent intent = new Intent(MainActivity.this, AnimalsActivity.class);
                    startActivity(intent);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



            }

        }



