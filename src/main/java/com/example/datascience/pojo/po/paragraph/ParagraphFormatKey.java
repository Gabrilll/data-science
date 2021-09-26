package com.example.datascience.pojo.po.paragraph;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Ray
 */
@Data
public class ParagraphFormatKey implements Serializable {
    private Integer id;

    private String token;

    public ParagraphFormatKey() {
    }

    public ParagraphFormatKey(Integer id, String token) {
        this.id = id;
        this.token = token;
    }
}
