package priv.seesea.seeseabookclub.mapper;

import org.apache.ibatis.annotations.Param;
import priv.seesea.seeseabookclub.model.pojo.Blist;
import priv.seesea.seeseabookclub.model.pojo.BlistBook;

import java.util.List;

/**
 * 书单基本增删改查
 * @author http://blog.csdn.net/thewaiting
 *
 */
public interface BlistMapper {

	/**
	 * 创建书单
	 * @param blist 书单实例
	 * @return 创建后影响的行数
	 */
	Integer postBlist(Blist blist);
	
	/**
	 * 通过用户id查询用户书单
	 * @param userId 用户id
	 * @return 包含书单实例的list
	 */
	List<BlistBook> getBlistByUserId(@Param("userId") Long userId);

	/**
	 * 通过书单id查询书单
	 * @param blistId 书单id
	 * @return 一个包含书单的list
	 */
	List<Blist> getBlistByBlistId(@Param("blistId") Long blistId);
	
	/**
	 * 通过书籍id查询书单 !!!!此方法保留
	 * @param bookId 书籍id
	 * @return 一个包含书单的list
	 */
	List<Blist> getBlistByBookId(@Param("bookId") Long bookId);
	
	/**
	 * 通过书单id删除书单
	 * @param blistId
	 * @return
	 */
	Integer delBlistByBlistId(@Param("blistId") Long blistId);
	
}
