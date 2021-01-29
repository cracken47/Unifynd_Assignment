package com.karan.unifynd.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.karan.unifynd.R;
import com.karan.unifynd.models.HipHop;
import com.karan.unifynd.models.MovieGenre;
import com.karan.unifynd.utils.RecyclerViewClickListener;

import java.util.List;

public class CircleAdapter extends RecyclerView.Adapter<CircleAdapter.HeroViewHolder> {
    private static RecyclerViewClickListener itemListener;
    private final Context mContext;
    public List<MovieGenre> movieGenreList;
    private MovieGenre movieGenre;


    public CircleAdapter(Context context, List<MovieGenre> movieGenreList, RecyclerViewClickListener itemListener) {
        this.mContext = context;
        this.movieGenreList = movieGenreList;
        CircleAdapter.itemListener = itemListener;
    }


    @NonNull
    @Override
    public CircleAdapter.HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.round_list_item, parent, false);
        return new CircleAdapter.HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CircleAdapter.HeroViewHolder holder, int position) {

        movieGenre = movieGenreList.get(position);
        holder.title.setText(movieGenre.getAlbumName());
        holder.subTitle.setText(movieGenre.getArtistName());

    }

    @Override
    public int getItemCount() {
        return movieGenreList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        TextView subTitle;
        RelativeLayout relativeLayout;


        HeroViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_tv);
            subTitle = itemView.findViewById(R.id.subtitle_tv);
            relativeLayout = itemView.findViewById(R.id.list_item_rl);
            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View v) {

            notifyDataSetChanged();
            itemListener.recyclerViewListClicked(v, this.getPosition());

        }
    }
}