package com.example.datascience.dao.title;

import com.example.datascience.pojo.po.title.TitleKey;
import com.example.datascience.pojo.po.title.TitleWithFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleWithFormatRepository extends JpaRepository<TitleWithFormat, TitleKey> {
    @Query("select * from title t, paragraph_format pf where t.wordToken=:token and t.")
    List<TitleWithFormat> findAllByToken(String token);
}
