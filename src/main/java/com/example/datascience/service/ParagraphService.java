package com.example.datascience.service;

import com.example.datascience.pojo.vo.ParagraphInfo;

import java.util.List;

public interface ParagraphService {
    List<ParagraphInfo> getAllParagraphsInSameTitle(String token, Integer paragraphId);
}
