package com.chike.zatechapp.dto;

import com.chike.zatechapp.APIType;
import lombok.Data;

@Data
public class MetaData {

    private APIType apiType;
    private String url;
}
