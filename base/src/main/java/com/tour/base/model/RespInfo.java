package com.tour.base.model;

import lombok.Data;

@Data
public class RespInfo<T> {

    private String rspCode;
    private String rspDesc;
    private T info;
    private String url;

}
