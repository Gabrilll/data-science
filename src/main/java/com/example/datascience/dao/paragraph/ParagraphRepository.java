package com.example.datascience.dao.paragraph;

import com.example.datascience.pojo.po.paragraph.Paragraph;
import com.example.datascience.pojo.po.paragraph.ParagraphKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParagraphRepository extends JpaRepository<Paragraph, ParagraphKey> {
}
