package com.example.android_sprint3_challenge;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class Pokemon {

    private ArrayList<String> moves = new ArrayList<>();
    private ArrayList<String> types = new ArrayList<>();
    private Bitmap image;
    private String name;

    public ArrayList<String> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<String> moves) {
        this.moves = moves;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pokemon(String pokeName, JSONArray pokeMoves, JSONArray pokeTypes, String pokeImageUrl) {
        this.name = pokeName;

        //Unwrapping jsonArrays
        for (int i = 0; i < pokeMoves.length(); ++i) {

            try {
                this.moves.add (pokeMoves.getJSONObject(i).getJSONObject("move").getString("name"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



        this.image = NetworkAdapter.httpImageRequest(pokeImageUrl);

        for (int i = 0; i < pokeTypes.length(); ++i) {

            try {
                this.types.add (pokeTypes.getJSONObject(i).getJSONObject("type").getString("name"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}
