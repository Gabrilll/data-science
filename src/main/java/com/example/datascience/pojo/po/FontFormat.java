package com.example.datascience.pojo.po;

import javax.persistence.*;

@Entity
public class FontFormat {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "color")
    private String color;
    @Column(name = "font_size")
    private Integer fontSize;
    @Column(name = "font_name")
    private String fontName;
    @Column(name = "is_bold")
    private Boolean isBold;
    @Column(name = "is_italic")
    private Boolean isItalic;
    @Column(name = "font_alignment")
    private Integer fontAlignment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
