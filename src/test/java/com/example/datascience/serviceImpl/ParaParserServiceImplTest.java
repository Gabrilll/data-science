package com.example.datascience.serviceImpl;

import com.example.datascience.pojo.vo.FontInfo;
import com.example.datascience.pojo.vo.ParaFormatInfo;
import com.example.datascience.pojo.vo.ParaInfo;
import com.example.datascience.service.ParaParserService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@SpringBootTest
class ParaParserServiceImplTest {
    private ParaParserService paraParserService;

    @Autowired
    ParaParserServiceImplTest(ParaParserServiceImpl paraParserService) {
        this.paraParserService = paraParserService;
    }


    @Test
    public void testParasParserInDocx() throws IOException {
        File file = new File("C:/Users/Ray/Desktop/test.docx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XWPFDocument document=new XWPFDocument(fileInputStream);
        paraParserService.ParasParserInDocx(document, "12345");
    }

    @Test
    void getAllParas() {
        List<ParaInfo> paraInfo = paraParserService.getAllParas("样例");
    }

    @Test
    void getPara() {
        ParaInfo paraInfo = paraParserService.getPara("样例", 1);
    }

    @Test
    void getParaFormat() {
        ParaFormatInfo paraFormatInfo = paraParserService.getParaFormat("样例", 1);
    }

    @Test
    void getFontFormat() {
        List<FontInfo> fontInfo = paraParserService.getFontFormat("12345", 1);
    }
}