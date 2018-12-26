package priv.seesea.seeseabookclub.mapper;

import org.apache.ibatis.annotations.Param;
import priv.seesea.seeseabookclub.model.pojo.Book;

import java.util.Date;
import java.util.List;

public interface RankMapper {

	/**
	 * 通过时间进行排行
	 * @param time 时间
	 * @return 截止日期之前 包含的书籍
	 */
	List<Book> getRankBookByDate(@Param("time") Date time);

	/**
	 * 通过点赞排行
	 * @param praiseNum 点赞数
	 * @return 返回大于点赞数的书
	 */
	List<Book> getRankBookByPraise(@Param("praiseNum") Integer praiseNum);
	
}
