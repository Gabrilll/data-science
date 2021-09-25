package com.example.datascience.serviceImpl;

import com.example.datascience.dao.PicRepository;
import com.example.datascience.pojo.po.picture.Picture;
import com.example.datascience.pojo.vo.PicInfo;
import com.example.datascience.service.PicParserService;
import com.example.datascience.utils.XWPFUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gabri
 */
@Service
@Slf4j
public class PicParserServiceImpl implements PicParserService {
    private final PicRepository picRepository;

    @Autowired
    PicParserServiceImpl(PicRepository picRepository) {
        this.picRepository = picRepository;
    }

    @Override
    public List<PicInfo> getAllPics(String token) {
        ArrayList<PicInfo> picInfos = new ArrayList<>();
        List<Picture> pictures = picRepository.findPicturesByToken(token);
        for (Picture picture : pictures) {
            picInfos.add(new PicInfo(picture));
        }
        return picInfos;
    }

    @Override
    public List<PicInfo> getAllPics(String token, int paragraphId) {
        return null;
    }

    @Override
    public void parseAllPics(XWPFDocument xwpfDocument, String token) {
        List<XWPFParagraph> paragraphs = xwpfDocument.getParagraphs();
        for (int i = 0; i < paragraphs.size(); i++) {
            XWPFParagraph paragraph = paragraphs.get(i);
            List<String> imageBundleList = XWPFUtils.readImageInParagraph(paragraph);
            for (String picId : imageBundleList) {
                XWPFPictureData pictureData = xwpfDocument.getPictureDataByID(picId);
                Picture picture = new Picture();
                picture.setId(picId);
                picture.setToken(token);
                if (i > 0) {
                    XWPFParagraph before = paragraphs.get(i - 1);
                    picture.setParagraphIdBefore(xwpfDocument.getPosOfParagraph(before));
                    picture.setTextBefore(before.getText());
                }

                if (i < paragraphs.size() - 1) {
                    XWPFParagraph after = paragraphs.get(i + 1);
                    picture.setParagraphIdAfter(xwpfDocument.getPosOfParagraph(after));
                    picture.setTextAfter(after.getText());
                }

                picture.setSuggestFileExtension(pictureData.suggestFileExtension());
                picture.setBase64Content(pictureData.getData());
                picture.setFileName(pictureData.getFileName());

                try {
                    //将b作为输入流；
                    ByteArrayInputStream in = new ByteArrayInputStream(pictureData.getData());

                    //将in作为输入流，读取图片存
                    BufferedImage sourceImg = ImageIO.read(in);
                    double width = sourceImg.getWidth();

                    double height = sourceImg.getHeight();

                    picture.setHeight(height);
                    picture.setWidth(width);
                } catch (Exception e) {
                    log.error("read img error");
                }
                picRepository.save(picture);

            }
        }
    }

}
