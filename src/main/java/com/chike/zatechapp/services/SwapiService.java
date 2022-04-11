package com.chike.zatechapp.services;

import com.chike.zatechapp.dto.SwapiResponse;
import retrofit2.Call;
import retrofit2.http.*;



public interface SwapiService {

    String SWAPI_PEOPLE = "api/people";
    String SWAPI_SEARCH = "api/people/";

    @GET(SWAPI_PEOPLE)
    Call<SwapiResponse> getSwapiPeople();

    @GET(SWAPI_SEARCH)
    Call<SwapiResponse> searchSwapi(@Query("search") String search);

}

