package com.example.datascience.serviceImpl;

import com.example.datascience.pojo.vo.TitleInfo;
import com.example.datascience.service.TitleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TitleServiceImpl implements TitleService {

    @Override
    public List<TitleInfo> getTitles(String token) {
        List<TitleInfo> titleInfoList = new ArrayList<>();
        return titleInfoList;
    }
}
