package com.chike.zatechapp.services;

import com.chike.zatechapp.APIType;
import com.chike.zatechapp.dto.AppResponse;
import com.chike.zatechapp.dto.MetaData;
import com.chike.zatechapp.dto.SearchData;
import com.chike.zatechapp.retrofits.ChuckNorrisHandler;
import com.chike.zatechapp.retrofits.SwapiHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppService {

    @Value("${swapi.base.url}")
    private String swapiBaseUrl;
    @Value("${chuck.norris.base.url}")
    private String chuckNorrisBaseUrl;

    private final ChuckNorrisHandler chuckNorrisHandler;
    private final SwapiHandler swapiHandler;

    public AppResponse searchAPIs(String query) {
        List<SearchData> searchDataList = new ArrayList<>();


        MetaData chuckNorris = new MetaData();
        chuckNorris.setApiType(APIType.CHUCKNORRIS);
        chuckNorris.setUrl(chuckNorrisBaseUrl + "jokes/search");

        MetaData swapi = new MetaData();
        swapi.setApiType(APIType.SWAPI);
        swapi.setUrl(swapiBaseUrl + "api/people/search");

        List<MetaData> apis = Arrays.asList(chuckNorris, swapi);


        apis.parallelStream().forEach((metaData -> {

            if (metaData.getApiType().equals(APIType.CHUCKNORRIS)) {

                SearchData data = new SearchData();

                data.setMetaData(metaData);
                data.setData((Object) chuckNorrisHandler.searchJokes(query).getData());

                if (data.getData() != null)
                    searchDataList.add(data);

            }

            if (metaData.getApiType().equals(APIType.SWAPI)) {

                SearchData data = new SearchData();

                data.setMetaData(metaData);
                data.setData((Object) swapiHandler.searchSwapiPeople(query).getData());

                if (data.getData() != null)
                    searchDataList.add(data);

            }
        }));
        return new AppResponse(true, "Request successful", searchDataList);
    }
}
