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
import com.karan.unifynd.models.Pop;
import com.karan.unifynd.utils.RecyclerViewClickListener;
import com.karan.unifynd.utils.RecyclerViewPopListener;

import java.util.List;

public class PopAdapter  extends RecyclerView.Adapter<PopAdapter.HeroViewHolder> {
    private static RecyclerViewPopListener itemListener;
    public List<Pop> popList;
    private final Context mContext;
    private Pop pop;


    public PopAdapter(Context context, List<Pop> popList, RecyclerViewPopListener itemListener) {
        this.mContext = context;
        this.popList = popList;
        PopAdapter.itemListener = itemListener;
    }


    @NonNull
    @Override
    public PopAdapter.HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        return new PopAdapter.HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopAdapter.HeroViewHolder holder, int position) {

        pop =popList.get(position);
        holder.title.setText(pop.getAlbumName());
        holder.subTitle.setText(pop.getArtistName());

    }

    @Override
    public int getItemCount() {
        return popList.size();
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
            itemListener.recyclerQtyViewListClicked(v, this.getPosition());

        }
    }
}