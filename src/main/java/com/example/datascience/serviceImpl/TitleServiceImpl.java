package com.example.datascience.serviceImpl;

import com.example.datascience.dao.title.TitleRepository;
import com.example.datascience.dao.title.TitleWithFormatRepository;
import com.example.datascience.pojo.po.title.TitleKey;
import com.example.datascience.pojo.po.title.TitleWithFormat;
import com.example.datascience.pojo.vo.TitleInfo;
import com.example.datascience.service.TitleService;
import com.example.datascience.utils.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TitleServiceImpl implements TitleService {

    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private TitleWithFormatRepository titleWithFormatRepository;

    @Override
    public List<TitleInfo> getTitles(String token) {
        List<TitleInfo> titleInfoList = new ArrayList<>();

        List<TitleWithFormat> list = titleWithFormatRepository.findAllByWordToken(token);

        LogUtils.printList("[getTitles] list <<<<<<<<<<", list);

        return titleInfoList;
    }
}
