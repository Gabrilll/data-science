package com.example.datascience.dao;

import com.example.datascience.pojo.po.picture.PicKey;
import com.example.datascience.pojo.po.picture.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Gabri
 */
public interface PicRepository extends JpaRepository<Picture, PicKey> {
    @Query("select i from image i where i.token=:token")
    List<Picture> findPicturesByToken(@Param("token") String token);
}
