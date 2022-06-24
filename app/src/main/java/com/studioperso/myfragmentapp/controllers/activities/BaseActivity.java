package com.studioperso.myfragmentapp.controllers.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    public static final String EXTRA_BUTTON_TAG = "com.openclassrooms.myfragmentapp.Controllers.Activities.DetailActivity.EXTRA_BUTTON_TAG";

    protected abstract int getFragmentLayout();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getFragmentLayout());

    }
}
