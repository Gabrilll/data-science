package com.example.datascience.pojo.po;

/**
 * TitleDetail = Title + ParagraphFormat
 */
public class TitleDetail {
    private Integer id;
    private String wordToken;
    private String text;
    private Integer indentFromLeft;
    private Integer indentFromRight;
    private Integer firstLineIndent;
    private Integer lvl;

    public TitleDetail() {
    }

    public TitleDetail(Title title, ParagraphFormat paragraphFormat) {
        this.id = title.getId();
        this.wordToken = title.getWordToken();
        this.text = title.getText();
        this.indentFromLeft = paragraphFormat.getIndentFromLeft();
        this.indentFromRight = paragraphFormat.getIndentFromRight();
        this.firstLineIndent = paragraphFormat.getFirstLineIndent();
        this.lvl = paragraphFormat.getLvl();
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
