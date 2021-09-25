package com.example.datascience.controller;

import com.example.datascience.pojo.Response;
import com.example.datascience.pojo.vo.TitleInfo;
import com.example.datascience.service.TitleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/word_parser")
public class TitleController {

    @Autowired
    private TitleService titleService;

    @ApiOperation("5.根据文档 token 获取所有标题")
    @GetMapping("/{token}/all_titles")
    public Response<List<TitleInfo>> getAllTitles(@PathVariable String token) {
        try {
            List<TitleInfo> titles = titleService.getTitles(token);
            return Response.success(titles);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(e.getMessage());
        }
    }
}
