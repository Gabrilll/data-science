package com.example.datascience.serviceImpl;

import com.example.datascience.dao.table.TableContentRepository;
import com.example.datascience.dao.table.TableRepository;
import com.example.datascience.pojo.po.table.Table;
import com.example.datascience.pojo.po.table.TableContent;
import com.example.datascience.pojo.vo.TableInfo;
import com.example.datascience.service.ParaParserService;
import com.example.datascience.service.TableParserService;
import com.example.datascience.service.TitleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gabri
 */
@Service
@Slf4j
public class TableParserServiceImpl implements TableParserService {
    private final TableRepository tableRepository;
    private final TableContentRepository tableContentRepository;
    private final ParaParserService paraParserService;
    private final TitleService titleService;

    @Autowired
    TableParserServiceImpl(TableRepository tableRepository, TableContentRepository tableContentRepository, ParaParserServiceImpl paraParserService, TitleServiceImpl titleService) {
        this.tableRepository = tableRepository;
        this.tableContentRepository = tableContentRepository;
        this.paraParserService = paraParserService;
        this.titleService = titleService;
    }

    @Override
    public List<TableInfo> getAllTables(String token) {
        ArrayList<TableInfo> tableInfos = new ArrayList<>();
        List<Table> tables = tableRepository.findTablesByToken(token);
        for (Table table : tables) {
            TableInfo tableInfo = new TableInfo(table);
            List<TableContent> tableContents = tableContentRepository.findTableContentsByTokenAndTableId(token, table.getId());
            for (TableContent tableContent : tableContents) {
                tableInfo.addCell(tableContent.getText(), tableContent.getId());
            }
            tableInfos.add(tableInfo);

        }
        return tableInfos;
    }

    @Override
    public List<TableInfo> getAllTables(String token, int paragraphId) {
        ArrayList<TableInfo> tableInfos = new ArrayList<>();
        Integer endParaId = titleService.getEndParagraphId(paragraphId,token);
        List<Table> tables = tableRepository.findTablesByTokenAndIdBetween(token, paragraphId, endParaId);
        for (Table table : tables) {
            TableInfo tableInfo = new TableInfo(table);
            List<TableContent> tableContents = tableContentRepository.findTableContentsByTokenAndTableId(token, table.getId());
            for (TableContent tableContent : tableContents) {
                tableInfo.addCell(tableContent.getText(), tableContent.getId());
            }
            tableInfos.add(tableInfo);

        }
        return tableInfos;

    }

    @Override
    public void parseAllTables(XWPFDocument xwpfDocument, String token) {
        List<XWPFTable> xwpfTables = xwpfDocument.getTables();
        int id = xwpfDocument.getBodyElements().size();
        for (XWPFTable xwpfTable : xwpfTables) {
            Table table = new Table();
            int pos = xwpfDocument.getPosOfTable(xwpfTable);
            table.setId(pos);
            table.setToken(token);
            XWPFParagraph before = (XWPFParagraph) xwpfDocument.getBodyElements().get(pos - 1);

            if (before != null) {
                table.setTextBefore(before.getText());
                table.setParagraphIdBefore(xwpfDocument.getPosOfParagraph(before));
            }

            XWPFParagraph after = (XWPFParagraph) xwpfDocument.getBodyElements().get(pos + 1);

            if (after != null) {
                table.setTextAfter(after.getText());
                table.setParagraphIdAfter(xwpfDocument.getPosOfParagraph(after));
            }

            table.setTableContent(xwpfTable.getText());

            tableRepository.save(table);

            int row = 0;
            int col = 0;
            int cellNum = 0;
            int rowTotal = xwpfTable.getRows().size();
            int colTotal = 0;

            for (XWPFTableRow xwpfTableRow : xwpfTable.getRows()) {
                for (XWPFTableCell xwpfTableCell : xwpfTableRow.getTableCells()) {
                    if (colTotal == 0) {
                        colTotal = xwpfTableRow.getTableCells().size();
                    }
                    cellNum++;
                    TableContent tableContent = new TableContent(id++, pos, token, row, col, xwpfTableCell.getText());
                    tableContentRepository.save(tableContent);
                    boolean isTableEnd = (cellNum == rowTotal * colTotal);
                    for (XWPFParagraph paragraph : xwpfTableCell.getParagraphs()) {
                        paraParserService.tableParaParser(xwpfDocument, paragraph, id++, tableContent.getTableId(), token, isTableEnd);
                    }
                    col++;
                }
                row++;
                col = 0;
            }
        }
    }
}
