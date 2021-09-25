package com.example.datascience.serviceImpl;

import com.example.datascience.dao.TitleRepository;
import com.example.datascience.pojo.po.title.Title;
import com.example.datascience.pojo.vo.TitleInfo;
import com.example.datascience.service.TitleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TitleServiceImpl implements TitleService {

    private TitleRepository titleRepository;

    @Autowired
    TitleServiceImpl(TitleRepository titleRepository){
        this.titleRepository=titleRepository;
    }

    @Override
    public List<TitleInfo> getTitles(String token) {
        List<TitleInfo> titleInfoList = new ArrayList<>();
        return titleInfoList;
    }

    @Override
    public Integer getEndParagraphId(Integer id){
        Title title=titleRepository.findById(id);
        return title.getParagraph_end();
    }
}
