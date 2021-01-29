package com.karan.unifynd.fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.karan.unifynd.R;
import com.karan.unifynd.adapters.HipHopAdapter;
import com.karan.unifynd.adapters.PopAdapter;
import com.karan.unifynd.adapters.RBAdapter;
import com.karan.unifynd.models.HipHop;
import com.karan.unifynd.models.Pop;
import com.karan.unifynd.models.RB;
import com.karan.unifynd.utils.CustomDialog;
import com.karan.unifynd.utils.RecyclerViewClickListener;
import com.karan.unifynd.utils.RecyclerViewPopListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentFirst extends BaseFragment implements RecyclerViewClickListener, RecyclerViewPopListener {

    @BindView(R.id.hip_hop_rv)
    RecyclerView hipHopRecyclerView;

    @BindView(R.id.pop_rv)
    RecyclerView popRecyclerView;

    @BindView(R.id.r_b_rv)
    RecyclerView rbRecyclerView;

    private ArrayList<HipHop> hipHopArrayList;
    private HipHopAdapter hipHopAdapter;

    private ArrayList<Pop> popArrayList;
    private PopAdapter popAdapter;

    private ArrayList<RB> rbArrayList;
    private RBAdapter rbAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.YELLOW);
        }

    }

    public void initView() {
        hipHopArrayList = new ArrayList<HipHop>();
        hipHopArrayList.add(new HipHop("Kamikaze", "Eminem", 1));
        hipHopArrayList.add(new HipHop("Invisible Touch", "Genesis", 2));
        hipHopArrayList.add(new HipHop("Born This Way", "Lady Gaga", 3));
        hipHopArrayList.add(new HipHop("Nilsson Schmilsson", "Harry Nilsson", 4));
        hipHopArrayList.add(new HipHop("Fleetwood Mac", "Fleetwood Mac", 5));
        hipHopArrayList.add(new HipHop("Warm Your Heart", "Laura Nyro", 6));
        hipHopArrayList.add(new HipHop("Cape God", "Allie X", 7));
        hipHopArrayList.add(new HipHop("Have U Seen Her", "Alma", 8));
        hipHopArrayList.add(new HipHop("Dark Hearts", "Annie", 9));
        hipHopArrayList.add(new HipHop("Positions", "Ariana", 10));
        hipHopArrayList.add(new HipHop("Heaven", "Ava", 11));
        hipHopRecyclerView.setHasFixedSize(true);
        hipHopRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        hipHopAdapter = new HipHopAdapter(getActivity(), hipHopArrayList, this::recyclerViewListClicked);
        hipHopRecyclerView.setAdapter(hipHopAdapter);

        popArrayList = new ArrayList<Pop>();
        popArrayList.add(new Pop("WUNNA", "Gunaa", 1));
        popArrayList.add(new Pop("Time Served", "MoneyBagg", 2));
        popArrayList.add(new Pop("Megan Thee Stallion", "Suga", 3));
        popArrayList.add(new Pop("Mac Miller", "Circles", 4));
        popArrayList.add(new Pop("King's Disease", "Nas", 5));
        popArrayList.add(new Pop("No Pressure", "Logic", 6));
        popArrayList.add(new Pop("Pray 4 Paris", "Westside", 7));
        popArrayList.add(new Pop("Legends Never Die ", "Juice", 8));
        popArrayList.add(new Pop("Industry Games", "Chika", 9));
        popArrayList.add(new Pop("The GOAT", "Polo", 10));
        popRecyclerView.setHasFixedSize(true);
        popRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        popAdapter = new PopAdapter(getActivity(), popArrayList, this::recyclerQtyViewListClicked);
        popRecyclerView.setAdapter(popAdapter);


        rbArrayList = new ArrayList<RB>();
        rbArrayList.add(new RB("Take Care", "Drake", 1));
        rbArrayList.add(new RB("TBreathless", "Kenny", 2));
        rbArrayList.add(new RB("2014 Forest", "J.Cole", 3));
        rbArrayList.add(new RB("Curtain Call", "Eminem", 4));
        rbArrayList.add(new RB("Views", "Drake", 5));
        rbArrayList.add(new RB("Good Kid", "Kendrick", 6));
        rbArrayList.add(new RB("Venom", "Eminem", 7));
        rbRecyclerView.setHasFixedSize(true);
        rbRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rbAdapter = new RBAdapter(getActivity(), rbArrayList);
        rbRecyclerView.setAdapter(rbAdapter);


    }

    @Override
    public void recyclerViewListClicked(View v, int position) {

        HipHop hipHop = hipHopArrayList.get(position);

        CustomDialog customDialog = CustomDialog.newInstance(getActivity())
                .setTitle(hipHop.getAlbumName())
                .setMessage(hipHop.getArtistName());
//        Window window = customDialog.getWindow();
//        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        customDialog.show();
        customDialog.setCancelable(true);

    }

    @Override
    public void recyclerQtyViewListClicked(View v, int position) {
        Pop pop = popArrayList.get(position);

        CustomDialog customDialog = CustomDialog.newInstance(getActivity())
                .setTitle(pop.getAlbumName())
                .setMessage(pop.getArtistName());
//        Window window = customDialog.getWindow();
//        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        customDialog.show();
        customDialog.setCancelable(true);
    }
}
