package com.example.datascience.serviceImpl;

import com.example.datascience.pojo.vo.ParagraphInfo;
import com.example.datascience.service.ParagraphService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ParagraphServiceImpl implements ParagraphService {

    @Override
    public List<ParagraphInfo> getAllParagraphs(String token, Integer paragraphId) {
        List<ParagraphInfo> paragraphInfoList = new ArrayList<>();
        return paragraphInfoList;
    }
}
