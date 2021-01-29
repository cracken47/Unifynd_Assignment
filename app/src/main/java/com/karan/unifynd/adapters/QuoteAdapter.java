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
import com.karan.unifynd.models.Quote;
import com.karan.unifynd.utils.RecyclerViewClickListener;

import java.util.List;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.HeroViewHolder> {

    private final Context mContext;
    public List<Quote> quoteListList;
    private Quote quote;


    public QuoteAdapter(Context context, List<Quote> quoteList) {
        this.mContext = context;
        this.quoteListList = quoteList;
    }


    @NonNull
    @Override
    public QuoteAdapter.HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.quote_item, parent, false);
        return new QuoteAdapter.HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteAdapter.HeroViewHolder holder, int position) {

        quote = quoteListList.get(position);
        holder.title.setText(quote.getQuote());

    }

    @Override
    public int getItemCount() {
        return quoteListList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        HeroViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.quote_tv);

        }

    }
}