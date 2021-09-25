package com.example.datascience.serviceImpl;

import com.example.datascience.service.PicParserService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SpringBootTest
public class PicParseServiceImplTest {
    private final PicParserService picParserService;

    @Autowired
    PicParseServiceImplTest (PicParserServiceImpl picParserService){
        this.picParserService=picParserService;
    }

    @Test
    public void testParseAllParagraphs() throws IOException {
        File file = new File("C:/Users/Gabri/Desktop/test.docx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XWPFDocument document=new XWPFDocument(fileInputStream);
        picParserService.parseAllPics(document,"样例");
    }

}
