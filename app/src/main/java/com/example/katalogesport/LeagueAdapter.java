package com.example.katalogesport;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder> {
    private ArrayList<League> dataList;

    public LeagueAdapter(ArrayList<League> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public LeagueAdapter.LeagueViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.card_league, viewGroup, false);
        return new LeagueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeagueAdapter.LeagueViewHolder leagueViewHolder, int i){
        leagueViewHolder.tvLeagueName.setText(dataList.get(i).getLeagueName());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class LeagueViewHolder extends RecyclerView.ViewHolder{
        private TextView tvLeagueName;

        public LeagueViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLeagueName = (TextView) itemView.findViewById(R.id.tv_leagueName);
        }
        public TextView getTvLeagueName(){
            return tvLeagueName;
        }
    }
}
