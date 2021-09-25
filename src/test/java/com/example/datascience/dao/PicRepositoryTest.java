package com.example.datascience.dao;

import com.example.datascience.pojo.po.picture.Picture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PicRepositoryTest {
    private PicRepository picRepository;

    @Autowired
    PicRepositoryTest(PicRepository picRepository) {
        this.picRepository = picRepository;
    }

    @Test
    public void testFindPicturesByTokenAndIdBetween() {
        String token = "样例";
        Integer startId = 5;
        Integer endId = 8;
        List<Picture> pictures = picRepository.findPicturesByTokenAndIdBetween(token, startId, endId);
    }
}
