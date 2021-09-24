package com.example.datascience.service;

import com.example.datascience.pojo.Response;
import com.example.datascience.pojo.vo.WordInfo;

public interface WordService {
    Response<WordInfo> loadFile(String fileName, byte[] bytes);
}
