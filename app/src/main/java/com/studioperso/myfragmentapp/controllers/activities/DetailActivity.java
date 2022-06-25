package com.studioperso.myfragmentapp.controllers.activities;

import androidx.appcompat.app.ActionBar;

import com.studioperso.myfragmentapp.R;
import com.studioperso.myfragmentapp.controllers.fragments.DetailFragment;
import com.studioperso.myfragmentapp.databinding.ActivityDetailBinding;

public class DetailActivity extends BaseActivity<ActivityDetailBinding> {

    private DetailFragment mDetailFragment;

    // --------------
    // BASE METHODS
    // --------------
    protected ActivityDetailBinding getBinding() {
        return ActivityDetailBinding.inflate(getLayoutInflater());
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
        // Sets the Toolbar
        setSupportActionBar(mBinding.detailToolbar);

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