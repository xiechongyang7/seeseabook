package priv.seesea.seeseabookclub.service.impl.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import priv.seesea.seeseabookclub.biz.BizLogger;
import priv.seesea.seeseabookclub.constant.Const;
import priv.seesea.seeseabookclub.mapper.DayTaskMapper;
import priv.seesea.seeseabookclub.utils.IDUtil;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 06 -25 -下午 11:00
 */

@Component
public class DayTask extends BizLogger{

    @Autowired
    private DayTaskMapper dayTaskMapper;

    @Scheduled(cron = "${task.time}")
    public void dayTask(){

        /**
         * 每天统计用户数量和书籍数量用户的书币
         */
        dayTaskMapper.putDayTask(IDUtil.getId(Const.DAYTASK),new Date());

    }
}
