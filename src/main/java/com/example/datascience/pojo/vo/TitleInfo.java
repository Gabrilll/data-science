package com.example.datascience.pojo.vo;

import com.example.datascience.pojo.po.title.Title;
import io.swagger.annotations.ApiModel;

@ApiModel("标题详细信息")
public class TitleInfo {
    private String paragraphText;
    private Integer paragraphId;
    private Integer lineSpacing;
    private Integer indentFromLeft;
    private Integer indentFromRight;
    private Integer firstLineIndent;
    private Integer lvl;

    public TitleInfo() {
    }

    public TitleInfo(Title title) {
        this.paragraphId = title.getId();
    }

    public TitleInfo(String paragraphText, Integer paragraphId, Integer lineSpacing, Integer indentFromLeft, Integer indentFromRight, Integer firstLineIndent, Integer lvl) {
        this.paragraphText = paragraphText;
        this.paragraphId = paragraphId;
        this.lineSpacing = lineSpacing;
        this.indentFromLeft = indentFromLeft;
        this.indentFromRight = indentFromRight;
        this.firstLineIndent = firstLineIndent;
        this.lvl = lvl;
    }

    public String getParagraphText() {
        return paragraphText;
    }

    public void setParagraphText(String paragraphText) {
        this.paragraphText = paragraphText;
    }

    public Integer getParagraphId() {
        return paragraphId;
    }

    public void setParagraphId(Integer paragraphId) {
        this.paragraphId = paragraphId;
    }

    public Integer getLineSpacing() {
        return lineSpacing;
    }

    public void setLineSpacing(Integer lineSpacing) {
        this.lineSpacing = lineSpacing;
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
