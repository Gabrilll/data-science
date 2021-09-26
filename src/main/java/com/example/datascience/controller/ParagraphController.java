package com.example.datascience.controller;

import com.example.datascience.pojo.Response;
import com.example.datascience.pojo.vo.ParagraphInfo;
import com.example.datascience.service.ParagraphService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/word_parser")
public class ParagraphController {

    @Autowired
    private ParagraphService paragraphService;

    @ApiOperation("9.根据文档 token、段落 id 获取所有段落信息")
    @GetMapping("/{token}/title/{paragraph_id}/all_paragraphs")
    public Response<List<ParagraphInfo>> getAllParagraphs(@PathVariable("token") String token, @PathVariable("paragraph_id") Integer paragraphId) {
        try {
            List<ParagraphInfo> data = paragraphService.getAllParagraphsInSameTitle(token, paragraphId);
            return Response.success(data);
        } catch(Exception e) {
            e.printStackTrace();
            return Response.error(e.getMessage());
        }
    }
}
