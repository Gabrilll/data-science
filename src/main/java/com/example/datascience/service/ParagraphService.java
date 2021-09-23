package com.example.datascience.service;

import com.example.datascience.pojo.vo.ParagraphInfo;

import java.util.List;

public interface ParagraphService {
    List<ParagraphInfo> getAllParagraphs(String token, Integer paragraphId);
}
