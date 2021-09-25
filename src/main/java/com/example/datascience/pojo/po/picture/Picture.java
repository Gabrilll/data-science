package com.example.datascience.pojo.po.picture;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * @author Gabri
 */
@Entity(name = "image")
@Data
@IdClass(PicKey.class)
public class Picture implements Serializable {
    @Id
    private String id;

    @Id
    @Column(name = "word_token")
    private String token;

    @Column(name = "paragraph_id_before")
    private Integer paragraphIdBefore;

    @Column(name = "paragraph_id_after")
    private Integer paragraphIdAfter;

    @Column(name="text_before")
    private String textBefore;

    @Column(name = "text_after")
    private String textAfter;

    private Double height;
    private Double width;

    @Column(name = "suggest_file_ext")
    private String suggestFileExtension;

    @Column(name = "base64_content")
    private byte[] base64Content;

    @Column(name = "filename")
    private String fileName;
}
