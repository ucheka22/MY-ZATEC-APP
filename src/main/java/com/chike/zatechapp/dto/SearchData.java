package com.chike.zatechapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SearchData<T> {

    private MetaData metaData;
    private T records;
}
