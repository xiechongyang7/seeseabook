package priv.seesea.seeseabookclub.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import priv.seesea.seeseabookclub.model.pojo.Book;

import java.util.List;

/**
 * @author http://blog.csdn.net/thewaiting
 */

public interface BookService {

    /**
     * 根据书籍id查找书籍信息
     * @param bookId
     * @return
     */
    Book getBookByBookId(String bookId) throws Exception;


    /**
     * 查找num本书
     * @param num
     * @return
     */
    List<Book> getNumBook(Integer num) throws Exception;

    /**
     * 根据书名查找
     * @param bookName
     * @return
     */
    List<Book> getBookByBookNmae(String bookName) throws Exception;

    /**
     * 根据分类查找
     * @param classify
     * @return
     */
    List<Book> getBookByClassifyFirst(Integer classify) throws Exception;

    /**
     * 通关书籍id修改为不可见
     * @param bookId
     * @return
     */
    Integer putBookByBookIdNotSee(String bookId) throws Exception;

    /**
     * 上传书籍
     * @param book
     * @return
     */
    Integer postBook(MultipartFile[] file,Book book) throws Exception;
}
