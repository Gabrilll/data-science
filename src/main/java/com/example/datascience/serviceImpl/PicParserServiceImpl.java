package com.example.datascience.serviceImpl;

import com.example.datascience.pojo.po.Picture;
import com.example.datascience.pojo.vo.PicInfo;
import com.example.datascience.service.PicParserService;
import com.microsoft.schemas.vml.CTShape;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gabri
 */
@Service
@Slf4j
public class PicParserServiceImpl implements PicParserService {

    @Override
    public List<PicInfo> getAllPics(String token) {
        return null;
    }

    @Override
    public List<PicInfo> getAllPics(String token,int paragraphId){
        return null;
    }
}
