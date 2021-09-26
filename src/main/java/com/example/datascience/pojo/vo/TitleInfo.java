package com.example.datascience.pojo.vo;

import com.example.datascience.pojo.po.paragraph.ParagraphFormat;
import com.example.datascience.pojo.po.title.Title;
import io.swagger.annotations.ApiModel;

@ApiModel("标题详细信息")
public class TitleInfo {
    private String paragraphText;
    private Integer paragraphId;
    private Double lineSpacing;
    private Integer indentFromLeft;
    private Integer indentFromRight;
    private Integer firstLineIndent;
    private String lvl;

    public TitleInfo() {
    }

    public TitleInfo(Title title) {
        this.paragraphId = title.getId();
        this.paragraphText = title.getText();
    }

    public TitleInfo(Title title, ParagraphFormat paragraphFormat) {
        this.paragraphId = title.getId();
        this.paragraphText = title.getText();
        this.lineSpacing = paragraphFormat.getLineSpacing();
        this.indentFromLeft = paragraphFormat.getIndentFromLeft();
        this.indentFromRight = paragraphFormat.getIndentFromRight();
        this.firstLineIndent = paragraphFormat.getFirstLineIndent();
        this.lvl = paragraphFormat.getLvl();
    }


    public TitleInfo(String paragraphText, Integer paragraphId, Double lineSpacing, Integer indentFromLeft, Integer indentFromRight, Integer firstLineIndent, String lvl) {
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

    public Double getLineSpacing() {
        return lineSpacing;
    }

    public void setLineSpacing(Double lineSpacing) {
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

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }
}
