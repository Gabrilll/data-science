package com.example.datascience.pojo.vo;

import io.swagger.annotations.ApiModel;

@ApiModel("文档标识")
public class WordInfo {
    private String token;

    public WordInfo() {
    }

    public WordInfo(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
