package com.example.datascience.serviceImpl;

import com.example.datascience.dao.paragraph.ParagraphFormatRepository;
import com.example.datascience.dao.title.TitleRepository;
import com.example.datascience.pojo.po.paragraph.ParagraphFormat;
import com.example.datascience.pojo.po.paragraph.ParagraphFormatKey;
import com.example.datascience.pojo.po.title.Title;
import com.example.datascience.pojo.vo.TitleInfo;
import com.example.datascience.service.TitleService;
import com.example.datascience.utils.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TitleServiceImpl implements TitleService {

    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private ParagraphFormatRepository paragraphFormatRepository;

    @Override
    public List<TitleInfo> getTitles(String token) {
        List<Title> titleList = titleRepository.findAllByWordToken(token);
        List<ParagraphFormatKey> formatKeyList = titleList.stream().map(title -> new ParagraphFormatKey(title.getId(), title.getWordToken())).collect(Collectors.toList());
        List<ParagraphFormat> formatList = paragraphFormatRepository.findAllById(formatKeyList);

        LogUtils.printList("[getTitles] titleList <<<<<<<<<<", titleList);
        LogUtils.printList("[getTitles] formatKeyList <<<<<<<<<<", formatKeyList);
        LogUtils.printList("[getTitles] formatList <<<<<<<<<<", formatList);

        return mergeTitleInfo(titleList, formatList);
    }

    private List<TitleInfo> mergeTitleInfo(List<Title> titleList, List<ParagraphFormat> formatList) {
        List<TitleInfo> titleInfoList = titleList.stream().map(title -> {
            Optional<ParagraphFormat> optionalFormat = formatList.stream().filter(format -> format.getId().equals(title.getId()) && format.getToken().equals(title.getWordToken())).findFirst();
            if (optionalFormat.isPresent()) {
                return new TitleInfo(title, optionalFormat.get());
            } else {
                return new TitleInfo(title);
            }
        }).collect(Collectors.toList());

        return titleInfoList;
    }

    @Override
    public Integer getEndParagraphId(Integer id,String token) {
        Title title = titleRepository.findByIdAndWordToken(id,token);
        return title.getParagraph_end();
    }
}
