package com.example.datascience.controller;

import com.example.datascience.pojo.CommonInfo;
import com.example.datascience.pojo.Response;
import com.example.datascience.pojo.vo.WordInfo;
import com.example.datascience.service.WordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
public class WordController {

    @Autowired
    private WordService wordService;

    @ApiOperation("1.文档载入功能")
    @PostMapping("/load_file")
    public Response<WordInfo> loadFile(@RequestParam("file") MultipartFile file, @RequestParam("fileName") String fileName) {
//        TODO: 实现
        // 1. 上传文件为空
        if (file.isEmpty()) {
            return Response.error("上传文件为空");
        }

        // 2.
        try {
            byte[] bytes = file.getBytes();
            return wordService.loadFile(fileName, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();
        return new Response<>(new WordInfo("测试哈"));
    }

    @ApiOperation("12.删除文档(释放资源)")
    @DeleteMapping("/word_parser/{token}")
    public Response<CommonInfo> deleteWord(@PathVariable String token) {
//        TODO: 实现
        return new Response<>(new CommonInfo(true));
    }
}
