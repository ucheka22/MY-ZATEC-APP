package com.chike.zatechapp.controller;

import com.chike.zatechapp.dto.AppResponse;
import com.chike.zatechapp.retrofits.ChuckNorrisHandler;
import com.chike.zatechapp.retrofits.SwapiHandler;
import com.chike.zatechapp.services.AppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@Tag(name = "APP Controller", description = "Get Jokes Category & Star War People")
@RequiredArgsConstructor
public class AppController {

    @Value("${swapi.base.url}")
    private String swapiBaseUrl;
    @Value("${chuck.norris.base.url}")
    private String chuckNorrisBaseUrl;

    private final ChuckNorrisHandler chuckNorrisHandler;
    private final SwapiHandler swapiHandler;
    private final AppService appService;

    @Operation(summary = "Get All Chuck Norris Jokes Categories")
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/chuck/categories")
    public AppResponse getJokesCategories() {

        return chuckNorrisHandler.getAllJokesCategories();
    }

    @Operation(summary = "Get Random Chuck Norris Joke")
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/chuck/jokes")
    public AppResponse searchJokesByCategory(@Parameter(description = "The joke category") @RequestParam("category") String category) {

        return chuckNorrisHandler.searchJokesByCategory(category);
    }

    @Operation(summary = "Get All Star War Actors")
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/swapi/people")
    public AppResponse getSwapiPeople() {

        return swapiHandler.getAllSwapiPeople();
    }

    @Operation(summary = "Search Chuck Jokes and Star War Actors")
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/search")
    public AppResponse search(@Parameter(description = "The search query string") @RequestParam("query") String query) {

       return appService.search(query);
    }

}
