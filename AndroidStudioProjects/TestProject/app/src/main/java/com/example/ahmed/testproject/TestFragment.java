package com.example.ahmed.testproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import static com.example.ahmed.testproject.R.layout.activity_main;

/**
 * Created by ahmed on 6/10/17.
 */

public class TestFragment extends Fragment{
    private RecyclerView rV;
    private adapter mAdapter;
    List<Game> games = Game.getGames(50);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        rV = (RecyclerView) view.findViewById(R.id.game_recycler_view);
        rV.setLayoutManager(new LinearLayoutManager(getActivity()));
        UpdateUI();
        return view;
    }
    private class viewHolder extends RecyclerView.ViewHolder{
        private TextView mName;
        private TextView mReleaseDate;
        private TextView mCategory;
        public viewHolder(View item){
            super(item);
            mName = (TextView) item.findViewById(R.id.name);
            mReleaseDate = (TextView) item.findViewById(R.id.release_date);
            mCategory = (TextView) item.findViewById(R.id.category);
        }

        public void bindView(Game game){
            mName.setText(game.getName());
            mReleaseDate.setText(game.getReleaseDate());
            mCategory.setText(game.getCategory());
        }
    }

    private void UpdateUI(){
        mAdapter = new adapter(games);
        rV.setAdapter(mAdapter);
        Log.d("wa", "adapter attached");
    }

    private class adapter extends RecyclerView.Adapter<viewHolder>{
        //List<Game> games;
        public adapter(List<Game> gamess){
            games = gamess;
        }
        @Override
        public viewHolder onCreateViewHolder(ViewGroup parent, int position){
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.recycler_view_layout, parent, false);
            return new viewHolder(view);
        }
        @Override
        public void onBindViewHolder(viewHolder holder, int position){
            Game game = games.get(position);
            holder.bindView(game);
        }
        @Override
        public int getItemCount(){
            return games.size();
        }

    }


}
