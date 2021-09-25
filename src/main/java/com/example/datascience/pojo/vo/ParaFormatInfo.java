package com.example.datascience.pojo.vo;

import com.example.datascience.pojo.po.paragraph.ParagraphFormat;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ray
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParaFormatInfo {
    private Integer paragraphId;
    private String lvl;
    private Double lineSpacing;
    private Integer indentFromLeft;
    private Integer indentFromRight;
    private Integer firstLineIndent;

    public ParaFormatInfo(ParagraphFormat paragraphFormat) {
        this(paragraphFormat.getId(), paragraphFormat.getLvl(), paragraphFormat.getLineSpacing(), paragraphFormat.getIndentFromLeft(), paragraphFormat.getIndentFromRight(), paragraphFormat.getFirstLineIndent());
    }
}
