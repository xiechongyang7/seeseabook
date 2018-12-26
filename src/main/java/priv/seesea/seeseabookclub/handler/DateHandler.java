package priv.seesea.seeseabookclub.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import priv.seesea.seeseabookclub.biz.BizLogger;

import java.sql.*;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 05 -06 -下午 4:58
 */
public class DateHandler extends BizLogger implements TypeHandler<Date>{
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        logger.debug("开始转化时间 "+i+" "+date+":::::::");
        if(date==null){
            preparedStatement.setDate(i,null);
        }else {
            preparedStatement.setDate(i,date);
        }

    }

    @Override
    public Date getResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public Date getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public Date getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
