package com.example.datascience.serviceImpl;

import com.example.datascience.dao.WordRepository;
import com.example.datascience.pojo.Response;
import com.example.datascience.pojo.po.Word;
import com.example.datascience.pojo.vo.WordInfo;
import com.example.datascience.service.WordService;
import com.example.datascience.utils.SHA256Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WordServiceImpl implements WordService {

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
            return Response.error();
        }
    }
}
