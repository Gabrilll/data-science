package com.example.datascience.serviceImpl;

import com.example.datascience.pojo.pic.PicInfo;
import com.example.datascience.service.PicParserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gabri
 */
@Service
public class PicParserServiceImpl implements PicParserService {

    @Override
    public List<PicInfo> getAllPics(String token) {
        return null;
    }

    @Override
    public List<PicInfo> getAllPics(String token,int paragraphId){
        return null;
    }
}
