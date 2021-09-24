package com.example.datascience.pojo;

import io.swagger.annotations.ApiModel;

@ApiModel("简单响应对象")
public class CommonInfo {
    private boolean result;

    public CommonInfo() {
    }

    public CommonInfo(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
