package priv.seesea.seeseabookclub.mapper;

import org.apache.ibatis.annotations.Param;
import priv.seesea.seeseabookclub.model.pojo.Book;
import priv.seesea.seeseabookclub.model.pojo.Collection;

import java.util.List;

/**
 * 用户收藏id 
 * @author http://blog.csdn.net/thewaiting
 *
 */
public interface UserCollectionMapper {

	/**
	 * 通过用户id查找用户的收藏
	 * 
	 * @param userId
	 * @return
	 */
	List<Book> getCollectionBookByUserId(@Param("userId") String userId);

	/**
	 * 判断是否收藏
	 *
	 * @param userId
	 *            用户id
	 * @param booId
	 *            书id
	 * @return 删除后影响的行数
	 */
	Integer getCollectionByUserIdAndBookId(@Param("userId") String userId, @Param("bookId") String bookId);

	/**
	 * 通过用户id和收藏id删除收藏
	 * 
	 * @param userId
	 *            用户id
	 * @param booId
	 *            书id
	 * @return 删除后影响的行数
	 */
	Integer delBookByUserIdAndBookID(@Param("userId") Long userId, @Param("bookId") Long booId);

	/**
	 * 通过收藏id删除收藏
	 * 
	 * @param collectionId
	 *            收藏id
	 * @return 删除后影响的行数
	 */
	Integer delBookByCollectionId(@Param("collectionId") Long collectionId);

	/**
	 * 增加收藏
	 * 
	 * @param collection
	 *            收藏实例
	 * @return 增加后影响的行数
	 */
	Integer postCollection(Collection collection);

}
