package com.example.datascience.pojo.po;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Word implements Serializable {
    @Id
    private String token;

    @Column(name = "text")
    private String text;

    public Word() {
    }

    public Word(String token, String text) {
        this.token = token;
        this.text = text;
    }

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
