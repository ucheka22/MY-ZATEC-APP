package com.chike.zatechapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1")
@Tag(name = "APP Controller", description = "Get Jokes Category & Star War People")
public class AppController {

    @Operation(summary = "Get All Chuck Norris Jokes Categories")
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/chuck/categories")
    public String getJokesCategories() {
        return "Hello World";
    }

    @GetMapping("/swapi/people")
    public String getSwapiPeople() {
        return "Hello World";
    }

    @GetMapping("/search")
    public String search(@Parameter(description = "The search query string") @RequestParam("query") String query) {
        return "Hello World";
    }

}
