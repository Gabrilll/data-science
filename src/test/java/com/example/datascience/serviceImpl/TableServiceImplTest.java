package com.example.datascience.serviceImpl;

import com.example.datascience.service.TableParserService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SpringBootTest
public class TableServiceImplTest {
    private TableParserService tableParserService;

    @Autowired
    TableServiceImplTest(TableParserServiceImpl tableParserService) {
        this.tableParserService = tableParserService;
    }

    @Test
    public void testParseAllTables() throws IOException {
        File file = new File("C:/Users/Gabri/Desktop/test.docx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XWPFDocument document=new XWPFDocument(fileInputStream);
        tableParserService.parseAllTables(document,"样例");
    }
}
