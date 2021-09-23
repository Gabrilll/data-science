package com.example.datascience.pojo.vo;

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
    private String tableContent;
    private List<TableCell> docParagraphs = new ArrayList<>();

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
