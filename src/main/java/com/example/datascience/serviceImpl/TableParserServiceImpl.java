package com.example.datascience.serviceImpl;

import com.example.datascience.dao.table.TableContentRepository;
import com.example.datascience.dao.table.TableRepository;
import com.example.datascience.pojo.po.table.Table;
import com.example.datascience.pojo.po.table.TableContent;
import com.example.datascience.pojo.vo.TableInfo;
import com.example.datascience.service.TableParserService;
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

    @Autowired
    TableParserServiceImpl(TableRepository tableRepository, TableContentRepository tableContentRepository) {
        this.tableRepository = tableRepository;
        this.tableContentRepository = tableContentRepository;
    }

    @Override
    public List<TableInfo> getAllTables(String token) {
        ArrayList<TableInfo> tableInfos=new ArrayList<>();
        List<Table> tables=tableRepository.findTablesByToken(token);
        for(Table table:tables){
            TableInfo tableInfo=new TableInfo(table);
            List<TableContent> tableContents=tableContentRepository.findTableContentsByTokenAndTableId(token,table.getId());
            for(TableContent tableContent:tableContents){
                tableInfo.addCell(tableContent.getText(),tableContent.getId());
            }
            tableInfos.add(tableInfo);

        }
        return tableInfos;
    }

    @Override
    public List<TableInfo> getAllTables(String token, int paragraphId) {
        return null;
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

            for (XWPFTableRow xwpfTableRow : xwpfTable.getRows()) {
                for (XWPFTableCell xwpfTableCell : xwpfTableRow.getTableCells()) {
                    TableContent tableContent = new TableContent(id++, pos, token, row, col, xwpfTableCell.getText());
                    tableContentRepository.save(tableContent);
                    //TODO
                    //paragraphService.parseParagraphs(xwpfTableCell.getParagraphs());
                    col++;
                }
                row++;
            }
        }
    }
}
