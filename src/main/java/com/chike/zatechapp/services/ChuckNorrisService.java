package com.chike.zatechapp.services;

import com.chike.zatechapp.dto.ChuckJokeResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;


public interface ChuckNorrisService {

    String JOKES_CATEGORIES = "jokes/categories";
    String JOKES_SEARCH = "jokes/search";

    @GET(JOKES_CATEGORIES)
    Call<List<String>> getAllJokesCategories();

    @GET(JOKES_SEARCH)
    Call<ChuckJokeResponse> searchJokes(@Query("query") String query);

}

