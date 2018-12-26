package priv.seesea.seeseabookclub.service.impl.callback;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 05 -20 -下午 3:30
 */

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import priv.seesea.seeseabookclub.biz.BizLogger;

/**
 * 暂时没用
 */
public class MsgSendReturnCallback extends BizLogger implements RabbitTemplate.ReturnCallback{
    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        String msgJson = new String(message.getBody());
        logger.info("回馈消息:"+msgJson);
    }
}
