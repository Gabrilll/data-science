package com.example.datascience.pojo.po.table;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * @author Gabri
 */
@Entity(name = "table_info")
@Data
@IdClass(TableKey.class)
public class Table implements Serializable {
    @Id
    private Integer id;

    @Id
    @Column(name = "word_token")
    private String token;

    @Column(name = "paragraph_id_before")
    private Integer paragraphIdBefore;

    @Column(name = "paragraph_id_after")
    private Integer paragraphIdAfter;

    @Column(name = "text_before")
    private String textBefore;

    @Column(name = "text_after")
    private String textAfter;

    @Column(name = "table_content")
    private String tableContent;
}
