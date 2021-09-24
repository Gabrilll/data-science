package com.example.datascience.pojo.po;

import javax.persistence.*;

@Entity
public class Paragraph {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "word_token")
    private String wordToken;
    @Column(name = "text")
    private String text;
    @Column(name = "paragraph_format_id")
    private Integer paragraphFormatId;
    @Column(name = "font_format_id")
    private Integer fontFormatId;
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

    public Integer getParagraphFormatId() {
        return paragraphFormatId;
    }

    public void setParagraphFormatId(Integer paragraphFormatId) {
        this.paragraphFormatId = paragraphFormatId;
    }

    public Integer getFontFormatId() {
        return fontFormatId;
    }

    public void setFontFormatId(Integer fontFormatId) {
        this.fontFormatId = fontFormatId;
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
