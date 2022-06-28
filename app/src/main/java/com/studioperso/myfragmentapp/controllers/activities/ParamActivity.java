package com.studioperso.myfragmentapp.controllers.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import com.studioperso.myfragmentapp.R;
import com.studioperso.myfragmentapp.controllers.fragments.ParamFragment;
import com.studioperso.myfragmentapp.databinding.ActivityParamBinding;

public class ParamActivity extends BaseActivity<ActivityParamBinding> {

    // --------------
    // BASE METHODS
    // --------------
    // ACTIVITY GETTER
    @Override
    protected ActivityParamBinding getBinding(){
     return ActivityParamBinding.inflate(getLayoutInflater());
    }

    @Override
    protected Toolbar getToolbar(){ return mBinding.paramToolbar.toolbarRoot;}

    // ACTIVITY DESIGN
    @Override
    protected void configureDesign(){}
    @Override
    protected void updateDesign(){configureAndShowParamFragment();}

    // TOOLBAR
    @Override
    protected void customToolbar(){
        // Sets the Toolbar return button
        ActionBar returnUp = getSupportActionBar();
        if (returnUp != null)
            returnUp.setDisplayHomeAsUpEnabled(true);
    }

    // --------------
    // FRAGMENTS
    // --------------
    private void configureAndShowParamFragment(){
        ParamFragment paramFragment = (ParamFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_param);

        if (paramFragment == null){
            paramFragment = new ParamFragment();
            // C - Add it to FrameLayout container
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_param, paramFragment)
                    .commit();
        }
    }
}
