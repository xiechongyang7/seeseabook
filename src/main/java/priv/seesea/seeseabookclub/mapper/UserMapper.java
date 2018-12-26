package priv.seesea.seeseabookclub.mapper;

import org.apache.ibatis.annotations.Param;
import priv.seesea.seeseabookclub.model.pojo.User;

/**
 * 用户mapper
 * @author http://blog.csdn.net/thewaiting
 *
 */
public interface UserMapper {


	/**
	 * 查询带有地址的信息
	 * @param userId
	 * @return
	 */
	User getUserAndAdress(@Param("userId")String userId);

	/**
	 * 通过用户手机号码返回一个用户的实例
	 * 
	 * @param userPhone
	 *            用户id
	 * @return 用户实例
	 */
	User getUserByUserId(@Param("userPhone") String userPhone);



	/**
	 * 通过用户id修改用户的信息
	 * 
	 * @param user
	 *            用户实例
	 * @param user
	 *            用户id
	 * @return 修改后影响行数
	 */
	Integer postUserById(User user);

	/**
	 * 用户变更为会员
	 * @param userId 用户id
	 * @param vip vip代号 1是会员
	 * @return 变更会员后影响行数
	 */
	Integer putUserVipByUserId(@Param("userId") String userId, @Param("vip") Integer vip);

	/**
	 * 修改密码
	 * @param userId 用户id
	 * @param passward 用户新密码
	 * @return 修改密码后影响的行数
	 */
	Integer putUserPasswardByUserId(@Param("userId") String userId, @Param("passward") String passward);

	/**
	 * 修改用户金币
	 * @param userId
	 * @param coinNum
	 * @return
	 */
	Integer putUserPasswardByUserAndCoin(@Param("userId") String userId, @Param("coinNum") Integer coinNum);

	/**
	 * 修改用户头像
	 * @param userId 用户id
	 * @param portrait  用户头像的地址
	 * @return 修改头像后影响的行数
	 */
	Integer putUserPortraitByUserId(@Param("userId") String userId, @Param("portrait") String portrait);
}
