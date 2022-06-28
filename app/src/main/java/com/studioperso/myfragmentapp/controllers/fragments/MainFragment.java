package com.studioperso.myfragmentapp.controllers.fragments;

import android.content.Context;

import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.studioperso.myfragmentapp.databinding.FragmentMainBinding;

public class MainFragment extends BaseFragment<FragmentMainBinding> implements View.OnClickListener {

    // 2 - Declare callback
    private OnButtonClickedListener mCallback;

    // Required empty public constructor
    public MainFragment() { }

    // --------------
    // BASE METHODS
    // --------------
    @Override
    protected BaseFragment<FragmentMainBinding> newInstance() {
        return new MainFragment();
    }

    @Override
    protected FragmentMainBinding getBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentMainBinding.inflate(inflater, container, false);
    }

    @Override
    protected void configureDesign() {
        mBinding.fMainHappyButton.setOnClickListener(this);
        mBinding.fMainSadButton.setOnClickListener(this);
        mBinding.fMainHorrorButton.setOnClickListener(this);
    }

    @Override
    protected void updateDesign() { }

    // --------------
    // UPDATE UI
    // --------------
    // 1 - Declare our interface that will be implemented by any container activity
    public interface OnButtonClickedListener {
        void onButtonClicked(View view);
    }

    @Override
    public void onClick(View v) {
        // 5 - Spread the click to the parent activity
        mCallback.onButtonClicked(v);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // 4 - Call the method that creating callback after being attached to parent activity
        this.createCallbackToParentActivity();
    }

    // 3 - Create callback to parent activity
    private void createCallbackToParentActivity(){
        try {
            //Parent activity will automatically subscribe to callback
            mCallback = (OnButtonClickedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e + " must implement OnButtonClickedListener");
        }
    }
}
