package com.example.datascience.pojo.po.Font;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Ray
 */
@Data
public class FontFormatKey implements Serializable {
    private Integer id;
    private Integer paragraph_id;
    private String token;
}
