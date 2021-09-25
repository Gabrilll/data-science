package com.example.datascience.service;

import com.example.datascience.pojo.Response;
import com.example.datascience.pojo.vo.WordInfo;

import java.io.InputStream;

public interface WordService {
    Response<WordInfo> loadFile(String fileName, byte[] bytes);

    Response<WordInfo> parseFile(String token, InputStream inputStream);

}
