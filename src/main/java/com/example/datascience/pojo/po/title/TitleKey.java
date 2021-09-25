package com.example.datascience.pojo.po.title;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Ray
 */
@Data
public class TitleKey implements Serializable {
    private Integer id;

    private String wordToken;

    public TitleKey() {
    }

    public TitleKey(Integer id, String wordToken) {
        this.id = id;
        this.wordToken = wordToken;
    }
}
