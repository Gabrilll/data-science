package com.example.datascience.serviceImpl;

import com.example.datascience.pojo.CommonInfo;
import com.example.datascience.pojo.Response;
import com.example.datascience.pojo.vo.WordInfo;
import com.example.datascience.service.WordService;
import com.example.datascience.utils.SHA256Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WordServiceImpl implements WordService {

    @Override
    public Response<WordInfo> loadFile(String fileName, byte[] bytes) {
        System.out.println("filename" + fileName);
        String token = SHA256Utils.getToken(bytes);
        if (token == null) {
            return Response.error();
        } else {
            return Response.success(new WordInfo(token));
        }
    }
}
