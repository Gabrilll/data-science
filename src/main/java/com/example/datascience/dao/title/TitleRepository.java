package com.example.datascience.dao.title;

import com.example.datascience.pojo.po.title.Title;
import com.example.datascience.pojo.po.title.TitleKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleRepository extends JpaRepository<Title, TitleKey> {
    Title findById(Integer id);

    List<Title> findAllByWordToken(String wordToken);
}
