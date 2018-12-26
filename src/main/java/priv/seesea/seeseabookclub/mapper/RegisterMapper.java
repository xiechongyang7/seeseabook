package priv.seesea.seeseabookclub.mapper;

import org.apache.ibatis.annotations.Param;
import priv.seesea.seeseabookclub.model.pojo.User;

/**
 * 注册用户
 * @author http://blog.csdn.net/thewaiting
 *
 */
public interface RegisterMapper {

	/**
	 * 增加一个用户
	 * @param user
	 * @return
	 */
	Integer putUser(@Param("id") String id,@Param("phone") String phone,@Param("passward") String passward);
	
}
