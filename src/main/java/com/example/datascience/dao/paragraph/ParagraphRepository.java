package com.example.datascience.dao.paragraph;

import com.example.datascience.pojo.po.paragraph.Paragraph;
import com.example.datascience.pojo.po.paragraph.ParagraphKey;
import jdk.internal.org.objectweb.asm.tree.InnerClassNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParagraphRepository extends JpaRepository<Paragraph, ParagraphKey> {
    @Query("select i from Paragraph i where i.wordToken=:token")
    List<Paragraph> findParasByToken(@Param("token") String token);

    @Query("select i from Paragraph i where i.wordToken=:token and i.id=:paragraphId")
    Paragraph findParaByTokenId(@Param("token") String token, @Param("paragraphId") Integer paragraphId);
}
