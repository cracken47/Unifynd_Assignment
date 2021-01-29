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
import com.karan.unifynd.utils.RecyclerViewClickListener;

import java.util.List;

public class HipHopAdapter extends RecyclerView.Adapter<HipHopAdapter.HeroViewHolder> {
    private static RecyclerViewClickListener itemListener;
    public List<HipHop> hipHopList;
    private final Context mContext;
    private HipHop hipHop;


    public HipHopAdapter(Context context, List<HipHop> hipHopList, RecyclerViewClickListener itemListener) {
        this.mContext = context;
        this.hipHopList = hipHopList;
        HipHopAdapter.itemListener = itemListener;
    }


    @NonNull
    @Override
    public HipHopAdapter.HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        return new HipHopAdapter.HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HipHopAdapter.HeroViewHolder holder, int position) {

        hipHop = hipHopList.get(position);
        holder.title.setText(hipHop.getAlbumName());
        holder.subTitle.setText(hipHop.getArtistName());

    }

    @Override
    public int getItemCount() {
        return hipHopList.size();
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