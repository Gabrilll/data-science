package com.example.datascience.pojo.po.paragraph;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "paragraph_format")
@Data
@IdClass(ParagraphFormatKey.class)
public class ParagraphFormat {
    @Id
    private Integer id;
    @Id
    private String token;
    @Column(name = "indent_from_left")
    private Integer indentFromLeft;
    @Column(name = "indent_from_right")
    private Integer indentFromRight;
    @Column(name = "first_line_indent")
    private Integer firstLineIndent;
    @Column(name = "lvl")
    private String lvl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getIndentFromLeft() {
        return indentFromLeft;
    }

    public void setIndentFromLeft(Integer indentFromLeft) {
        this.indentFromLeft = indentFromLeft;
    }

    public Integer getIndentFromRight() {
        return indentFromRight;
    }

    public void setIndentFromRight(Integer indentFromRight) {
        this.indentFromRight = indentFromRight;
    }

    public Integer getFirstLineIndent() {
        return firstLineIndent;
    }

    public void setFirstLineIndent(Integer firstLineIndent) {
        this.firstLineIndent = firstLineIndent;
    }

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }
}
