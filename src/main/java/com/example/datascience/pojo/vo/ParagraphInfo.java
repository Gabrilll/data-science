package com.example.datascience.pojo.vo;

import com.example.datascience.pojo.po.Font.FontFormat;
import com.example.datascience.pojo.po.paragraph.Paragraph;
import com.example.datascience.pojo.po.paragraph.ParagraphFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("段落详细信息")
@Data
public class ParagraphInfo {
    private String paragraphText;
    private Integer paragraphId;
    private Double fontSize;
    private String fontName;
    private Boolean isBold;
    private Boolean isItalic;
    private Boolean isInTable;
    private String lvl;
    private Double lineSpacing;
    private Integer fontAlignment;
    private Boolean isTableRowEnd;
    private Integer indentFromLeft;
    private Integer indentFromRight;
    private Integer firstLineIndent;

    public void merge(Paragraph paragraph) {
        this.paragraphId = paragraph.getId();
        this.paragraphText = paragraph.getText();
        this.isInTable = paragraph.getIsInTable();
        this.isTableRowEnd = paragraph.getIsTableRowEnd();
    }

    public void merge(ParagraphFormat format) {
        this.lvl = format.getLvl();
        this.lineSpacing = format.getLineSpacing();
        this.indentFromLeft = format.getIndentFromLeft();
        this.indentFromRight = format.getIndentFromRight();
        this.firstLineIndent = format.getFirstLineIndent();
    }

    public void merge(FontFormat format) {
        this.fontSize = format.getFontSize();
        this.fontName = format.getFontName();
        this.isBold = format.getIsBold();
        this.isItalic = format.getIsItalic();
        this.fontAlignment = format.getFontAlignment();
    }
}
