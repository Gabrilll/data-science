package com.example.datascience.pojo;

/**
 * @author Gabri
 */
public class Response<T> {
    private String code;
    private String msg;
    private T data;

    public Response() {
        this.code = "0";
        this.msg = "success";
    }

    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(T data) {
        this.code = "0";
        this.msg = "success";
        this.data = data;
    }

    public Response(String msg, T data) {
        this.code = "0";
        this.msg = msg;
        this.data = data;
    }
}
