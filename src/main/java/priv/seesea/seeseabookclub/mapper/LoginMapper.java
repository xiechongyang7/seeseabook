package priv.seesea.seeseabookclub.mapper;

import org.apache.ibatis.annotations.Param;
import priv.seesea.seeseabookclub.model.pojo.Login;


/**
 * 登录mapper
 * @author http://blog.csdn.net/thewaiting
 *
 */
public interface LoginMapper {

	/**
	 * 通过主键删除登录信息
	 * 
	 * @param loginId
	 *            登录表主键
	 * @return 删除后影响的行数
	 */
	Integer delLoginByLoginId(@Param("loginId") Integer loginId);

	/**
	 * 增加登录信息
	 * 
	 * @param login
	 *            登录实例
	 * @return 增加后影响行数
	 */
	Integer postLogin(Login login);

	/**
	 * 查找登陆表的信息
	 * 
	 * @param loginId
	 *            登陆表主键
	 * @return 返回登陆表主键
	 */
	Login getLoginByLoginId(@Param("loginId") Integer loginId);

	/**
	 * 通过用户id和uuid值查询自动登录记录
	 * 
	 * @param useId
	 *            用户id
	 * @param series
	 *            UUID值
	 * @return
	 */
	Login getLoginByUserIdAndSeries(@Param("userId") Long useId, @Param("series") String series);

	/**
	 * 通过用户id查找自动登录记录
	 * 
	 * @param userId
	 *            用户名
	 * @return
	 */
	Login getLoginByUserId(@Param("userId") Long userId);
	
	/**
	 * 通过用户的id获取密码
	 * 
	 * @param userId
	 *            用户id
	 * @return 用户的密码
	 */
	String getPassward(@Param("userPhone") String userPhone);

}
