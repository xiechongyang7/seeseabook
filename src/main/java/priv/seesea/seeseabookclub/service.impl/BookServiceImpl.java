package priv.seesea.seeseabookclub.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import priv.seesea.seeseabookclub.constant.Const;
import priv.seesea.seeseabookclub.constant.StringCode;
import priv.seesea.seeseabookclub.mapper.BookMapper;
import priv.seesea.seeseabookclub.mapper.DownloadMapper;
import priv.seesea.seeseabookclub.model.pojo.Book;
import priv.seesea.seeseabookclub.model.pojo.Download;
import priv.seesea.seeseabookclub.service.BookService;
import priv.seesea.seeseabookclub.utils.IDUtil;

import java.io.File;
import java.util.List;

/**
 * @author http://blog.csdn.net/thewaiting
 */
@Service
public class BookServiceImpl implements BookService{

    private static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private DownloadMapper downloadMapper;


    @Override
    public Book getBookByBookId(String bookId) throws Exception{

        return bookMapper.getBookByBookId(bookId);
    }

    @Override
    public List<Book> getNumBook(Integer num)throws Exception {
        return bookMapper.getNumBook(num);
    }

    @Override
    public List<Book> getBookByBookNmae(String bookName) throws Exception {

        return bookMapper.getBookByBookName(bookName);
    }

    @Override
    public List<Book> getBookByClassifyFirst(Integer classify) throws Exception {
        return bookMapper.getBookByClassifyFirst(classify);
    }

    @Override
    public Integer putBookByBookIdNotSee(String bookId) throws Exception {
        return bookMapper.putBookByBookIdNotSee(bookId);
    }

    /**
     * 上传书籍
     * 书籍信息持久化 书籍和封面文件上传到前端的img文件夹中
     * @param files
     * @param book
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public Integer postBook(MultipartFile[] files,Book book) throws Exception {


        try{
            book.setBookId(IDUtil.getId(Const.BOOKPRE));
            String filename = files[0].getOriginalFilename();
            files[0].transferTo(new File(Const.FILE_PATH_IMG+filename));
            String filename2 = files[1].getOriginalFilename();
            files[1].transferTo(new File(Const.FILE_PATH_BOOK+filename2));
            book.setBookCover(filename);


            /**
             * mybait主键回填时直接赋值到对象
             */

            if(bookMapper.postBook(book)!=0){
                Download download = new Download();
                download.setDownloadId(IDUtil.getId(Const.DOWNLOADPRE));
                download.setDownloadBookId(book.getBookId());
                download.setDownloadLinkFirst(Const.FILE_PATH_BOOK+filename2);
                if(downloadMapper.postDownload(download)==0){
                    return 0;
                }
                return 1;
            }
            return 0;

        }catch (Exception e){
            e.printStackTrace();
            throw e;

        }
    }
}
