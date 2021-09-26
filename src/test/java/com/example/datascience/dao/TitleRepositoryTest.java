package com.example.datascience.dao;

import com.example.datascience.dao.title.TitleRepository;
import com.example.datascience.pojo.po.title.Title;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TitleRepositoryTest {
    private TitleRepository titleRepository;

    @Autowired
    TitleRepositoryTest(TitleRepository titleRepository){
        this.titleRepository=titleRepository;
    }

    @Test
    public void testFindById(){
        Integer id=1;
        String token="样例";
        Title title=titleRepository.findByIdAndWordToken(id,token);
        String res="";
    }
}
