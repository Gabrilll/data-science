package com.example.datascience.pojo.po.paragraph;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@IdClass(ParagraphKey.class)
public class Paragraph {
    @Id
    private Integer id;
    @Id
    @Column(name = "word_token")
    private String wordToken;
    @Column(name = "text")
    private String text;
    @Column(name = "is_table_row_end")
    private Boolean isTableRowEnd;
    @Column(name = "is_in_table")
    private Boolean isInTable;
    @Column(name = "table_id")
    private Integer tableId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWordToken() {
        return wordToken;
    }

    public void setWordToken(String wordToken) {
        this.wordToken = wordToken;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getTableRowEnd() {
        return isTableRowEnd;
    }

    public void setTableRowEnd(Boolean tableRowEnd) {
        isTableRowEnd = tableRowEnd;
    }

    public Boolean getInTable() {
        return isInTable;
    }

    public void setInTable(Boolean inTable) {
        isInTable = inTable;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }
}
