package com.example.datascience.service;

import com.example.datascience.pojo.table.TableInfo;

import java.io.FileInputStream;
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
     * @param fileInputStream input stream
     * @param id start id
     * @return next id
     */
    public int parseAllTables(FileInputStream fileInputStream,int id);
}
