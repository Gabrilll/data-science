package com.example.datascience.dao;

import com.example.datascience.pojo.po.picture.PicKey;
import com.example.datascience.pojo.po.picture.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Gabri
 */
@Repository
public interface PicRepository extends JpaRepository<Picture, PicKey> {
    /**
     * find pictures by token
     *
     * @param token token
     * @return pictures
     */
    @Query("select i from image i where i.token=:token")
    List<Picture> findPicturesByToken(@Param("token") String token);


    /**
     * find pictures between paragraphs
     *
     * @param token   token
     * @param startId start para id
     * @param endId   end para id
     * @return pictures
     */
    @Query("select i from image i where i.token=:token and i.paragraphIdBefore+1>=:startId and i.paragraphIdAfter-1<:endId")
    List<Picture> findPicturesByTokenAndIdBetween(@Param("token") String token, @Param("startId") Integer startId, @Param("endId") Integer endId);
}
