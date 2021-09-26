package com.example.datascience.pojo.po.Font;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Ray
 */
@Data
public class FontFormatKey implements Serializable {
    private Integer id;
    private Integer paragraphId;
    private String token;

    public FontFormatKey() {
    }

    public FontFormatKey(Integer id, Integer paragraphId, String token) {
        this.id = id;
        this.paragraphId = paragraphId;
        this.token = token;
    }
}
