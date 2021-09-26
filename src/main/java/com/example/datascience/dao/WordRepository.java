package com.example.datascience.dao;

import com.example.datascience.pojo.po.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, String> {
    void deleteByToken(String token);
}
