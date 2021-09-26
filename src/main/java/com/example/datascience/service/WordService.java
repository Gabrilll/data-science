package com.example.datascience.service;

import com.example.datascience.constant.FileExt;
import com.example.datascience.pojo.CommonInfo;
import com.example.datascience.pojo.Response;
import com.example.datascience.pojo.vo.WordInfo;

import java.io.InputStream;

public interface WordService {
    String loadFile(String fileName, FileExt ext, byte[] bytes);

    Response<WordInfo> parseFile(String token, InputStream inputStream);

    FileExt distinguishRealExtension(InputStream inputStream);

    InputStream convertDocToDocx(InputStream inputStream);

    InputStream convertPDFToDocx(InputStream inputStream);

    Response<CommonInfo> deleteWord(String token);
}
