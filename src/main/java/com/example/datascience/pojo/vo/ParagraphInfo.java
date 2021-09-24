package com.example.datascience.pojo.vo;

import io.swagger.annotations.ApiModel;

@ApiModel("段落详细信息")
public class ParagraphInfo {
    private String paragraphText;
    private Integer paragraphId;
    private Integer fontSize;
    private String fontName;
    private Boolean isBold;
    private Boolean isItalic;
    private Boolean isInTable;
    private Integer lvl;
    private Integer lineSpacing;
    private String fontAlignment;
    private Boolean isTableRowEnd;
    private Integer indentFromLeft;
    private Integer indentFromRight;
    private Integer firstLineIndent;

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

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public Boolean getBold() {
        return isBold;
    }

    public void setBold(Boolean bold) {
        isBold = bold;
    }

    public Boolean getItalic() {
        return isItalic;
    }

    public void setItalic(Boolean italic) {
        isItalic = italic;
    }

    public Boolean getInTable() {
        return isInTable;
    }

    public void setInTable(Boolean inTable) {
        isInTable = inTable;
    }

    public Integer getLvl() {
        return lvl;
    }

    public void setLvl(Integer lvl) {
        this.lvl = lvl;
    }

    public Integer getLineSpacing() {
        return lineSpacing;
    }

    public void setLineSpacing(Integer lineSpacing) {
        this.lineSpacing = lineSpacing;
    }

    public String getFontAlignment() {
        return fontAlignment;
    }

    public void setFontAlignment(String fontAlignment) {
        this.fontAlignment = fontAlignment;
    }

    public Boolean getTableRowEnd() {
        return isTableRowEnd;
    }

    public void setTableRowEnd(Boolean tableRowEnd) {
        isTableRowEnd = tableRowEnd;
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
}
