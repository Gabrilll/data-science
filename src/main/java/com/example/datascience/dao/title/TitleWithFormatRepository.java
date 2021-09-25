package com.example.datascience.dao.title;

import com.example.datascience.pojo.po.title.TitleKey;
import com.example.datascience.pojo.po.title.TitleWithFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleWithFormatRepository extends JpaRepository<TitleWithFormat, TitleKey> {
    List<TitleWithFormat> findAllByWordToken(String wordToken);
}
