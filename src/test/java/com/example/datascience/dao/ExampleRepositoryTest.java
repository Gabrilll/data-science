package com.example.datascience.dao;

import com.example.datascience.pojo.Example;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExampleRepositoryTest {
    @Autowired
    ExampleRepository exampleRepository;

    @Test
    public void testAddTest(){
        Example example=new Example();
        exampleRepository.save(example);
    }
}
