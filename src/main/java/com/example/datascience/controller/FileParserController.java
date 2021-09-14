package com.example.datascience.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gabri
 */
@RestController
public class FileParserController {
    @GetMapping(value = "/test")
    public String test(){
        return "test";
    }
}
