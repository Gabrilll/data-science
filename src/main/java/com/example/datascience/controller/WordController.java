package com.example.datascience.controller;

import com.example.datascience.pojo.CommonInfo;
import com.example.datascience.pojo.Response;
import com.example.datascience.pojo.vo.WordInfo;
import com.example.datascience.service.WordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        Response<WordInfo> response;

        // 2.
        try {
            byte[] bytes = file.getBytes();
            response = wordService.loadFile(fileName, bytes);
            if (response.getData().getToken() == null) {
                return Response.error("getToken fail");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Response.error(e.getMessage());
        }

        String token = response.getData().getToken();

        try {
            response = wordService.parseFile(token, file.getInputStream());
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            return Response.error(e.getMessage());
        }

//        try {
//            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    @ApiOperation("12.删除文档(释放资源)")
    @DeleteMapping("/word_parser/{token}")
    public Response<CommonInfo> deleteWord(@PathVariable String token) {
//        TODO: 实现
        return Response.success(new CommonInfo(true));
    }
}
