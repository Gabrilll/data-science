package com.example.datascience.pojo.po.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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
    @Column(name = "table_id")
    private Integer tableId;

    @Id
    @Column(name = "word_token")
    private String token;

    @Column(name = "row_num")
    private Integer row;

    @Column(name = "col_num")
    private Integer col;

    private String text;
}
