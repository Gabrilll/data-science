package com.example.datascience.dao.paragraph;

import com.example.datascience.pojo.po.paragraph.ParagraphFormatKey;
import com.example.datascience.pojo.po.paragraph.ParagraphFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ray
 */
@Repository
public interface ParagraphFormatRepository extends JpaRepository<ParagraphFormat, ParagraphFormatKey> {
    @Query("select i from paragraph_format i where i.id=:paragraph_id and i.token=:token")
    ParagraphFormat findParaFormatByKey(@Param("paragraph_id") Integer paragraph_id, @Param("token") String token);

    ParagraphFormat findByIdAndToken(Integer id, String token);

    List<ParagraphFormat> findAllByTokenAndLvl(String token, String lvl);
}
