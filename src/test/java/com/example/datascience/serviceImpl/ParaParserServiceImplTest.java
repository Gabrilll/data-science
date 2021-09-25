package com.example.datascience.serviceImpl;

import com.example.datascience.service.ParaParserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
//        XWPFDocument document=new XWPFDocument(fileInputStream);
        paraParserService.ParasParserInDocx(fileInputStream, "12345");
    }
}