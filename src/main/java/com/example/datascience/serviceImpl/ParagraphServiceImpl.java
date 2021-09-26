package com.example.datascience.serviceImpl;

import com.example.datascience.dao.FontFormatRepository;
import com.example.datascience.dao.paragraph.ParagraphFormatRepository;
import com.example.datascience.dao.paragraph.ParagraphRepository;
import com.example.datascience.pojo.po.Font.FontFormat;
import com.example.datascience.pojo.po.paragraph.Paragraph;
import com.example.datascience.pojo.po.paragraph.ParagraphFormat;
import com.example.datascience.pojo.po.paragraph.ParagraphKey;
import com.example.datascience.pojo.vo.ParagraphInfo;
import com.example.datascience.service.ParagraphService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ParagraphServiceImpl implements ParagraphService {

    @Autowired
    private ParagraphRepository paragraphRepository;
    @Autowired
    private ParagraphFormatRepository paragraphFormatRepository;
    @Autowired
    private FontFormatRepository fontFormatRepository;

    @Override
    public List<ParagraphInfo> getAllParagraphsInSameTitle(String token, Integer paragraphId) {
        Optional<Paragraph> optionalParagraph = paragraphRepository.findById(new ParagraphKey(paragraphId, token));
        if (!optionalParagraph.isPresent()) {
            System.out.println("XXXXXXXXXX no paragraph match (" + paragraphId + ", " + token + ")");
            return new ArrayList<>();
        }

        ParagraphFormat targetFormat = paragraphFormatRepository.findByIdAndToken(paragraphId, token);
        if (targetFormat == null) {
            return new ArrayList<>();
        }

        String lvl = targetFormat.getLvl();

        // 同 token 同 lvl 的 ParagraphFormat[]
        List<ParagraphFormat> formatList = paragraphFormatRepository.findAllByTokenAndLvl(token, lvl);

        // 对应 Paragraph[]
        List<ParagraphKey> paragraphKeyList = formatList.stream().map(format -> new ParagraphKey(format.getId(), format.getToken())).collect(Collectors.toList());
        List<Paragraph> paragraphList = paragraphRepository.findAllById(paragraphKeyList);

        Optional<List<FontFormat>> optionalFontFormats = paragraphKeyList.stream().map(paragraphKey -> fontFormatRepository.findAllByTokenAndParagraphId(paragraphKey.getWordToken(), paragraphKey.getId())).reduce(new BinaryOperator<List<FontFormat>>() {
            @Override
            public List<FontFormat> apply(List<FontFormat> fontFormats, List<FontFormat> fontFormats2) {
                fontFormats.addAll(fontFormats2);
                return fontFormats;
            }
        });

        // 对应 FontFormat[]
        List<FontFormat> fontFormatList = optionalFontFormats.isPresent() ? optionalFontFormats.get() : new ArrayList<>();

        return mergeParagraphInfo(paragraphList, formatList, fontFormatList);
    }

    private List<ParagraphInfo> mergeParagraphInfo(List<Paragraph> paragraphList, List<ParagraphFormat> formatList, List<FontFormat> fontFormatList) {
        List<ParagraphInfo> paragraphInfoList = paragraphList.stream().map(paragraph -> {
            Optional<ParagraphFormat> optionalParagraphFormat = formatList.stream().filter(format -> format.getId().equals(paragraph.getId()) && format.getToken().equals(paragraph.getWordToken())).findFirst();
            Optional<FontFormat> optionalFontFormat = fontFormatList.stream().filter(format -> format.getParagraphId().equals(paragraph.getId()) && format.getToken().equals(paragraph.getWordToken())).findFirst();
            ParagraphInfo info = new ParagraphInfo();
            info.merge(paragraph);
            if (optionalParagraphFormat.isPresent()) {
                info.merge(optionalParagraphFormat.get());
            }
            if (optionalFontFormat.isPresent()) {
                info.merge(optionalFontFormat.get());
            }
            return info;
        }).collect(Collectors.toList());
        return paragraphInfoList;
    }
}
