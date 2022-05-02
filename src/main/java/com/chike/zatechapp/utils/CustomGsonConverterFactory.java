package com.chike.zatechapp.utils;

import com.google.gson.GsonBuilder;
import retrofit2.converter.gson.GsonConverterFactory;


public class CustomGsonConverterFactory {

    public static GsonConverterFactory serializeNullFactory(){

        return GsonConverterFactory.create( new GsonBuilder().serializeNulls()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create());
    }
}
