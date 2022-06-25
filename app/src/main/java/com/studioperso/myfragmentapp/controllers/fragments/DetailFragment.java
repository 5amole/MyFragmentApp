package com.studioperso.myfragmentapp.controllers.fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.studioperso.myfragmentapp.R;
import com.studioperso.myfragmentapp.databinding.FragmentDetailBinding;

import icepick.State;

public class DetailFragment extends BaseFragment<FragmentDetailBinding> {

    @State
    int mButtonTag;

    private TextView mShowText;

    //Constructor
    public DetailFragment() { }

    // --------------
    // BASE METHODS
    // --------------
    @Override
    protected BaseFragment<FragmentDetailBinding> newInstance() {
        return new DetailFragment();
    }

    @Override
    protected FragmentDetailBinding getBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentDetailBinding.inflate(inflater, container, false);
    }

    @Override
    protected void configureDesign() {
        mShowText = mBinding.fDetailText;
    }

    @Override
    protected void updateDesign() {
        this.updateTextView(this.mButtonTag);
    }

    // --------------
    // UPDATE UI
    // --------------
    public void updateTextView(int tagNumber){
        mButtonTag = tagNumber;
        switch (tagNumber){
            case 10:
                mShowText.setText(R.string.text_happy);
                break;
            case 20:
                mShowText.setText(R.string.text_sad);
                break;
            case 30:
                mShowText.setText(R.string.text_horror);
                break;
            default:
                mShowText.setText(R.string.text_no_button_selected);
        }
    }
}