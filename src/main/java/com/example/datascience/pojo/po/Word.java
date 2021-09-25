package com.example.datascience.pojo.po;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Word implements Serializable {
    @Id
    private String token;
    @Column(name = "name")
    private String name;
    @Column(name = "origin_ext")
    private String originExt;
    @Column(name = "text")
    private byte[] text;

    public Word() {
    }

    public Word(String token, String name, String originExt, byte[] text) {
        this.token = token;
        this.name = name;
        this.originExt = originExt;
        this.text = text;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginExt() {
        return originExt;
    }

    public void setOriginExt(String originExt) {
        this.originExt = originExt;
    }

    public byte[] getText() {
        return text;
    }

    public void setText(byte[] text) {
        this.text = text;
    }
}
