package com.example.datascience.pojo.vo;

import com.example.datascience.pojo.po.table.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gabri
 */
@Data
public class TableInfo {

    private String textBefore = "";
    private String textAfter = "";
    private Integer paragraphBefore;
    private Integer paragraphAfter;
    private List<TableCell> docParagraphs = new ArrayList<>();
    private String tableContent;

    public TableInfo(Table table) {
        this.textBefore = table.getTextBefore();
        this.textAfter = table.getTextAfter();
        this.paragraphBefore = table.getParagraphIdBefore();
        this.paragraphAfter = table.getParagraphIdAfter();
        this.tableContent = table.getTableContent();
    }

    public void addCell(String paragraphText, Integer paragraphId) {
        TableCell tableCell = new TableCell(paragraphText, paragraphId);
        docParagraphs.add(tableCell);
    }

    @Data
    @AllArgsConstructor
    public static class TableCell {
        private String paragraphText;
        private Integer paragraphId;
    }
}
