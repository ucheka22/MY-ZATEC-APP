package com.chike.zatechapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class Joke {

    private  String id;
    private String value;
    private String url;
    private String icon_url;
    private List<String> categories;
    private String created_at;
    private String updated_at;

}
