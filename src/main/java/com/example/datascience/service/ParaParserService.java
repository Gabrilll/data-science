package com.example.datascience.service;

import com.example.datascience.pojo.vo.FontInfo;
import com.example.datascience.pojo.vo.ParagraphInfo;
import jdk.nashorn.internal.ir.LiteralNode;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.FileInputStream;
import java.util.List;

/**
 * @author Ray
 */
public interface ParaParserService {
    /**
     * get all paragraphs
     *
     * @param token token
     * @return all para info
     */
    public List<ParagraphInfo> getAllParas(String token);

    /**
     * get all paragraphs in docx
     *
     * @param fileInputStream input
     * @return all para info
     */
    void ParasParserInDocx(FileInputStream fileInputStream, String token);

    /**
     * get targeted paragraph
     * @param token token
     * @param paragraphId paragraph id
     * @return para info
     */
    public List<ParagraphInfo> getPara(String token, int paragraphId);

    public List<ParagraphInfo> getParaFormat(String token, int paragraph_id);

    public List<FontInfo> getFontFormat(String token, int paragraph_id);

    public void tableParaParser(XWPFDocument doc, XWPFParagraph para, int paragraph_id, int table_id, String token, boolean isTableRowEnd);

//    public List<>
}
