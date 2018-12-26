package priv.seesea.seeseabookclub.mapper;

import org.apache.ibatis.annotations.Param;
import priv.seesea.seeseabookclub.model.pojo.Address;

/**
 * 地址mapper
 * @author http://blog.csdn.net/thewaiting
 *
 */
public interface AddressMapper {

	/**
	 * 通过用户的id寻找用户地址信息
	 * 
	 * @param userId
	 *            用户id
	 * @return 一个地址实例
	 */
	Address getAddressByUserId(@Param("userId") Long userId);

	/**
	 * 通过用户id修改地址信息
	 *
	 * @param address
	 *            地址类
	 * @return 修改后影响的行数
	 */
	Integer putAddressByUserId(Address address);

	/**
	 * 增加地址
	 * 
	 * @param address
	 *            地址实例--

	 * @return 增加后影响行数@Param("address")
	 */
	Integer postAddress(Address address);

	/**
	 * 通过用户的id删除地址信息
	 * 
	 * @param userId
	 *            用户id
	 * @return 返回影响行数
	 */
	Integer delAddress(@Param("userId") Long userId);

}
