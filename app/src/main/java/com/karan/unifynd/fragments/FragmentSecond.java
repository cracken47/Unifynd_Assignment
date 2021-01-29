package com.karan.unifynd.fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.karan.unifynd.R;
import com.karan.unifynd.adapters.CircleAdapter;
import com.karan.unifynd.adapters.QuoteAdapter;
import com.karan.unifynd.models.HipHop;
import com.karan.unifynd.models.MovieGenre;
import com.karan.unifynd.models.Quote;
import com.karan.unifynd.utils.CustomDialog;
import com.karan.unifynd.utils.RecyclerViewClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentSecond extends BaseFragment implements RecyclerViewClickListener {

    @BindView(R.id.quotes_rv)
    RecyclerView quotesRecyclerView;

    @BindView(R.id.genre_rv)
    RecyclerView genreRecyclerView;

    private ArrayList<MovieGenre> movieGenreArrayList;
    private CircleAdapter circleAdapter;

    private ArrayList<Quote> quoteArrayList;
    private QuoteAdapter quoteAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
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

    public void initView() {
        movieGenreArrayList = new ArrayList<MovieGenre>();
        movieGenreArrayList.add(new MovieGenre("Kamikaze", "Eminem", 1));
        genreRecyclerView.setHasFixedSize(true);
        genreRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        circleAdapter = new CircleAdapter(getActivity(), movieGenreArrayList, this::recyclerViewListClicked);
        genreRecyclerView.setAdapter(circleAdapter);


        quoteArrayList = new ArrayList<Quote>();
        quoteArrayList.add(new Quote("Your limitation—it’s only your imagination."));
        quoteArrayList.add(new Quote("Push yourself, because no one else is going to do it for you."));
        quoteArrayList.add(new Quote(" Sometimes later becomes never. Do it now."));
        quoteArrayList.add(new Quote("Great things never come from comfort zones."));
        quoteArrayList.add(new Quote("Dream it. Wish it. Do it."));
        quoteArrayList.add(new Quote("Success doesn’t just find you. You have to go out and get it."));
        quoteArrayList.add(new Quote("The harder you work for something, the greater you’ll feel when you achieve it."));
        quoteArrayList.add(new Quote("Dream bigger. Do bigger."));
        quoteArrayList.add(new Quote("Don’t stop when you’re tired. Stop when you’re done."));
        quoteArrayList.add(new Quote("Do something today that your future self will thank you for."));
        quotesRecyclerView.setHasFixedSize(true);
        quotesRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        quoteAdapter = new QuoteAdapter(getActivity(), quoteArrayList);
        quotesRecyclerView.setAdapter(quoteAdapter);

    }


    @Override
    public void recyclerViewListClicked(View v, int position) {

        MovieGenre movieGenre = movieGenreArrayList.get(position);

        CustomDialog customDialog = CustomDialog.newInstance(getActivity())
                .setTitle(movieGenre.getAlbumName())
                .setMessage(movieGenre.getArtistName());
//        Window window = customDialog.getWindow();
//        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        customDialog.show();
        customDialog.setCancelable(true);

    }
}
