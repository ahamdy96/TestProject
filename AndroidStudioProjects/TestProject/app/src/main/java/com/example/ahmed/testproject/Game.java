package com.example.ahmed.testproject;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmed on 6/16/17.
 */

public class Game {
    int mReleaseDate;
    String mName, mCategory;

    public Game(){

    }

    public int getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        mReleaseDate = releaseDate;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public static List<Game> getGames(int size){
        List<Game> games = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            Game game = new Game();
            game.setName("Game #");
            game.setReleaseDate(1990 + i);
            game.setCategory("Action");
            games.add(game);
        }
        Log.d("test", games.get(5).getName());

        return games;
    }
}
