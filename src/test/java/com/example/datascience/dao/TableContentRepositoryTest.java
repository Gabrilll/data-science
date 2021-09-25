package com.example.datascience.dao;

import com.example.datascience.dao.table.TableContentRepository;
import com.example.datascience.pojo.po.table.TableContent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TableContentRepositoryTest {
    private TableContentRepository tableContentRepository;

    @Autowired
    TableContentRepositoryTest(TableContentRepository tableContentRepository){
        this.tableContentRepository=tableContentRepository;
    }

    @Test
    public void testFindTableContentByTokenAndTableId(){
        List<TableContent> tableContents= tableContentRepository.findTableContentsByTokenAndTableId("样例",16);
        String res="";
    }
}
