package com.example.datascience.controller;

import com.example.datascience.pojo.Response;
import com.example.datascience.pojo.vo.TableInfo;
import com.example.datascience.service.PicParserService;
import com.example.datascience.service.TableParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Gabri
 */
@RestController
@RequestMapping("/word_parser")
public class TableParserController {
    private final TableParserService tableParserService;


    @Autowired
    TableParserController(TableParserService tableParserService, PicParserService picParserService) {
        this.tableParserService = tableParserService;
    }


    @GetMapping(value = "/{token}/all_tables")
    public Response<List<TableInfo>> getAllTables(@PathVariable String token) {
        List<TableInfo> tableInfos = tableParserService.getAllTables(token);
        return new Response<>(tableInfos);
    }

    @GetMapping(value = "/{token}/title/{paragraph_id}/all_tables")
    public Response<List<TableInfo>> getAllTables(@PathVariable String token, @PathVariable Integer paragraph_id) {
        List<TableInfo> tableInfos = tableParserService.getAllTables(token, paragraph_id);
        return new Response<>(tableInfos);
    }
}
