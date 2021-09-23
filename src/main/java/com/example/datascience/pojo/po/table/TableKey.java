package com.example.datascience.pojo.po.table;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Gabri
 */
@Data
public class TableKey implements Serializable {

    private Integer id;

    private String token;
}
