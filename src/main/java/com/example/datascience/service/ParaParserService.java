package com.example.datascience.service;

import com.example.datascience.pojo.font.FontFormat;
import com.example.datascience.pojo.para.ParaFormat;
import com.example.datascience.pojo.para.ParaInfo;

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
     * @param fileInputStream input
     * @return all para info
     */
    List<ParaInfo> getAllParasInDocx(FileInputStream fileInputStream, String token);

    /**
     * get all paragraphs in doc
     *
     * @param fileInputStream input
     * @return all para info
     */
    List<ParaInfo> getAllParasInDoc(FileInputStream fileInputStream, String token);

    /**
     * get targeted paragraph
     * @param token token
     * @param paragraphId paragraph id
     * @return para info
     */
    public List<ParaInfo> getPara(String token, int paragraphId);

    public List<ParaFormat> getParaFormat(String token, int paragraph_id);

    public List<FontFormat> getFontFormat(String token, int paragraph_id);

//    public List<>
}
