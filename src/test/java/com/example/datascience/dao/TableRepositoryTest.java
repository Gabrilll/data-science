package com.example.datascience.dao;

import com.example.datascience.dao.table.TableRepository;
import com.example.datascience.pojo.po.table.Table;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TableRepositoryTest {
    private TableRepository tableRepository;

    @Autowired
    TableRepositoryTest(TableRepository tableRepository){
        this.tableRepository=tableRepository;
    }

    @Test
    public void testFindTablesByTokenAndIdBetween(){
        String token="样例";
        Integer startId=21;
        Integer endId=29;
        List<Table> tables=tableRepository.findTablesByTokenAndIdBetween(token,startId,endId);
        String res="";
    }
}
