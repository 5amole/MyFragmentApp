package com.studioperso.myfragmentapp.controllers.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;


import icepick.Icepick;


public abstract class BaseFragment<T extends ViewBinding> extends Fragment {

    protected T mBinding;
    protected Context context;
    // 1 - Force developer implement those methods
    protected abstract BaseFragment<T> newInstance();
    protected abstract T getBinding(LayoutInflater inflater, ViewGroup container);
    protected abstract void configureDesign();
    protected abstract void updateDesign();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 2 - Get layout identifier from abstract method
//        View view = inflater.inflate(getFragmentLayout(), container, false);
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
        Log.e(getClass().getSimpleName(),"Bind base ! " + mBinding);
        mBinding = null;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.context = null;
    }
}
