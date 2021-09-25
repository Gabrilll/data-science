package com.example.datascience.dao;

import com.example.datascience.pojo.po.Font.FontFormatKey;
import com.example.datascience.pojo.po.Font.FontFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @className: FontFormatPepository
 * @Description: TODO
 * @author: Ray
 * @date: 2021/9/24 19:27
 */
@Repository
public interface FontFormatRepository extends JpaRepository<FontFormat, FontFormatKey> {
}
