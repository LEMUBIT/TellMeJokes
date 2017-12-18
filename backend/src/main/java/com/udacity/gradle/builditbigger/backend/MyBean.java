package com.udacity.gradle.builditbigger.backend;

/**
 * The object model for the data we are sending through endpoints
 */

import com.lemuel.lemubit.supplyjoke.Joke;

public class MyBean {
    String joke;

    public void setJoke() {
        joke = Joke.getJoke();
    }

    public String geJoke() {
        return joke;
    }

}