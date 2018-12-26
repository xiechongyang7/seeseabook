package priv.seesea.seeseabookclub.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import priv.seesea.seeseabookclub.model.pojo.Book;

import java.util.List;

/**
 * 书籍额基本查询增加功能
 * @author http://blog.csdn.net/thewaiting
 *
 */

@Mapper
public interface BookMapper {

	/**
	 * 通过书id查找书
	 * @param bookId 书id
	 * @return 书
	 */
	Book getBookByBookId(@Param("bookId") String bookId);


	/**
	 * 查询几本书
	 * @return
	 */
	List<Book> getNumBook(@Param("num") Integer num);
	
	/**
	 * 根据书名查找
	 * @param bookName
	 * @return
	 */
	List<Book> getBookByBookName(@Param("bookName") String bookName);
	
	/**
	 * 根据分类查找 一级
	 * @param classify 一级分类号码
	 * @return 包含此分类的书
	 */
	List<Book> getBookByClassifyFirst(@Param("classify") Integer classify);
	
	/**
	 * 根据分类二级查询
	 * @param firstClassify 一级分类号码
	 * @param secondClassify 二级分类号码
	 * @return 包含此分类的书
	 */
	List<Book> getBookByClassifySecond(@Param("firstClassify") Integer firstClassify, @Param("secondClassify") Integer secondClassify);

	/**
	 * 根据标签模糊查询
	 * @param tag 标签内容
	 * @return 包含此标签的书
	 */
	List<Book> getBookByTag(@Param("tag") String tag);

	/**
	 * 通过书籍的id删除书籍
	 * @param BookId 书id
	 * @return 删除后影响的行书
	 */
	Integer delBookByBookId(@Param("bookId") String BookId);

	/**
	 * 通过书籍id修改使书籍不可见
	 * @param BookId 书籍id
	 * @return 修改后影响的行数
	 */
	Integer putBookByBookIdNotSee(@Param("bookId") String BookId);

	/**
	 * 上传书籍
	 * @param book 书籍实例
	 * @return 增加后影响的行数
	 */
	Long postBook(Book book);
	
}
