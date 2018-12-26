package priv.seesea.seeseabookclub.mapper;

import org.apache.ibatis.annotations.Param;
import priv.seesea.seeseabookclub.model.pojo.Book;

import java.util.List;

/**
 * 推荐书籍保留功能
 * @author http://blog.csdn.net/thewaiting
 *
 */
public interface RecommendMapper {

	/**
	 * 通过书籍id获取书籍
	 * @param bookId 书籍id
	 * @return 包含书籍的list
	 */
	List<Book> getRecommendBookByBookId(@Param("bookId") Long bookId);
}
