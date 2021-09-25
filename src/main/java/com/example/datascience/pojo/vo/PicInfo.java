package com.example.datascience.pojo.vo;

import com.example.datascience.pojo.po.picture.Picture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @author Gabri
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PicInfo {
    private String textBefore;
    private String textAfter;
    private Double height;
    private Double width;
    private String suggestFileExtension;
    private String base64Content;
    private String filename;

    public PicInfo(Picture picture){
        this(picture.getTextBefore(),picture.getTextAfter(),picture.getHeight(),picture.getWidth(),picture.getSuggestFileExtension(), Base64.encodeBase64String(picture.getBase64Content()),picture.getFileName());
    }
}
