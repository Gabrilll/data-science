package com.example.datascience.serviceImpl;

import com.example.datascience.dao.FontFormatRepository;
import com.example.datascience.dao.title.TitleRepository;
import com.example.datascience.dao.paragraph.ParagraphFormatRepository;
import com.example.datascience.dao.paragraph.ParagraphRepository;
import com.example.datascience.pojo.po.Font.FontFormat;
import com.example.datascience.pojo.po.ParaDocLen;
import com.example.datascience.pojo.po.paragraph.Paragraph;
import com.example.datascience.pojo.po.paragraph.ParagraphFormat;
import com.example.datascience.pojo.po.title.Title;
import com.example.datascience.pojo.vo.FontInfo;
import com.example.datascience.pojo.vo.ParaFormatInfo;
import com.example.datascience.pojo.vo.ParaInfo;
import com.example.datascience.service.ParaParserService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Ray
 */
@Service
@Slf4j
public class ParaParserServiceImpl implements ParaParserService {

    private final ParagraphRepository paragraphRepository;
    private final ParagraphFormatRepository paragraphFormatRepository;
    private final FontFormatRepository fontFormatRepository;
    private final TitleRepository titleRepository;

    @Autowired
    ParaParserServiceImpl(ParagraphRepository paragraphRepository, ParagraphFormatRepository paragraphFormatRepository, FontFormatRepository fontFormatRepository, TitleRepository titleRepository) {
        this.paragraphRepository = paragraphRepository;
        this.paragraphFormatRepository = paragraphFormatRepository;
        this.fontFormatRepository = fontFormatRepository;
        this.titleRepository = titleRepository;
    }
    @Override
    public List<ParaInfo> getAllParas(String token) {
        ArrayList<ParaInfo> allParaInfos = new ArrayList<>();
        List<Paragraph> paras = paragraphRepository.findParasByToken(token);
        for (Paragraph para: paras) {
            allParaInfos.add(new ParaInfo(para));
        }
        return allParaInfos;
    }

    @Override
    public void ParasParserInDocx(XWPFDocument document, String token) {
        try{
            List<XWPFParagraph> paras = document.getParagraphs(); //???????????????????????????
            int len = paras.size();
            int pos = 1;
            ParaDocLen paraLen = new ParaDocLen();
//            paraLen.setLen(len);
//            paraLen.setToken(token);
            boolean isH = false;
            Title title = new Title();
            for (XWPFParagraph para: paras) {
                String titleLvl = getTitleLvl(document, para);//??????????????????
                if("a5".equals(titleLvl)||"HTML".equals(titleLvl)||"".equals(titleLvl)||null==titleLvl){
                    titleLvl = "";
                }
                if(!"".equals(titleLvl)){
                    if (isH) {
                        title.setParagraph_end(pos);
                        titleRepository.save(title);
                    }
                    isH = true;
                    title = new Title();
                    title.setId(pos);
                    title.setWordToken(token);
                    title.setText(para.getText());
                }
                hanlePara(document, para, pos++, 0, token, false, false);
            }
            title.setParagraph_end(pos);
            titleRepository.save(title);
        }
        catch (Exception e){
            log.error("");
        }
    }

    @Override
    public ParaInfo getPara(String token, int paragraphId) {
        return new ParaInfo(paragraphRepository.findParaByTokenId(token, paragraphId));
    }

    @Override
    public ParaFormatInfo getParaFormat(String token, int paragraph_id) {
        return new ParaFormatInfo(paragraphFormatRepository.findParaFormatByKey(paragraph_id, token));
    }

    @Override
    public List<FontInfo> getFontFormat(String token, int paragraph_id) {
        ArrayList<FontInfo> allFontInfos = new ArrayList<>();
        List<FontFormat> fonts = fontFormatRepository.findAllByTokenAndParagraphId(token, paragraph_id);
        for (FontFormat font: fonts) {
            allFontInfos.add(new FontInfo(font));
        }
        return allFontInfos;
    }

    @Override
    public void tableParaParser(XWPFDocument doc, XWPFParagraph para, int paragraph_id,
                                int table_id, String token, boolean isTableRowEnd) {
        hanlePara(doc, para, paragraph_id, table_id, token, isTableRowEnd, true);
    }

    public void hanlePara(XWPFDocument doc, XWPFParagraph para, int paragraph_id, int table_id, String token, boolean isTableRowEnd, boolean isInTable) {
        Paragraph paragraph = new Paragraph();
        ParagraphFormat paragraph_format = new ParagraphFormat();
//        //????????????
//        double ind = -1, ind_left = -1, ind_right = -1, ind_hang = -1;
//        String ind_type = "";
//        if (para.getIndentationHanging() != -1) {//????????????
//            ind_type = "hang";
//            if (para.getIndentationHanging() % 567 == 0) {//?????????????????????
//                ind = para.getIndentationHanging() / 567.0;
//                ind_left = (para.getIndentationLeft() - 567.0 * ind) / 210;
//            } else {//?????????????????????
//                ind = para.getIndentationHanging() / 240;
//                ind_left = (para.getIndentationLeft() - para.getIndentationHanging()) / 210;
//            }
//            ind_right = para.getIndentationRight() / 210.0;
//        } else {//?????????????????????
//            ind_type = "first";
//            if (para.getFirstLineIndent() == -1) {
//                ind_type = "none";
//                ind = 0;
//            } else {
//                ind = para.getFirstLineIndent() % 567.0 == 0 ? para.getFirstLineIndent() / 567.0 : para.getFirstLineIndent() / 240.0;
//            }
//            ind_left = para.getIndentationLeft() / 210;
//            ind_right = para.getIndentationRight() / 210.0;
//        }
        paragraph_format.setToken(token);
        paragraph_format.setId(paragraph_id);
        paragraph_format.setLineSpacing(para.getSpacingBetween());
        paragraph_format.setFirstLineIndent(para.getFirstLineIndent());
        paragraph_format.setIndentFromLeft(para.getIndentFromRight());
        paragraph_format.setIndentFromRight(para.getIndentFromRight());
//        paragraph_format.setFirstLineIndent(ind_hang);
//        paragraph_format.setIndentFromLeft(ind_left);
//        paragraph_format.setIndentFromRight(ind_right);
//        paragraph_format.setLvl(para.getStyleID() + "");
        paragraph_format.setLvl(getTitleLvl(doc, para));
        paragraphFormatRepository.save(paragraph_format);
        String lvlText = para.getNumLevelText() == null ? para.getText(): para.getNumLevelText() + ": " + para.getText();
        paragraph.setText(lvlText);
        paragraph.setId(paragraph_id);
        paragraph.setWordToken(token);
        paragraph.setInTable(isInTable);
        if(isInTable) {
            paragraph.setTableId(table_id);
            paragraph.setTableRowEnd(isTableRowEnd);
        }
        else {
            paragraph.setTableId(-1);
            paragraph.setTableRowEnd(false);
        }
        paragraphRepository.save(paragraph);

//        titile.put("Alignment", para.getAlignment().toString());
//        titile.put("SpacingBetween", para.getSpacingBetween() + "");//??????
//        titile.put("SpacingBeforeLines", para.getSpacingBeforeLines() + "");//??????
//        titile.put("SpacingAfterLines", para.getSpacingAfterLines() + "");//??????
//        titile.put("NumLevelText", para.getNumLevelText());//??????????????????
//        titile.put("getNumIlvl", para.getNumIlvl() + "");//????????????
//        titile.put("indentFromRight", String.valueOf(ind_right));//????????????
//        titile.put("firstLineIndent", String.valueOf(ind_hang));//???????????????

        List<XWPFRun> runsLists = para.getRuns();//????????????????????????
        //run?????????????????????????????????
        int cnt = 1;
        for (XWPFRun run : runsLists) {
            FontFormat font_format = new FontFormat();
            font_format.setId(cnt);
            font_format.setParagraphId(paragraph_id);
            font_format.setToken(token);
            font_format.setColor(run.getColor()==null? "??????" : run.getColor());
            font_format.setFontSize(run.getFontSizeAsDouble());
            font_format.setFontName(run.getFontName());
            font_format.setBold(run.isBold());
            font_format.setItalic(run.isItalic());
            font_format.setFontAlignment(run.getKerning());
            font_format.setText(run.getText(run.getTextPosition()));
            fontFormatRepository.save(font_format);
            cnt++;

//            titile_map.put("content", run.getText(0));
//            String Bold = Boolean.toString(run.isBold());//??????
//            titile_map.put("Bold", Bold);
//            String color = run.getColor();//????????????
//            titile_map.put("Color", color);
//
//            String FontFamily = run.getFontFamily(XWPFRun.FontCharRange.hAnsi);//??????
//            titile_map.put("FontFamily", FontFamily);
//
//            String FontName = run.getFontName();//??????
//            titile_map.put("FontName", FontName);
//
//            String FontSize = run.getFontSize() + "";//????????????
//            titile_map.put("FontSize", FontSize);
//
//            String Italic = Boolean.toString(run.isItalic());//????????????
//            titile_map.put("Italic", Italic);
        }
    }

    private static String getTitleLvl(XWPFDocument doc, XWPFParagraph para) {
        String titleLvl = "";
        try {
            //??????????????????????????????????????????
            if (para.getCTP().getPPr().getOutlineLvl() != null) {
                // System.out.println("getCTP()");
                //              System.out.println(para.getParagraphText());
                //              System.out.println(para.getCTP().getPPr().getOutlineLvl().getVal());

                return String.valueOf(para.getCTP().getPPr().getOutlineLvl().getVal());
            }
        } catch (Exception e) {

        }

        try {
            //???????????????????????????????????????????????????
            if (doc.getStyles().getStyle(para.getStyle()).getCTStyle().getPPr().getOutlineLvl() != null) {

                // System.out.println("getStyle");
                //              System.out.println(para.getParagraphText());
                //              System.out.println(doc.getStyles().getStyle(para.getStyle()).getCTStyle().getPPr().getOutlineLvl().getVal());

                return String.valueOf(doc.getStyles().getStyle(para.getStyle()).getCTStyle().getPPr().getOutlineLvl().getVal());
            }
        } catch (Exception e) {

        }

        try {
            //??????????????????????????????????????????????????????????????????
            if (doc.getStyles().getStyle(doc.getStyles().getStyle(para.getStyle()).getCTStyle().getBasedOn().getVal())
                    .getCTStyle().getPPr().getOutlineLvl() != null) {
                // System.out.println("getBasedOn");
                //              System.out.println(para.getParagraphText());
                String styleName = doc.getStyles().getStyle(para.getStyle()).getCTStyle().getBasedOn().getVal();
                //              System.out.println(doc.getStyles().getStyle(styleName).getCTStyle().getPPr().getOutlineLvl().getVal());

                return String.valueOf(doc.getStyles().getStyle(styleName).getCTStyle().getPPr().getOutlineLvl().getVal());
            }
        } catch (Exception e) {

        }

        try {
            if(para.getStyleID()!=null){
                return para.getStyleID();
            }
        } catch (Exception e) {

        }

        return titleLvl;
    }
}

