package com.studioperso.myfragmentapp.controllers.activities;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.studioperso.myfragmentapp.R;
import com.studioperso.myfragmentapp.controllers.fragments.DetailFragment;
import com.studioperso.myfragmentapp.controllers.fragments.MainFragment;
import com.studioperso.myfragmentapp.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements MainFragment.OnButtonClickedListener {

    private MainFragment mMainFragment;
    private DetailFragment mDetailFragment;

    // --------------
    // BASE METHODS
    // --------------
    protected ActivityMainBinding getBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void configureDesign() {
        configureAndShowMainFragment();
        configureAndShowDetailFragment();
    }

    @Override
    protected void updateDesign() { }

    // --------------
    // FRAGMENTS
    // --------------

    private void configureAndShowMainFragment(){
        // A - Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container
        mMainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_main);

        if (mMainFragment == null) {
            // B - Create new main fragment
            mMainFragment = new MainFragment();
            // C - Add it to FrameLayout container
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_main, mMainFragment)
                    .commit();
        }
    }
    // Only for tablet display
    private void configureAndShowDetailFragment(){
        mDetailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

        //A - We only add DetailFragment in Tablet mode (If found frame_layout_detail)
        if (mDetailFragment == null && mBinding.frameLayoutDetail != null) {
            mDetailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_detail, mDetailFragment)
                    .commit();
        }
    }
    // --------------
    // CallBack
    // --------------
    @Override
    public void onButtonClicked(View view) {
        // 1 - Retrieve button tag
        int buttonTag = Integer.parseInt(view.getTag().toString());
        Log.e(getClass().getSimpleName(),"Button clicked ! " + buttonTag);
        // 2 - Check if DetailFragment is visible (Tablet)
        if (mDetailFragment != null && mDetailFragment.isVisible())
            // 2.1 - TABLET : Update directly TextView
            mDetailFragment.updateTextView(buttonTag);
        else{
            launchDetailActivity(buttonTag);
        }
    }

    private void launchDetailActivity(int buttonTag){
        Intent intendDetail = new Intent(this, DetailActivity.class);
        intendDetail.putExtra(DetailActivity.EXTRA_BUTTON_TAG, buttonTag);
        startActivity(intendDetail);
    }
}