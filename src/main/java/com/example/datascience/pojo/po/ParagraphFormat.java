package com.example.datascience.pojo.po;

import javax.persistence.*;

@Entity
public class ParagraphFormat {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "indent_from_left")
    private Integer indentFromLeft;
    @Column(name = "indent_from_right")
    private Integer indentFromRight;
    @Column(name = "first_line_indent")
    private Integer firstLineIndent;
    @Column(name = "lvl")
    private Integer lvl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getLvl() {
        return lvl;
    }

    public void setLvl(Integer lvl) {
        this.lvl = lvl;
    }
}
