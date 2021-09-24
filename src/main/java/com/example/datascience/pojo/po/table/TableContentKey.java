package com.example.datascience.pojo.po.table;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Gabri
 */
@Data
public class TableContentKey implements Serializable {

    private Integer id;

    private Integer table_id;

    private String word_token;
}
