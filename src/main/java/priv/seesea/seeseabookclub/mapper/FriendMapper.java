package priv.seesea.seeseabookclub.mapper;

import org.apache.ibatis.annotations.Param;
import priv.seesea.seeseabookclub.model.pojo.Friend;
import priv.seesea.seeseabookclub.model.pojo.User;

import java.util.List;

public interface FriendMapper {

	/**
	 * 增加关系
	 * 
	 * @param friend
	 *            friend实例
	 * @return 增加后影响行数
	 */
	Integer postFriend(@Param("friend") Friend friend);

	/**
	 * 通过用户id找到粉丝
	 * 
	 * @param userId
	 *            用户id
	 * @return 包含粉丝的list
	 */
	List<User> getUserFanByUesrId(@Param("userId") Long userId);

	/**
	 * 通过用户的id寻找关注
	 * 
	 * @param userId
	 *            用户id
	 * @return 包含关注人的list
	 */
	List<User> getUserFollowByUserId(@Param("userId") Long userId);

	/**
	 * 删除关系通过用户id和关系人id
	 * 
	 * @param userId
	 *            用户id
	 * @param fanId
	 *            关系人id
	 * @return 返回删除后影响的行数
	 */
	Integer delFriend(@Param("userId") Long userId, @Param("fanId") Long fanId);

	/**
	 * 删除关系通过关系表id
	 * 
	 * @param friendId
	 *            关系表id
	 * @return
	 */
	Integer delFriend(@Param("friendId") Long friendId);

}
