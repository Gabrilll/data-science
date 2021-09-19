package com.example.datascience.pojo.table;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gabri
 */
public class TableInfo {
    private String textBefore = "表格如下";
    private List<TableCell> docParagraphs = new ArrayList<>();

    public void addCell(String paragraphText, Integer paragraphId) {
        TableCell tableCell = new TableCell(paragraphText, paragraphId);
        docParagraphs.add(tableCell);
    }

    @Data
    @AllArgsConstructor
    private static class TableCell {
        private String paragraphText;
        private Integer paragraphId;
    }
}
