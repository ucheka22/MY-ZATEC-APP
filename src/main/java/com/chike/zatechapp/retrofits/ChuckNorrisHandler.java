package com.chike.zatechapp.retrofits;

import com.chike.zatechapp.dto.AppResponse;
import com.chike.zatechapp.dto.ChuckJokeResponse;
import com.chike.zatechapp.exception.AppException;
import com.chike.zatechapp.services.ChuckNorrisService;
import com.chike.zatechapp.utils.CustomGsonConverterFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChuckNorrisHandler {


    @Value("${chuck.norris.base.url}")
    private String baseURL;
    private ChuckNorrisService chuckNorrisService;

    @PostConstruct
    public void init() {

        final OkHttpClient okHttpClient = new OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(40, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).addConverterFactory(CustomGsonConverterFactory.serializeNullFactory())
                .baseUrl(baseURL)
                .build();

        chuckNorrisService = retrofit.create(ChuckNorrisService.class);

    }

    public AppResponse getAllJokesCategories() {

        try {

            Response<List<String>> res = chuckNorrisService.getAllJokesCategories().execute();

            log.info("THE RESPONSE IS {}", res.toString());

            if (res.isSuccessful()) {

                List<String> categories = res.body();

                if (categories.isEmpty())
                    throw new AppException("No categories found");

                return new AppResponse<>(true,"Request successful",categories);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new AppResponse<>(false,"Request unsuccessful",null);
    }

    public AppResponse searchJokes(String query) {

        try {

            Response<ChuckJokeResponse> res = chuckNorrisService.searchJokes(query).execute();

            log.info("THE RESPONSE IS {}", res.toString());

            if (res.isSuccessful()) {

                return new AppResponse<>(true,"Request successful",res.body());

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new AppResponse<>(false,"Request unsuccessful",null);
    }

}