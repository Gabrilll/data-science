package com.example.datascience.service;

import com.example.datascience.pojo.vo.TableInfo;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.util.List;

/**
 * @author Gabri
 */
public interface TableParserService {
    /**
     * get all tables
     * @param token token
     * @return TableInfo
     */
    public List<TableInfo> getAllTables(String token);

    /**
     * get all tables of a paragraph
     * @param token token
     * @param paragraphId paragraph id
     * @return all tables
     */
    public List<TableInfo> getAllTables(String token,int paragraphId);

    /**
     * parse tables of a file
     * @param xwpfDocument tables
     * @param token token
     */
    public void parseAllTables(XWPFDocument xwpfDocument,String token);

}
