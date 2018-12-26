package priv.seesea.seeseabookclub.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.slf4j.LoggerFactory;
import priv.seesea.seeseabookclub.model.pojo.SexEnum;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 性别转换器
 * 
 * @author http://blog.csdn.net/thewaiting
 *
 */
//@MappedJdbcTypes({JdbcType.INTEGER})
//@MappedTypes(value = {SexEnum.class})
public class SexEnumHandler implements TypeHandler<String> {

	org.slf4j.Logger logger = LoggerFactory.getLogger(SexEnumHandler.class);


	/**
	 * 查取的时候如果是列名就用getInt(String column)
	 */
	@Override
	public String getResult(ResultSet arg0, String arg1) throws SQLException {


		return SexEnum.getSexEnum(arg0.getInt(arg1));
	}

	/**
	 * 查询的时候如果是列数就用getInt(int column)
	 */
	@Override
	public String getResult(ResultSet arg0, int arg1) throws SQLException {

		return SexEnum.getSexEnum(arg0.getInt(arg1));
	}

	/**
	 * 查询过程同理
	 */
	@Override
	public String getResult(CallableStatement arg0, int arg1) throws SQLException {

		return SexEnum.getSexEnum(arg0.getInt(arg1));
	}


	/**
	 * 像JDBC一样进行占位并且 当传入SexEnum实例的 使用setInt方法进行类型转换，实现传入数据库写的使SexEnum但是存的是一个整数
	 */
//	@Override
//	public void setParameter(PreparedStatement arg0, int arg1, SexEnum arg2, JdbcType arg3) throws SQLException {
//
//		arg0.setInt(arg1, arg2.getValue());
//	}

	@Override
	public void setParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {

	}



}
