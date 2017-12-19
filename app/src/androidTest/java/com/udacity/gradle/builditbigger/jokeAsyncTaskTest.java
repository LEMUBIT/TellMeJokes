package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import android.text.TextUtils;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


@RunWith(AndroidJUnit4.class)
public class jokeAsyncTaskTest extends ApplicationTestCase<Application> implements OnJokeRecieved {
    CountDownLatch threadControl;
    String joke;

    public jokeAsyncTaskTest() {
        super(Application.class);
    }

    @Test
    public void testJoke() {
        try {
            threadControl = new CountDownLatch(1);
            new EndpointsAsyncTask(this).execute();
            threadControl.await(10, TimeUnit.SECONDS);
            assertNotNull(joke);
            assertFalse(TextUtils.isEmpty(joke));
        } catch (Exception e) {
            Log.e("Failed to test", e.getMessage());
        }
    }

    @Override
    public void Joke(String joke) {
        this.joke = joke;
        threadControl.countDown();
    }
}
