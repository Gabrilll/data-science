package com.example.datascience.serviceImpl;

import com.example.datascience.dao.WordRepository;
import com.example.datascience.pojo.Response;
import com.example.datascience.pojo.po.Word;
import com.example.datascience.pojo.vo.WordInfo;
import com.example.datascience.service.ParaParserService;
import com.example.datascience.service.PicParserService;
import com.example.datascience.service.TableParserService;
import com.example.datascience.service.WordService;
import com.example.datascience.utils.SHA256Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
@Slf4j
public class WordServiceImpl implements WordService {

    @Autowired
    private ParaParserService paraParserService;
    @Autowired
    private PicParserService picParserService;
    @Autowired
    private TableParserService tableParserService;
    @Autowired
    private WordRepository wordRepository;

    @Override
    public Response<WordInfo> loadFile(String fileName, byte[] bytes) {
        System.out.println("filename: " + fileName);

        // 1. create token
        String token = SHA256Utils.getToken(bytes);
        if (token == null) {
            return Response.error("getToken fail");
        }

        // 2. save word
//        new XWPFWordExtractor()
        Word word = new Word(token, "abcde");
        try {
            wordRepository.save(word);
            return Response.success(new WordInfo(token));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(e.getMessage());
        }
    }

    @Override
    public Response<WordInfo> parseFile(String token, InputStream inputStream) {
        System.out.println("do parse here");

        XWPFDocument document;
        try {
            document = new XWPFDocument(inputStream);
            paraParserService.ParasParserInDocx(document, token);
            tableParserService.parseAllTables(document, token);
            picParserService.parseAllPics(document, token);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Response.success(new WordInfo(token));
    }
}
