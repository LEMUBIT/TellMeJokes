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
public class EndPointsAsyncTaskTest extends ApplicationTestCase<Application> implements OnJokeRecieved {
   /*Though deprecated in API 24, ApplicationTestCase provides a framework
   in which you can test Application classes in a controlled environment*/

    CountDownLatch threadControl;
    String joke;

    public EndPointsAsyncTaskTest() {
        super(Application.class);
    }

    @Test
    public void testJoke() {
        try {
            threadControl = new CountDownLatch(1);
            new EndpointsAsyncTask(this).execute();
            threadControl.await(10, TimeUnit.SECONDS);
            /*Check if joke was received*/
            //If the condition is false then the test passes,
            // therefore if the variable 'joke' is neither empty nor null the test passes
            assertFalse(TextUtils.isEmpty(joke));
        } catch (Exception e) {
            Log.e("Test Failed!", e.getMessage());
        }
    }

    /*Implement method from OnJokeReceived*/
    @Override
    public void Joke(String joke) {
        this.joke = joke;
        threadControl.countDown();
    }
}
