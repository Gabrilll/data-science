package com.example.datascience.serviceImpl;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import com.example.datascience.constant.FileExt;
import com.example.datascience.dao.FontFormatRepository;
import com.example.datascience.dao.PicRepository;
import com.example.datascience.dao.WordRepository;
import com.example.datascience.dao.paragraph.ParagraphFormatRepository;
import com.example.datascience.dao.paragraph.ParagraphRepository;
import com.example.datascience.dao.table.TableContentRepository;
import com.example.datascience.dao.table.TableRepository;
import com.example.datascience.dao.title.TitleRepository;
import com.example.datascience.pojo.CommonInfo;
import com.example.datascience.pojo.Response;
import com.example.datascience.pojo.po.Word;
import com.example.datascience.pojo.vo.WordInfo;
import com.example.datascience.service.ParaParserService;
import com.example.datascience.service.PicParserService;
import com.example.datascience.service.TableParserService;
import com.example.datascience.service.WordService;
import com.example.datascience.utils.SHA256Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;

@Service
@Slf4j
public class WordServiceImpl implements WordService {

    @Value("${web.upload-path}")
    private String uploadFilePath;

    @Autowired
    private ParaParserService paraParserService;
    @Autowired
    private PicParserService picParserService;
    @Autowired
    private TableParserService tableParserService;

    @Autowired
    private WordRepository wordRepository;
    @Autowired
    private ParagraphFormatRepository paragraphFormatRepository;
    @Autowired
    private ParagraphRepository paragraphRepository;
    @Autowired
    private TableContentRepository tableContentRepository;
    @Autowired
    private TableRepository tableRepository;
    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private FontFormatRepository fontFormatRepository;
    @Autowired
    private PicRepository picRepository;

    @Override
    public String loadFile(String fileName, FileExt ext, byte[] bytes) {
        System.out.println("filename: " + fileName);

        // 1. create token
        String token = SHA256Utils.getToken(bytes);
        if (token == null) {
            return null;
        }

        // 2. save word
        Word word = new Word(token, fileName, "." + ext.name().toLowerCase(), bytes);
        try {
            wordRepository.save(word);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Response<WordInfo> parseFile(String token, InputStream inputStream) {
        XWPFDocument document;
        try {
            document = new XWPFDocument(inputStream);
            paraParserService.ParasParserInDocx(document, token);
            tableParserService.parseAllTables(document, token);
            picParserService.parseAllPics(document, token);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Response.success(new WordInfo(token));
    }

    @Override
    public FileExt distinguishRealExtension(InputStream inputStream) {
        try {
            if (!inputStream.markSupported()) {
                inputStream = new BufferedInputStream(inputStream);
            }
            FileMagic fileMagic = FileMagic.valueOf(inputStream);
            switch (fileMagic) {
                case OLE2:
                    return FileExt.DOC;
                case OOXML:
                    return FileExt.DOCX;
                case PDF:
                    return FileExt.PDF;
                default:
                    System.out.println("[warning!!!!!!!!!] un support extension " + fileMagic.name());
                    return FileExt.UN_SUPPORT;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private InputStream readFile(String path) {
        // 2. 重新读文件生成 inputStream
        try {
            return new BufferedInputStream(new FileInputStream(new File(path)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public InputStream convertDocToDocx(InputStream inputStream) {
        System.out.println("uploadFilePath: " + uploadFilePath);

        // 1. 保存成 docx
        String path = uploadFilePath + "/tmp.docx";
        try {
            Document document = new Document(inputStream);
            document.save(path, SaveFormat.DOCX);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return readFile(path);
    }

    @Override
    public InputStream convertPDFToDocx(InputStream inputStream) {
        System.out.println("uploadFilePath: " + uploadFilePath);

        // 1. 保存成 docx
        String path = uploadFilePath + "/tmp.docx";
        try {
            com.aspose.pdf.Document document = new com.aspose.pdf.Document(inputStream);
            document.save(path, com.aspose.pdf.SaveFormat.DocX);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return readFile(path);
    }

    @Transactional
    @Override
    public Response<CommonInfo> deleteWord(String token) {
        try {
            wordRepository.deleteByToken(token);
            paragraphRepository.deleteByWordToken(token);
            paragraphRepository.deleteByWordToken(token);
            tableContentRepository.deleteByToken(token);
            tableRepository.deleteByToken(token);
            titleRepository.deleteByWordToken(token);
            fontFormatRepository.deleteByToken(token);
            picRepository.deleteByToken(token);
            return Response.success(new CommonInfo(true));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(e.getMessage());
        }
    }
}
