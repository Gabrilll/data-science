package com.example.datascience.pojo.po;

import javax.persistence.*;

@Entity
public class Word {
    @Id
    private String token;
    @Column(name = "text")
    private String text;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
