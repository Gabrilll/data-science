package com.example.datascience.service;

import com.example.datascience.pojo.vo.FontInfo;
import com.example.datascience.pojo.vo.ParaFormatInfo;
import com.example.datascience.pojo.vo.ParaInfo;
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
    public List<ParaInfo> getAllParas(String token);

    /**
     * get all paragraphs in docx
     *
     * @return all para info
     */

    void ParasParserInDocx(XWPFDocument document, String token);

    /**
     * get targeted paragraph
     *
     * @param token       token
     * @param paragraphId paragraph id
     * @return para info
     */
    public ParaInfo getPara(String token, int paragraphId);

    public ParaFormatInfo getParaFormat(String token, int paragraph_id);

    public List<FontInfo> getFontFormat(String token, int paragraph_id);

    public void tableParaParser(XWPFDocument doc, XWPFParagraph para, int paragraph_id, int table_id, String token, boolean isTableRowEnd);

//    public List<>
}
