package com.example.datascience.pojo.po;

import javax.persistence.*;

@Entity
public class Title {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "word_token")
    private String wordToken;
    @Column(name = "text")
    private String text;
    @Column(name = "paragraph_format_id")
    private Integer paragraphFormatId;

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

    public Integer getParagraphFormatId() {
        return paragraphFormatId;
    }

    public void setParagraphFormatId(Integer paragraphFormatId) {
        this.paragraphFormatId = paragraphFormatId;
    }
}
