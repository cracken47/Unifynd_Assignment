package com.karan.unifynd.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.karan.unifynd.R;
import com.karan.unifynd.utils.Constant;

import dagger.android.support.DaggerFragment;

public abstract class BaseFragment extends DaggerFragment {

    private ViewGroup defaultView;
    private View errorViewGroup = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        defaultView = (ViewGroup) view;
    }

    void onError(IErrorCta errorCtaInterface, int errorCode) {
        LayoutInflater inflater = getLayoutInflater();
        errorViewGroup = switchResult(errorCode);
        errorViewGroup.setId(Constant.TEMP_ERROR_VG_ID);
        for (int i = 0; i < defaultView.getChildCount(); i++) {
            defaultView.getChildAt(i).setVisibility(View.INVISIBLE);
        }
        defaultView.addView(errorViewGroup, 0);
        errorViewGroup.findViewById(R.id.cta_btn).setOnClickListener((v) -> {
            defaultView.removeView(errorViewGroup);
            for (int i = 0; i < defaultView.getChildCount(); i++) {
                defaultView.getChildAt(i).setVisibility(View.VISIBLE);
            }
            defaultView.invalidate();
            errorCtaInterface.onCtaPressed();
        });
        defaultView.invalidate();
    }

    void removeView(){
        if(errorViewGroup!=null){
            defaultView.removeView(errorViewGroup);
            for (int i = 0; i < defaultView.getChildCount(); i++) {
                defaultView.getChildAt(i).setVisibility(View.VISIBLE);
            }
            defaultView.invalidate();
        }
    }

    View switchResult(int errorCode) {
        View errorViewgroup = null;
        switch (errorCode) {
            case 1:
                errorViewgroup = getLayoutInflater().inflate(R.layout.fragment_no_data_found, defaultView, false);
                break;
            case 2:
                errorViewgroup = getLayoutInflater().inflate(R.layout.fragment_server_error, defaultView, false);
                break;
            case 3:
                errorViewgroup = getLayoutInflater().inflate(R.layout.fragment_unauthorised_access, defaultView, false);
                break;
            case 4:
                errorViewgroup = getLayoutInflater().inflate(R.layout.fragment_something_went_wrong, defaultView, false);
                break;
        }

        return errorViewgroup;
    }

    interface IErrorCta {
        void onCtaPressed();
    }
}
