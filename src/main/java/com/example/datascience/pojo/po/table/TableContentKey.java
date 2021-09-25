package com.example.datascience.pojo.po.table;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Gabri
 */
@Data
public class TableContentKey implements Serializable {

    private Integer id;

    private Integer tableId;

    private String token;
}
