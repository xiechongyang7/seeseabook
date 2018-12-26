package priv.seesea.seeseabookclub.mapper;

import org.apache.ibatis.annotations.Param;
import priv.seesea.seeseabookclub.model.pojo.Blist;
import priv.seesea.seeseabookclub.model.pojo.Book;

import java.util.List;

/**
 * 书单书籍的查询
 * @author http://blog.csdn.net/thewaiting
 *
 */
public interface BlistBookMapper {

	/**
	 * 通过书单id查询包含的书
	 * @param blist 书单id
	 * @return 此书单下的书籍
	 */
	List<Book> getBookByBlistId(@Param("blist") Long blist);
	
	/**
	 * 通过书籍id查询包含的书单
	 * @param bookId 书籍id
	 * @return 包含此书的书单
	 */
	List<Blist> getBlistByBookId(@Param("bookId") Long bookId);
}
