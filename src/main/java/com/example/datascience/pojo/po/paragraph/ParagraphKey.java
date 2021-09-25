package com.example.datascience.pojo.po.paragraph;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Ray
 */
@Data
public class ParagraphKey implements Serializable {
    private Integer id;

    private String wordToken;
}
