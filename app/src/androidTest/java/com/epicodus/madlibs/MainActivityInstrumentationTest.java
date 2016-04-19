package com.epicodus.madlibs;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Guest on 4/19/16.
 */
public class MainActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateEditText() {
        onView(withId(R.id.verbEditText1)).perform(typeText("fast")).check(matches(withText("fast")));
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.verbEditText2)).perform(typeText("slow")).check(matches(withText("slow")));
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.nounEditText1)).perform(typeText("cat"), closeSoftKeyboard()).check(matches(withText("cat")));
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.nounEditText2)).perform(typeText("dog"), closeSoftKeyboard()).check(matches(withText("dog")));
    }

    @Test
    public void wordsAreSentToStoryActivity() {
        String adj1 = "fast";
        String adj2 = "slow";
        String noun1 = "cat";
        String noun2 = "dog";
        onView(withId(R.id.verbEditText1)).perform(typeText(adj1));
        onView(withId(R.id.verbEditText2)).perform(typeText(adj2));
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.nounEditText1)).perform(typeText(noun1), closeSoftKeyboard());
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.nounEditText2)).perform(typeText(noun2), closeSoftKeyboard());
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.startButton)).perform(click());
        onView(withId(R.id.storyTextView)).check(matches(withText("A vacation is when you take a trip to some " + adj1 + " place with your " + adj2 + " family. Usually you go to some place that is near a/an " + noun1 + " or up on a/an " + noun2 + ".")));
    }


}
