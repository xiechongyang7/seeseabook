package priv.seesea.seeseabookclub.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import priv.seesea.seeseabookclub.model.pojo.AppraiseEnum;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 评论转换器
 * 
 * @author http://blog.csdn.net/thewaiting
 *
 */
public class AppraiseEnumHandler implements TypeHandler<AppraiseEnum> {

	@Override
	public void setParameter(PreparedStatement ps, int i, AppraiseEnum parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setInt(i, parameter.getValue());
	}

	@Override
	public AppraiseEnum getResult(ResultSet rs, String columnName) throws SQLException {
		return AppraiseEnum.getAppraiseEnum(rs.getInt(columnName));
	}

	@Override
	public AppraiseEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
		return AppraiseEnum.getAppraiseEnum(rs.getInt(columnIndex));
	}

	@Override
	public AppraiseEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return AppraiseEnum.getAppraiseEnum(cs.getInt(columnIndex));
	}

}
