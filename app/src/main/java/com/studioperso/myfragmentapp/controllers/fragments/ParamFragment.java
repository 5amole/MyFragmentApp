package com.studioperso.myfragmentapp.controllers.fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.studioperso.myfragmentapp.databinding.FragmentParamBinding;

public class ParamFragment extends BaseFragment<FragmentParamBinding> {

    public ParamFragment() {}
    // --------------
    // BASE METHODS
    // --------------
    @Override
    protected ParamFragment newInstance() {return new ParamFragment();}

    @Override
    protected FragmentParamBinding getBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentParamBinding.inflate(inflater, container, false);
    }

    @Override
    protected void configureDesign() {}

    @Override
    protected void updateDesign() {}
}
