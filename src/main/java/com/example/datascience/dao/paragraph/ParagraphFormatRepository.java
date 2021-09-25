package com.example.datascience.dao.paragraph;

import com.example.datascience.pojo.po.paragraph.ParagraphFormatKey;
import com.example.datascience.pojo.po.paragraph.ParagraphFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ray
 */
@Repository
public interface ParagraphFormatRepository extends JpaRepository<ParagraphFormat, ParagraphFormatKey> {
}
