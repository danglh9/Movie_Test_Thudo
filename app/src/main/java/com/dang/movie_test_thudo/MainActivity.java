package com.dang.movie_test_thudo;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, new MainFragment())
                    .commit();
        }
    }

}