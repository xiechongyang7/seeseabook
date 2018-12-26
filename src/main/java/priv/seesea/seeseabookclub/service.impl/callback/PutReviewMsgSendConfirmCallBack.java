package priv.seesea.seeseabookclub.service.impl.callback;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import priv.seesea.seeseabookclub.biz.BizLogger;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 05 -20 -下午 3:18
 */

/**
 * 添加消息发送到交换机确认机制
 */
public class PutReviewMsgSendConfirmCallBack extends BizLogger implements RabbitTemplate.ConfirmCallback{
    // 只确认生产者消息发送成功，消费者是否处理成功不做保证
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        /**
         * correlationData 相关数据
         */
        logger.debug("回调id:"+correlationData);
        if(b){
            logger.debug("消息接收成功");
        }else {
            logger.debug("消息接收失败:" + s+"\n重新发送");
        }
    }
}
