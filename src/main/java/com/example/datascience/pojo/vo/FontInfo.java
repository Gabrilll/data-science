package com.example.datascience.pojo.vo;

import com.example.datascience.pojo.po.Font.FontFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ray
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FontInfo {
    private String paragraphText;
    private Integer paragraphId;
    private String color;
    private Double fontSize;
    private String fontName;
    private Boolean isBold;
    private Boolean isItalic;
    private Integer fontAlignment;

    public FontInfo(FontFormat fontFormat) {
        this(fontFormat.getText(), fontFormat.getParagraphId(), fontFormat.getColor(), fontFormat.getFontSize(), fontFormat.getFontName(), fontFormat.getIsBold(), fontFormat.getIsItalic(), fontFormat.getFontAlignment());
    }

}