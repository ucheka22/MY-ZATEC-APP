package com.chike.zatechapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppResponse<T> {
    private Boolean success;
    private String message;
    private T data;


    public AppResponse(String message) {
        super();
        this.message = message;
    }

    public AppResponse( boolean success,String message, T data) {
        super();
        this.message = message;
        this.success = success;
        this.data = data;
    }
}
