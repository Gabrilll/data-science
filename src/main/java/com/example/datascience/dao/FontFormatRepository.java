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
    @Query("select i from font_format i where i.token=:token and i.paragraph_id=:paragraph_id")
    List<FontFormat> findFontFormatsByKey(@Param("token") String token, @Param("paragraph_id") int paragraph_id);
}
