package com.example.datascience.dao;

import com.example.datascience.pojo.po.Font.FontFormatKey;
import com.example.datascience.pojo.po.Font.FontFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @className: FontFormatPepository
 * @Description: TODO
 * @author: Ray
 * @date: 2021/9/24 19:27
 */
@Repository
public interface FontFormatRepository extends JpaRepository<FontFormat, FontFormatKey> {
    List<FontFormat> findAllByTokenAndParagraphId(String token, Integer paragraphId);

    void deleteByToken(String token);
}
