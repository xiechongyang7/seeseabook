package priv.seesea.seeseabookclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import priv.seesea.seeseabookclub.biz.BizLogger;

import priv.seesea.seeseabookclub.model.pojo.Download;
import priv.seesea.seeseabookclub.service.BookService;
import priv.seesea.seeseabookclub.service.DownloadService;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;

import java.io.InputStream;


/**
 * @author http://blog.csdn.net/thewaiting
 */

@Controller
@RequestMapping(value ="/download")
public class DownloadController extends BizLogger{

    @Autowired
    private DownloadService downloadService;
    private BookService bookService;



    @RequestMapping(value = "getBook",method = RequestMethod.GET)
    public ResponseEntity<byte[]> getDownloadBybookId(String bookid,HttpServletRequest request) throws Exception{

        try{
            Download download = downloadService.getDownloadByBookId(bookid);
            String path = download.getDownloadLinkFirst().toString();
            InputStream in = new FileInputStream(new File(path));
            byte[] body= new byte[in.available()];
            in.read(body);
            String[] fileName = path.split("\\\\");
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment;filename="+fileName[fileName.length-1].toString());
            HttpStatus statusCode = HttpStatus.OK;

            ResponseEntity<byte[]> reponse = new ResponseEntity<>(body,headers,statusCode);
            return reponse;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }

    }

}
