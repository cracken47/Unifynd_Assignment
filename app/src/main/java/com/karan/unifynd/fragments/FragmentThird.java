package com.karan.unifynd.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.karan.unifynd.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentThird extends BaseFragment {

    @BindView(R.id.no_ev)
    EditText no;

    @BindView(R.id.secon_no_tv)
    TextView secondLargestNo;

    @BindView(R.id.no1_tv)
    TextView no1;

    @BindView(R.id.no2_tv)
    TextView no2;

    @BindView(R.id.no3_tv)
    TextView no3;

    @BindView(R.id.add_btn)
    Button enter;

    @BindView(R.id.ll1)
    LinearLayout linearLayout1;

    @BindView(R.id.ll2)
    LinearLayout linearLayout2;


    private int largestNO;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        Window window = getActivity().getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.BLUE);
        initView();

    }

    @OnClick(R.id.add_btn)
    public void onEnterPressed(){
        if(no.getText().toString().equals(null)||no.getText().toString().equals("")){
            no.setError("Please enter 3 digit no");
        }else{
            String temp = Integer.toString(Integer.parseInt(no.getText().toString()));
            int[] newGuess = new int[temp.length()];
            for (int i = 0; i < temp.length(); i++)
            {
                newGuess[i] = temp.charAt(i) - '0';
            }
            largestNO = getLargest(newGuess,3);
            secondLargestNo.setText(String.valueOf(largestNO));
            linearLayout1.setVisibility(View.VISIBLE);
            linearLayout2.setVisibility(View.VISIBLE);
//            no1.setText(newGuess[0]);
//            no2.setText(newGuess[1]);
//            no3.setText(newGuess[2]);
        }
    }

    public void initView(){

    }

    public static int getLargest(int[] a, int total){
        int temp;
        for (int i = 0; i < total; i++)
        {
            for (int j = i + 1; j < total; j++)
            {
                if (a[i] > a[j])
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a[total-1];
    }
}
