package com.example.datascience.serviceImpl;

import com.example.datascience.pojo.font.FontFormat;
import com.example.datascience.pojo.para.ParaFormat;
import com.example.datascience.pojo.para.ParaInfo;
import com.example.datascience.service.ParaParserService;
import org.apache.poi.hwpf.model.StyleSheet;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.hwpf.HWPFDocument;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ray
 */
@Service
@Slf4j
public class ParaParserServiceImpl implements ParaParserService {

    @Override
    public List<ParaInfo> getAllParas(String token) {
        return null;
    }

    @Override
    public List<ParaInfo> getAllParasInDocx(FileInputStream fileInputStream, String token) {
        List<Map<String, String>> allParaList = new ArrayList<>();
        try{
            XWPFDocument document=new XWPFDocument(fileInputStream);
            List<XWPFParagraph> paras = document.getParagraphs(); //将得到包含段落列表
            for (XWPFParagraph para: paras) {
                Map<String, String> titile = new HashMap<>();
                //缩进计算
                double ind = -1, ind_left = -1, ind_right = -1, ind_hang = -1;
                String ind_type = "";
                if (para.getIndentationHanging() != -1) {//悬挂缩进
                    ind_type = "hang";
                    if (para.getIndentationHanging() % 567 == 0) {//悬挂单位为厘米
                        ind = para.getIndentationHanging() / 567.0;
                        ind_left = (para.getIndentationLeft() - 567.0 * ind) / 210;
                    } else {//悬挂单位为字符
                        ind = para.getIndentationHanging() / 240;
                        ind_left = (para.getIndentationLeft() - para.getIndentationHanging()) / 210;
                    }
                    ind_right = para.getIndentationRight() / 210.0;
                } else {//首行缩进或者无
                    ind_type = "first";
                    if (para.getFirstLineIndent() == -1) {
                        ind_type = "none";
                        ind = 0;
                    } else {
                        ind = para.getFirstLineIndent() % 567.0 == 0 ? para.getFirstLineIndent() / 567.0 : para.getFirstLineIndent() / 240.0;
                    }
                    ind_left = para.getIndentationLeft() / 210;
                    ind_right = para.getIndentationRight() / 210.0;
                }
                titile.put("Text", para.getText());//本段全部内容
                titile.put("Alignment", para.getAlignment().toString());
                titile.put("SpacingBetween", para.getSpacingBetween() + "");//行距
                titile.put("SpacingBeforeLines", para.getSpacingBeforeLines() + "");//段前
                titile.put("SpacingAfterLines", para.getSpacingAfterLines() + "");//段后
                titile.put("NumLevelText", para.getNumLevelText() + "");//自动编号格式
                titile.put("indentFromLeft", String.valueOf(ind_left));//左方缩排
                titile.put("indentFromRight", String.valueOf(ind_right));//左方缩排
                titile.put("firstLineIndent", String.valueOf(ind_hang));//第一行缩排

                allParaList.add(titile);
                List<XWPFRun> runsLists = para.getRuns();//获取每一行
                //判断所有字体格式
                List<Map<String, String>> allRuns = new ArrayList<>();
                for (XWPFRun run : runsLists) {
                    Map<String, String> titile_map = new HashMap<>();
                    titile_map.put("content", run.getText(0));
                    String Bold = Boolean.toString(run.isBold());//加粗
                    titile_map.put("Bold", Bold);
                    String color = run.getColor();//字体颜色
                    titile_map.put("Color", color);

                    String FontFamily = run.getFontFamily(XWPFRun.FontCharRange.hAnsi);//字体
                    titile_map.put("FontFamily", FontFamily);

                    String FontName = run.getFontName();//字体
                    titile_map.put("FontName", FontName);

                    String FontSize = run.getFontSize() + "";//字体大小
                    titile_map.put("FontSize", FontSize);

                    String Italic = Boolean.toString(run.isItalic());//字体倾斜
                    titile_map.put("Italic", Italic);
                    allRuns.add(titile_map);
                }
            }
        }
        catch (Exception e){
            log.error("");
        }
        return null;
    }

    @Override
    public List<ParaInfo> getAllParasInDoc(FileInputStream fileInputStream, String token) {
        List<Map<String, String>> allParaList = new ArrayList<>();
        try{
            HWPFDocument document=new HWPFDocument(fileInputStream);
            Range r = document.getRange();
            for (int i = 0; i < r.numParagraphs(); i++) {
                Paragraph para = r.getParagraph(i);// 获取段落
                int numStyles = document.getStyleSheet().numStyles();
                int styleIndex = para.getStyleIndex();
            }
            document.close();
        }
        catch (Exception e){
            log.error("");
        }
        return null;
    }

    @Override
    public List<ParaInfo> getPara(String token, int paragraphId) {
        return null;
    }

    @Override
    public List<ParaFormat> getParaFormat(String token, int paragraph_id) {
        return null;
    }

    @Override
    public List<FontFormat> getFontFormat(String token, int paragraph_id) {
        return null;
    }
}

