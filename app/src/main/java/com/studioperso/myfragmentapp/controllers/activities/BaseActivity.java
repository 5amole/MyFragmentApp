package com.studioperso.myfragmentapp.controllers.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

public abstract class BaseActivity<VB extends ViewBinding> extends AppCompatActivity {
    public static final String EXTRA_BUTTON_TAG = "com.openclassrooms.myfragmentapp.Controllers.Activities.DetailActivity.EXTRA_BUTTON_TAG";

    protected VB mBinding;

    protected abstract void configureDesign();
    protected abstract void updateDesign();
    protected abstract VB getBinding();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = getBinding();
        View view = mBinding.getRoot();
        setContentView(view);

        configureDesign();
    }

    @Override
    protected void onResume() {
        super.onResume();

        updateDesign();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBinding = null;
    }
}
