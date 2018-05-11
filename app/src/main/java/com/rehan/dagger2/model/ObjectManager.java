package com.rehan.dagger2.model;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by rehan on 05/11/2018.
 */
@Singleton
public class ObjectManager {
    private SharedPreferences sharedPreferences;
    private Gson gson;

    @Inject
    public ObjectManager(SharedPreferences sharedPreferences, Gson gson) {
        this.sharedPreferences = sharedPreferences;
        this.gson = gson;
    }

    public void save(String key, Object o){
        sharedPreferences.edit()
                .putString(key, gson.toJson(o))
                .apply();
    }

    public <T> T get(String key, Class<T> type){
        String json = sharedPreferences.getString(key, null);
        if(json == null){
            return null;
        }

        return gson.fromJson(json, type);
    }
}
