package com.example.datascience.pojo;

/**
 * @author Gabri
 */
public class Response<T> {
    private String code;
    private String msg;
    private T data;

    public static Response success() {
        return new Response("0", "success");
    }

    public static Response success(Object data) {
        return new Response("0", "success", data);
    }

    public static Response error() {
        return new Response("400", "fail");
    }

    public static Response error(Object reason) {
        return new Response("400", "fail", reason);
    }

    public static Response error(String errCode, Object reason) {
        return new Response(errCode, "fail", reason);
    }

    public Response() {
        this.code = "0";
        this.msg = "success";
    }

    public Response(T data) {
        this.code = "0";
        this.msg = "success";
        this.data = data;
    }

    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(String msg, T data) {
        this.code = "0";
        this.msg = msg;
        this.data = data;
    }

    public Response(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
