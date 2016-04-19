package com.epicodus.madlibs;

import android.content.Context;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowAbsSpinner;


import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by Guest on 4/19/16.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {
    MainActivity activity;
    private Context context;
    private Spinner spinner;
    private ShadowAbsSpinner shadowSpinner;
    private ArrayAdapter<String> arrayAdapter;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
        context = RuntimeEnvironment.application;
        spinner = new Spinner(context);
        shadowSpinner = shadowOf(spinner);
        String[] testItems = {"Make a selection!", "Vacation", "Mystery", "Animals"};
        arrayAdapter = new MyArrayAdapter(this.context, testItems);

    }

    @Test
    public void validateTextViewContent() {
        TextView madLibsTextView = (TextView) activity.findViewById(R.id.madLibsTextView);
        assertThat("Choose a story!".equals(madLibsTextView.getText().toString()));
    }

    @Test
    public void getSelectedItemShouldReturnCorrectValue() {
        spinner.setAdapter(arrayAdapter);
        spinner.setSelection(0);
        assertThat((String) spinner.getSelectedItem()).isEqualTo("Make a Selection");
        assertThat((String) spinner.getSelectedItem()).isNotEqualTo("Vacation");

        spinner.setSelection(1);
        assertThat((String) spinner.getSelectedItem()).isEqualTo("Vacation");
        assertThat((String) spinner.getSelectedItem()).isNotEqualTo("foo");

        spinner.setSelection(2);
        assertThat((String) spinner.getSelectedItem()).isEqualTo("Mystery");
        assertThat((String) spinner.getSelectedItem()).isNotEqualTo("Vacation");

        spinner.setSelection(3);
        assertThat((String) spinner.getSelectedItem()).isEqualTo("Animals");
        assertThat((String) spinner.getSelectedItem()).isNotEqualTo("Mystery");
    }


    private static class MyArrayAdapter extends ArrayAdapter<String> {
        public MyArrayAdapter(Context context, String[] testItems) {
            super(context, android.R.layout.simple_spinner_item, testItems);
        }
    }
}
