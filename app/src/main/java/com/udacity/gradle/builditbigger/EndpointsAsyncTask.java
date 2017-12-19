package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private OnJokeRecieved listener;

    public EndpointsAsyncTask(OnJokeRecieved downloadListener) {
        this.listener = downloadListener;
    }

    @Override
    protected String doInBackground(Pair<Context, String>[] pairs) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")//URL for emulator
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        try {
            //gets joke from backend
            return myApiService.sayJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

  /*Sends joke through listener*/
    @Override
    protected void onPostExecute(String joke) {
        super.onPostExecute(joke);
        listener.Joke(joke);

    }
}
