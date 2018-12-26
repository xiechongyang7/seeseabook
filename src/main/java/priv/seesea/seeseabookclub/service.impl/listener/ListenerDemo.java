package priv.seesea.seeseabookclub.service.impl.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import priv.seesea.seeseabookclub.biz.BizLogger;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 05 -20 -下午 3:16
 */


public class ListenerDemo extends BizLogger implements ChannelAwareMessageListener{
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        byte[] body = message.getBody();
        logger.info("收到消息2:::"+ new String(body));
        /**
         * 确认消息消费成功
         */
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}
