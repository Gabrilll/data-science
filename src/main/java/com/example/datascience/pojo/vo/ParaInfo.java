package com.example.datascience.pojo.vo;

import com.example.datascience.pojo.po.paragraph.Paragraph;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;

/**
 * @author Ray
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParaInfo {
    private Integer paragraphId;
    private String text;
    private boolean is_table_row_end;
    private boolean is_in_table;
    private Integer table_id;

    public ParaInfo(Paragraph paragraph) {
        this(paragraph.getId(), paragraph.getText(), paragraph.getIsTableRowEnd(), paragraph.getIsInTable(), paragraph.getTableId());
    }
}
