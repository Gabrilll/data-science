package com.example.datascience.pojo.po;

/**
 * ParagraphDetail = Paragraph + ParagraphFormat + FontFormat
 */
public class ParagraphDetail {
    private Integer id;
    private String wordToken;
    private String text;
    private Boolean isTableRowEnd;
    private Boolean isInTable;
    private Integer tableId;

    private Integer indentFromLeft;
    private Integer indentFromRight;
    private Integer firstLineIndent;
    private Integer lvl;

    private String color;
    private Integer fontSize;
    private String fontName;
    private Boolean isBold;
    private Boolean isItalic;
    private Integer fontAlignment;

    public ParagraphDetail() {
    }

    public ParagraphDetail(Paragraph paragraph, ParagraphFormat paragraphFormat, FontFormat fontFormat) {
        this.id = paragraph.getId();
        this.wordToken = paragraph.getWordToken();
        this.text = paragraph.getText();
        this.isTableRowEnd = paragraph.getTableRowEnd();
        this.isInTable = paragraph.getInTable();
        this.tableId = paragraph.getTableId();

        this.indentFromLeft = paragraphFormat.getIndentFromLeft();
        this.indentFromRight =paragraphFormat.getIndentFromRight();
        this.firstLineIndent = paragraphFormat.getFirstLineIndent();
        this.lvl = paragraphFormat.getLvl();

        this.color = fontFormat.getColor();
        this.fontSize = fontFormat.getFontSize();
        this.fontName = fontFormat.getFontName();
        this.isBold = fontFormat.getBold();
        this.isItalic = fontFormat.getItalic();
        this.fontAlignment = fontFormat.getFontAlignment();
    }

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public Integer getFontAlignment() {
        return fontAlignment;
    }

    public void setFontAlignment(Integer fontAlignment) {
        this.fontAlignment = fontAlignment;
    }
}
