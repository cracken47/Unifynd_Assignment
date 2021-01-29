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
import com.karan.unifynd.models.Pop;
import com.karan.unifynd.models.RB;
import com.karan.unifynd.utils.RecyclerViewClickListener;

import java.util.List;

public class RBAdapter extends RecyclerView.Adapter<RBAdapter.HeroViewHolder> {

    private final Context mContext;
    public List<RB> rbList;
    private RB rb;


    public RBAdapter(Context context, List<RB> rbList) {
        this.mContext = context;
        this.rbList = rbList;
    }


    @NonNull
    @Override
    public RBAdapter.HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        return new RBAdapter.HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RBAdapter.HeroViewHolder holder, int position) {

        rb = rbList.get(position);
        holder.title.setText(rb.getAlbumName());
        holder.subTitle.setText(rb.getArtistName());

    }

    @Override
    public int getItemCount() {
        return rbList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView subTitle;
        RelativeLayout relativeLayout;


        HeroViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_tv);
            subTitle = itemView.findViewById(R.id.subtitle_tv);
            relativeLayout = itemView.findViewById(R.id.list_item_rl);

        }


    }
}