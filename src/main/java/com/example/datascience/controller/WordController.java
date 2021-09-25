package com.example.datascience.controller;

import com.example.datascience.constant.FileExt;
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

        InputStream inputStream;
        FileExt ext;
        // 2. 文件类型判断 & 转换
        try {
            ext = wordService.distinguishRealExtension(file.getInputStream());
            System.out.println("++++++++++ file extension " + ext);
            switch (ext) {
                case DOC:
                    // doc => docx
                    inputStream = wordService.convertDocToDocx(file.getInputStream());
                    break;
                case PDF:
                    // pdf => docx
                    inputStream = wordService.convertPDFToDocx(file.getInputStream());
                    break;
                case DOCX:
                    inputStream = file.getInputStream();
                    break;
                case UN_SUPPORT:
                    return Response.error("不支持文件类型");
                default:
                    return Response.error("文件类型解析失败");
            }
            if (inputStream == null) {
                return Response.error("文件类型转换失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Response.error("文件类型解析失败");
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(e.getMessage());
        }

        // 3. 生成 token & 存储原始文件
        String token;
        try {
            token = wordService.loadFile(fileName, ext, file.getBytes());
            if (token == null) {
                return Response.error("token 生成失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Response.error(e.getMessage());
        }

        System.out.println("++++++++++ generated token " + token);

        // 4. 解析文件内容
        return wordService.parseFile(token, inputStream);
    }

    @ApiOperation("12.删除文档(释放资源)")
    @DeleteMapping("/word_parser/{token}")
    public Response<CommonInfo> deleteWord(@PathVariable String token) {
//        TODO: 实现
        return Response.success(new CommonInfo(true));
    }
}
