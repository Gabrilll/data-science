package com.example.datascience.pojo.po.Font;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "font_format")
@Data
@IdClass(FontFormatKey.class)
public class FontFormat {
    @Id
    private Integer id;
    @Id
    @Column(name = "paragraph_id")
    private Integer paragraph_id;
    @Id
    @Column(name = "token")
    private String token;
    @Column(name = "text")
    private String text;
    @Column(name = "color")
    private String color;
    @Column(name = "font_size")
    private Double fontSize;
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

    public Double getFontSize() {
        return fontSize;
    }

    public void setFontSize(Double fontSize) {
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getParagraph_id() {
        return paragraph_id;
    }

    public void setParagraph_id(Integer paragraph_id) {
        this.paragraph_id = paragraph_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
