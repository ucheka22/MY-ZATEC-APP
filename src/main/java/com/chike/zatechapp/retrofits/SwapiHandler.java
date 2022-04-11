package com.chike.zatechapp.retrofits;

import com.chike.zatechapp.dto.AppResponse;
import com.chike.zatechapp.dto.ChuckJokeResponse;
import com.chike.zatechapp.dto.SwapiResponse;
import com.chike.zatechapp.services.SwapiService;
import com.chike.zatechapp.utils.CustomGsonConverterFactory;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class SwapiHandler {


    @Value("${swapi.base.url}")
    private String baseURL;

    private SwapiService swapiService;



    @PostConstruct
    public void init() {

        final OkHttpClient okHttpClient = new OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(40, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).addConverterFactory(CustomGsonConverterFactory.serializeNullFactory())
                .baseUrl(baseURL)
                .build();

        swapiService = retrofit.create(SwapiService.class);

    }

    public AppResponse getAllSwapiPeople()  {

        try {

            Response<SwapiResponse> res = swapiService.getSwapiPeople().execute();

            log.info("THE RESPONSE IS {}", res.toString());

            if (res.isSuccessful()) {
                return new AppResponse<>(true,"Request successful",res.body());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new AppResponse<>(false,"Request unsuccessful",null);
    }

    public AppResponse searchSwapiPeople(String query)  {

        try {

            Response<SwapiResponse> res = swapiService.searchSwapi(query).execute();

            log.info("THE RESPONSE IS {}", res.toString());

            if (res.isSuccessful()) {

                SwapiResponse data = res.body();

                if (data.getCount().equals(0))
                return new AppResponse<>(true,"Request successful",res.body());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new AppResponse<>(false,"Request unsuccessful",null);
    }

}