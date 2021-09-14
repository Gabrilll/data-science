package com.example.datascience.dao;

import com.example.datascience.pojo.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExampleRepositoryTest {
    @Autowired
    ExampleRepository exampleRepository;

    @org.junit.jupiter.api.Test
    public void testAddTest(){
        Example example=new Example();
        exampleRepository.save(example);
    }
}
