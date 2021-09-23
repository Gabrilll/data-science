package com.example.datascience.controller;

import com.example.datascience.pojo.Response;
import com.example.datascience.pojo.vo.PicInfo;
import com.example.datascience.service.PicParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Gabri
 */
@RestController
@RequestMapping("/word_parser")
public class PicParserController {
    private final PicParserService picParserService;

    @Autowired
    PicParserController(PicParserService picParserService) {
        this.picParserService = picParserService;
    }

    @GetMapping(value = "/{token}/all_pics")
    public Response<List<PicInfo>> getAllPics(@PathVariable String token) {
        List<PicInfo> picInfos = picParserService.getAllPics(token);
        return new Response<>(picInfos);

    }

    @GetMapping(value = "/{token}/title/{paragraph_id}/all_pics")
    public Response<List<PicInfo>> getAllPics(@PathVariable String token, @PathVariable Integer paragraph_id) {
        List<PicInfo> picInfos = picParserService.getAllPics(token, paragraph_id);
        return new Response<>(picInfos);
    }
}
