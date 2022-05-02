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

import java.util.*;

@Service
@RequiredArgsConstructor
public class AppService {

    @Value("${swapi.base.url}")
    private String swapiBaseUrl;
    @Value("${chuck.norris.base.url}")
    private String chuckNorrisBaseUrl;

    private final ChuckNorrisHandler chuckNorrisHandler;
    private final SwapiHandler swapiHandler;


    public AppResponse search(String query) {

        List<SearchData> searchDataList = new ArrayList<>();

        List<APIType> apiTypes = Arrays.asList(APIType.CHUCKNORRIS, APIType.SWAPI);


        apiTypes.parallelStream().forEach((type -> {

            if (type.equals(APIType.CHUCKNORRIS)) {

                MetaData chuckNorrisMeta = new MetaData();

                chuckNorrisMeta.setApiType(APIType.CHUCKNORRIS);
                chuckNorrisMeta.setUrl(chuckNorrisBaseUrl + "jokes/search");

                SearchData searchData = new SearchData();

                searchData.setRecords(chuckNorrisHandler.searchJokes(query).getData());
                searchData.setMetaData(chuckNorrisMeta);
                searchDataList.add(searchData);

            }else {
                MetaData swapiMeta = new MetaData();

                swapiMeta.setApiType(APIType.SWAPI);
                swapiMeta.setUrl(swapiBaseUrl + "api/people/search" );

                SearchData searchData = new SearchData();

                searchData.setRecords(swapiHandler.searchSwapiPeople(query).getData());
                searchData.setMetaData(swapiMeta);
                searchDataList.add(searchData);
            }
        }));


        return new AppResponse(true,"Request successful",searchDataList);
    }


}
