package com.example.datascience.dao;

import com.example.datascience.pojo.po.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParagraphRepository extends JpaRepository<Paragraph, Integer> {
}
