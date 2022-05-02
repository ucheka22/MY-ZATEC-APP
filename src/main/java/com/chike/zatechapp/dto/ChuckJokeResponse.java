package com.chike.zatechapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class ChuckJokeResponse {
    private  Integer total;
    private List<Joke> result;
}
