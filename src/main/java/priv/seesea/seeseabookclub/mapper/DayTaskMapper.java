package priv.seesea.seeseabookclub.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 06 -25 -下午 11:05
 */

public interface DayTaskMapper {


    /**
     * 定时统计
     * @param dayId
     * @param dayTime
     */
    @Insert("INSERT INTO tb_day (day_id,day_user_num,day_book_num,day_view_num,day_user_con,day_time) VALUES (#{dayId}, (select count(user_id) from tb_user), (select count(book_id) from tb_book), (select count(review_id) from tb_review), (select sum(user_coin) from tb_user),#{dayTime,jdbcType=DATE})")
    void putDayTask(@Param("dayId") String dayId, @Param("dayTime")Date dayTime);
}
