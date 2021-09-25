package com.example.datascience.dao;

import com.example.datascience.pojo.po.title.Title;
import com.example.datascience.pojo.po.title.titleKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository<Title, titleKey> {

}
