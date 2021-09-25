package com.example.datascience.controller;

import com.example.datascience.pojo.Response;
import com.example.datascience.pojo.font.FontFormat;
import com.example.datascience.pojo.para.ParaFormat;
import com.example.datascience.pojo.vo.FontInfo;
import com.example.datascience.pojo.vo.ParagraphInfo;
import com.example.datascience.service.ParaParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ray
 */
@RestController
@RequestMapping("/word_parser")
public class ParaParserController {
    private final ParaParserService paraParserService;

    @Autowired
    ParaParserController(ParaParserService paraParserService) {
        this.paraParserService = paraParserService;
    }

    @GetMapping(value = "{token}/all_paragraphs")
    public Response<List<ParagraphInfo>> getAllParas(@PathVariable String token) {
        List<ParagraphInfo> paraInfos = paraParserService.getAllParas(token);
        return new Response<>(paraInfos);
    }

    @GetMapping(value = "{token}/paragraph/{paragraph_id}")
    public Response<List<ParagraphInfo>> getPara(@PathVariable String token, @PathVariable Integer paragraph_id) {
        List<ParagraphInfo> ParaInfo = paraParserService.getPara(token, paragraph_id);
        return new Response<>(ParaInfo);
    }

    @GetMapping(value = "{token}/paragraph/{paragraph_id}/paragraph_stype")
    public Response<List<ParagraphInfo>> getParaFormat(@PathVariable String token, @PathVariable Integer paragraph_id) {
        List<ParagraphInfo> paraFormat = paraParserService.getParaFormat(token, paragraph_id);
        return new Response<>(paraFormat);
    }

    @GetMapping(value = "{token}/paragraph/{paragraph_id}/font_stype")
    public Response<List<FontInfo>> getFontFormat(@PathVariable String token, @PathVariable Integer paragraph_id) {
        List<FontInfo> fontFormat = paraParserService.getFontFormat(token, paragraph_id);
        return new Response<>(fontFormat);
    }

}
