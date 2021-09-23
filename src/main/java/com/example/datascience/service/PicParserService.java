package com.example.datascience.service;

import com.example.datascience.pojo.vo.PicInfo;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.util.List;

/**
 * @author Gabri
 */
public interface PicParserService {


    /**
     * get all pics
     *
     * @param token token
     * @return all pic info
     */
    public List<PicInfo> getAllPics(String token);

    /**
     * get all pics of a paragraph
     * @param token token
     * @param paragraphId paragraph id
     * @return all pic info
     */
    public List<PicInfo> getAllPics(String token,int paragraphId);

//    public List<>
}
