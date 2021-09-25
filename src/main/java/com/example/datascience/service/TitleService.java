package com.example.datascience.service;

import com.example.datascience.pojo.vo.TitleInfo;

import java.util.List;

public interface TitleService {
    List<TitleInfo> getTitles(String token);

    public Integer getEndParagraphId(Integer id);
}
