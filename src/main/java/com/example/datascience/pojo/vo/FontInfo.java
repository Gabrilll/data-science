package com.example.datascience.pojo.vo;

/**
 * @author Ray
 */
import io.swagger.annotations.ApiModel;

@ApiModel("字体详细信息")
public class FontInfo {
    private String paragraphText;
    private Integer paragraphId;
    private Integer fontSize;
    private String fontName;
    private Boolean isBold;
    private Boolean isItalic;
    private String fontAlignment;

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

    public String getFontAlignment() {
        return fontAlignment;
    }

    public void setFontAlignment(String fontAlignment) {
        this.fontAlignment = fontAlignment;
    }
}