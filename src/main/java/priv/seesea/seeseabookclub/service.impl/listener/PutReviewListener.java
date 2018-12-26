package priv.seesea.seeseabookclub.service.impl.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import priv.seesea.seeseabookclub.biz.BizLogger;
import priv.seesea.seeseabookclub.mapper.ReviewMapper;
import priv.seesea.seeseabookclub.model.pojo.Review;
import priv.seesea.seeseabookclub.service.RedisService;
import priv.seesea.seeseabookclub.utils.JsonUtil;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 05 -20 -下午 3:14
 */


public class PutReviewListener extends BizLogger implements ChannelAwareMessageListener{


    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        byte[] body = message.getBody();
        String reviewJson = new String(body);
        logger.debug("收到消息1:::::" + message.getMessageProperties().getCorrelationId()+reviewJson);

        try{
            Review review = JsonUtil.jsonToObject(reviewJson,Review.class);
            redisService.saveValue("reviewlist",review,200);
            if(reviewMapper.postReview(review)!=0){
                /**
                 * 确认消息消费成功
                 * 第一个参数 是消息的tag 确定哪条消息被消费了
                 * 第二个参数是 true:额外将比第一个参数指定的 delivery tag 小的消息一并确认了(批量确认) false:当前消息被消费了
                 */
                channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            }else {
                throw new Exception("插入数据失败");
            }
        }catch (Exception e){
            logger.error("插入到书评表出现错误",e.getMessage());
            /**
             * 重新投递
             * 第一个参数重新投递消息的tag
             * 第二个参数
             * 第二个参数说明如何处理这个失败消息。requeue 值为 true 表示该消息重新放回队列头，值为 false 表示放弃这条消息。
             */
            /**
             * 第一个参数指定 delivery tag，第二个参数说明如何处理这个失败消息。requeue 值为 true 表示该消息重新放回队列头，值为 false 表示放弃这条消息。
             * 一般来说，如果是系统无法处理的异常，我们一般是将 requeue 设为 false，例如消息格式错误，再处理多少次也是异常。
             * 调用第三方接口超时这类异常 requeue 应该设为 true。
             * 从 basicReject 方法参数可见，取消确认不支持批量操作（类似于 basicAck 的 multiple 参数）。所以，RabbitMQ 增加了 basicNack 方法以提供批量取消能力。
             */
            /**
             * 重复放入队列3次 还不能处理就放弃
             */
            if(message.getMessageProperties().getDeliveryTag()>3){
                logger.error("消息已重复处理失败，拒绝再次接受::::"+e.getMessage());
                /**
                 * 拒绝接受
                 */
                channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
                throw e;
            }else {
//                channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
                /**
                 * 第一次出错再次放回队列
                 */
                logger.debug("第"+message.getMessageProperties().getDeliveryTag()+"出错，再次放入队列");
                channel.basicRecover();
            }

        }


    }
}
