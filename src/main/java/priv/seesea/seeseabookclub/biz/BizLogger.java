package priv.seesea.seeseabookclub.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.seesea.seeseabookclub.constant.StringCode;
import priv.seesea.seeseabookclub.utils.LoggerMsg;

/**
 * 继承此类可以直接使用logger
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 04 -29 -下午 5:39
 */
public class BizLogger {


    public Logger logger = LoggerFactory.getLogger(getClass());


    public void loggerMsg(Object obj,String errMsg){
        logger.error(StringCode.ERROR_STR+ obj +StringCode.LINKSTRING+ errMsg);
    }
    public void loggerMsg(String errMsg){
        logger.error(StringCode.ERROR_STR +StringCode.LINKSTRING+ errMsg);
    }
}
