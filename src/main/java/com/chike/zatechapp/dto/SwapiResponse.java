package com.chike.zatechapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class SwapiResponse {
    private Integer count;
    private String next;
    private String previous;
    private List<People> results;
}
