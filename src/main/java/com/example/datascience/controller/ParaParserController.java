package com.example.datascience.controller;

import com.example.datascience.pojo.Response;
import com.example.datascience.pojo.font.FontFormat;
import com.example.datascience.pojo.para.ParaFormat;
import com.example.datascience.pojo.para.ParaInfo;
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
    public Response<List<ParaInfo>> getAllParas(@PathVariable String token) {
        List<ParaInfo> paraInfos = paraParserService.getAllParas(token);
        return new Response<>(paraInfos);
    }

    @GetMapping(value = "{token}/paragraph/{paragraph_id}")
    public Response<List<ParaInfo>> getPara(@PathVariable String token, @PathVariable Integer paragraph_id) {
        List<ParaInfo> paraInfo = paraParserService.getPara(token, paragraph_id);
        return new Response<>(paraInfo);
    }

    @GetMapping(value = "{token}/paragraph/{paragraph_id}/paragraph_stype")
    public Response<List<ParaFormat>> getParaFormat(@PathVariable String token, @PathVariable Integer paragraph_id) {
        List<ParaFormat> paraFormat = paraParserService.getParaFormat(token, paragraph_id);
        return new Response<>(paraFormat);
    }

    @GetMapping(value = "{token}/paragraph/{paragraph_id}/font_stype")
    public Response<List<FontFormat>> getFontFormat(@PathVariable String token, @PathVariable Integer paragraph_id) {
        List<FontFormat> fontFormat = paraParserService.getFontFormat(token, paragraph_id);
        return new Response<>(fontFormat);
    }

}
