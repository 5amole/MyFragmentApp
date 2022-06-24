package com.studioperso.myfragmentapp.controllers.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;


import icepick.Icepick;


public abstract class BaseFragment<VB extends ViewBinding> extends Fragment {

    protected VB mBinding;
    // 1 - Force developer implement those methods
    protected abstract BaseFragment<VB> newInstance();
    protected abstract VB getBinding(LayoutInflater inflater, ViewGroup container);
    protected abstract void configureDesign();
    protected abstract void updateDesign();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 2 - Get layout identifier from abstract method
        mBinding = getBinding(inflater, container);
        // Update Design (Developer will call this method instead of override onActivityCreated())
        this.configureDesign();
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 2 - Restore all @State annotation variables in Bundle
        Icepick.restoreInstanceState(this, savedInstanceState);
        this.updateDesign();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // 3 - Save all @State annotation variables in Bundle
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }
}
