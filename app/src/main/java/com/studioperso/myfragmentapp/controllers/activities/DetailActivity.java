package com.studioperso.myfragmentapp.controllers.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.studioperso.myfragmentapp.R;
import com.studioperso.myfragmentapp.controllers.fragments.DetailFragment;

import android.os.Bundle;

public class DetailActivity extends BaseActivity {

    private DetailFragment mDetailFragment;

    // --------------
    // BASE METHODS
    // --------------
    @Override
    protected int getFragmentLayout() {
        return R.layout.activity_detail;
    }

    @Override
    protected void configureDesign() {
        configureToolbar();
        configureAndShowDetailFragment();
    }

    @Override
    protected void updateDesign() {
        updateDetailFragmentTextWithTag();
    }

    // --------------
    // TOOLBAR
    // --------------
    private void configureToolbar(){
        // Get the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        // Sets the Toolbar
        setSupportActionBar(toolbar);

        ActionBar returnUp = getSupportActionBar();
        if (returnUp != null)
            returnUp.setDisplayHomeAsUpEnabled(true);
    }
    // --------------
    // FRAGMENTS
    // --------------

    private void configureAndShowDetailFragment(){
        // A - Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container
        mDetailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

        if (mDetailFragment == null) {
            // B - Create new detail fragment
            mDetailFragment = new DetailFragment();
            // C - Add it to FrameLayout container
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_detail, mDetailFragment)
                    .commit();
        }
    }

    private void updateDetailFragmentTextWithTag(){

        int buttonTag = getIntent().getIntExtra(EXTRA_BUTTON_TAG, 0);
        mDetailFragment.updateTextView(buttonTag);
    }
}