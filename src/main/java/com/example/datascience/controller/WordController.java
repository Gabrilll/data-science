package com.example.datascience.controller;

import com.example.datascience.pojo.CommonInfo;
import com.example.datascience.pojo.Response;
import com.example.datascience.pojo.vo.WordInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {

    @ApiOperation("1.文档载入功能")
    @PostMapping("/load_file")
    public Response<WordInfo> loadFile() {
//        TODO: 实现
        return new Response<>(new WordInfo("测试哈"));
    }

    @ApiOperation("12.删除文档(释放资源)")
    @DeleteMapping("/word_parser/{token}")
    public Response<CommonInfo> deleteWord(@PathVariable String token) {
//        TODO: 实现
        return new Response<>(new CommonInfo(true));
    }
}
