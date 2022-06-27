package com.studioperso.myfragmentapp.controllers.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;

public abstract class BaseActivity<VB extends ViewBinding> extends AppCompatActivity {
    public static final String EXTRA_BUTTON_TAG = "com.openclassrooms.myfragmentapp.Controllers.Activities.DetailActivity.EXTRA_BUTTON_TAG";

    protected VB mBinding;

    protected abstract VB getBinding();
    protected abstract Toolbar getToolbar();
    protected abstract void configureDesign();
    protected abstract void updateDesign();
    protected abstract void customToolbar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = getBinding();
        View view = mBinding.getRoot();
        setContentView(view);

        configureToolbar();
        configureDesign();
    }

    @Override
    protected void onResume() {
        super.onResume();
        customToolbar();
        updateDesign();
    }

    // --------------
    // TOOLBAR
    // --------------
    private void configureToolbar(){
        // Sets the Toolbar
        setSupportActionBar(getToolbar());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBinding = null;
    }
}
