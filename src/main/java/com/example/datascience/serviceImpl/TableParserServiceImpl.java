package com.example.datascience.serviceImpl;

import com.example.datascience.pojo.table.TableInfo;
import com.example.datascience.service.TableParserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.List;

/**
 * @author Gabri
 */
@Service
@Slf4j
public class TableParserServiceImpl implements TableParserService {
    @Override
    public List<TableInfo> getAllTables(String token) {
        return null;
    }

    @Override
    public List<TableInfo> getAllTables(String token, int paragraphId) {
        return null;
    }

    @Override
    public int parseAllTables(FileInputStream fileInputStream,int id){
        try{
            XWPFDocument document=new XWPFDocument(fileInputStream);
            TableInfo tableInfo=new TableInfo();
            List<XWPFTable> tables=document.getTables();
            for(XWPFTable table:tables){
                List<XWPFTableRow> rows=table.getRows();
                for(XWPFTableRow row:rows){
                    List<XWPFTableCell> tableCells=row.getTableCells();
                    for(XWPFTableCell cell:tableCells){
                        tableInfo.addCell(cell.getText(),id++);
                    }
                }
            }
        }catch (Exception e){
            log.error("");
        }
        return id;
    }
}
