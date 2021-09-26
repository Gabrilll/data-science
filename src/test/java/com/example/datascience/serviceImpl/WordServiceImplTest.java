package com.example.datascience.serviceImpl;

import com.example.datascience.service.WordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class WordServiceImplTest {
    private WordService wordService;

    @Autowired
    WordServiceImplTest(WordService wordService) {
        this.wordService = wordService;
    }

    @Test
    void loadFile() {

    }
}