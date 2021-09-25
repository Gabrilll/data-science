package com.example.datascience.pojo.po.title;

import lombok.Data;

import javax.persistence.*;

@Entity(name =  "title")
@Data
@IdClass(TitleKey.class)
public class Title {
    @Id
    private Integer id;
    @Id
    @Column(name = "word_token")
    private String wordToken;
    @Column(name = "text")
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWordToken() {
        return wordToken;
    }

    public void setWordToken(String wordToken) {
        this.wordToken = wordToken;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
