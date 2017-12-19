package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.lemuel.lemubit.jokedisplay.jokeActivity;
import com.lemuel.lemubit.supplyjoke.Joke;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements OnJokeRecieved{
    ProgressBar jokeProgressBar;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button jokeBtn=(Button) root.findViewById(R.id.tellJoke);
        jokeProgressBar = (ProgressBar) root.findViewById(R.id.jokeProgressBar);
        jokeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EndpointsAsyncTask(MainActivityFragment.this).execute();
                jokeProgressBar.setVisibility(View.VISIBLE);
            }
        });
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }

    @Override
    public void Joke(String joke) {
        jokeProgressBar.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(getActivity(), jokeActivity.class);
        Bundle mbundle = new Bundle();
        mbundle.putString("joke", joke);
        intent.putExtras(mbundle);
        startActivity(intent);
    }
}
