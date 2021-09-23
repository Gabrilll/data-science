package com.example.datascience.pojo.po.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * @author Gabri
 */
@Entity(name = "table_content")
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(TableContentKey.class)
public class TableContent implements Serializable {
    @Id
    private Integer id;
    @Id
    private Integer table_id;

    @Id
    private String word_token;

    private Integer row_num;
    private Integer col_num;
    private String text;
}
