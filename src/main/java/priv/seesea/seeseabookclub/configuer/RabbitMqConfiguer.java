package priv.seesea.seeseabookclub.configuer;

import com.rabbitmq.client.ConnectionFactoryConfigurator;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.SimpleConnection;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import priv.seesea.seeseabookclub.constant.Const;
import priv.seesea.seeseabookclub.constant.StringCode;
import priv.seesea.seeseabookclub.service.impl.callback.PutReviewMsgSendConfirmCallBack;
import priv.seesea.seeseabookclub.service.impl.listener.ListenerDemo;
import priv.seesea.seeseabookclub.service.impl.listener.PutReviewListener;


/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 05 -20 -上午 12:45
 */

@Configuration
public class RabbitMqConfiguer {

    /**
     * （1）Broker：经纪人。提供一种传输服务，维护一条从生产者到消费者的传输线路，保证消息数据能按照指定的方式传输。粗略的可以将图中的RabbitMQ Server当作Broker。

     （2）Exchange：消息交换机。指定消息按照什么规则路由到哪个队列Queue。

     （3）Queue：消息队列。消息的载体，每条消息都会被投送到一个或多个队列中。

     （4）Binding：绑定。作用就是将Exchange和Queue按照某种路由规则绑定起来。

     （5）RoutingKey：路由关键字。Exchange根据RoutingKey进行消息投递。

     （6）Vhost：虚拟主机。一个Broker可以有多个虚拟主机，用作不同用户的权限分离。一个虚拟主机持有一组Exchange、Queue和Binding。

     （7）Producer：消息生产者。主要将消息投递到对应的Exchange上面。一般是独立的程序。

     （8）Consumer：消息消费者。消息的接收者，一般是独立的程序。

     （9）Channel：消息通道，也称信道。在客户端的每个连接里可以建立多个Channel，每个Channel代表一个会话任务。
     */
    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;

    @Value("${spring.rabbitmq.publisher-confirms}")
    private Boolean confirms;



    /**
     * 创建连接工厂
     * @return
     */
    @Bean
    public CachingConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host,port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        connectionFactory.setPublisherConfirms(confirms);
        return connectionFactory;

    }

    /**
     *  1.定义direct exchange，绑定queueTest
     *  2.durable="true" rabbitmq重启的时候不需要创建新的交换机
     *  3.direct交换器相对来说比较简单，匹配规则为：如果路由键匹配，消息就被投送到相关的队列
     *  fanout交换器中没有路由键的概念，他会把消息发送到所有绑定在此交换器上面的队列中。
     *  topic交换器你采用模糊匹配路由键的原则进行转发消息到队列中
     *  key: queue在该direct-exchange中的key值，
     *  当消息发送给direct-exchange中指定key为设置值时，消息将会转发给queue参数指定的消息队列
     * @return
     */
    @Bean
    public DirectExchange directExchange(){
        DirectExchange directExchange =
                new DirectExchange(Const.EXCHANGE,true,false);
        return directExchange;
    }

    /**
     * 定义队列1
     * @return
     */
    @Bean
    public Queue queue_one(){
        /**
         * durable="true" 持久化 rabbitmq重启的时候不需要创建新的队列
         * auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
         * exclusive  表示该消息队列是否只在当前connection生效,默认是false
         */
        Queue queue = new Queue("queue_one",true,false,false);
        return queue;
    }


    /**
     * 将消息队列1和交换机进行绑定
     * @return
     */
    @Bean
    public Binding binding_one(){
        return BindingBuilder.bind(queue_one()).to(directExchange()).with(Const.ROUTINGKEY1);
    }

    /**
     * 定义队列2
     */
    @Bean
    public Queue queue_two(){
        /**
         * durable="true" 持久化 rabbitmq重启的时候不需要创建新的队列
         * auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
         * exclusive  表示该消息队列是否只在当前connection生效,默认是false
         */
        Queue queue = new Queue("queue_two",true,false,false);
        return queue;
    }

    /**
     * 将消息队列和交换机机型绑定
     */
    @Bean
    public Binding binding_two(){
        return BindingBuilder.bind(queue_two()).to(directExchange()).with(Const.ROUTINGKEY2);
    }


    /**
     * queue linter 观察者 监听模式 当有消息到达时会在对应的队列上监听对象
     * @return
     */
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer_one(){
        SimpleMessageListenerContainer simpleMessageListenerContainer =
                new SimpleMessageListenerContainer(connectionFactory());
        simpleMessageListenerContainer.addQueues(queue_one());
        simpleMessageListenerContainer.setExposeListenerChannel(true);
        simpleMessageListenerContainer.setMaxConcurrentConsumers(1);
        /**
         * 设置确认模式 手工确认
         */
        simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        simpleMessageListenerContainer.setMessageListener(messageConsumerPutReview());
        return simpleMessageListenerContainer;

    }

    /**
     * 定义消费者
     */
    @Bean
    public PutReviewListener messageConsumerPutReview(){
        return new PutReviewListener();
    }

    /**
     * 观察 监听模式 当有消息到达时会通知监听在对应的队列上的监听对象
     */
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer_two(){
        SimpleMessageListenerContainer simpleMessageListenerContainer =
                new SimpleMessageListenerContainer(connectionFactory());
        simpleMessageListenerContainer.addQueues(queue_two());
        simpleMessageListenerContainer.setExposeListenerChannel(true);
        simpleMessageListenerContainer.setMaxConcurrentConsumers(1);
        /**
         * 是用手工确认
         */
        simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        simpleMessageListenerContainer.setMessageListener(messageConsumerListenerDemo());

        return simpleMessageListenerContainer;
    }

    /**
     * 定义消费者
     */
    @Bean
    public ListenerDemo messageConsumerListenerDemo(){
        return new ListenerDemo();
    }



    /**
     * 定义rabbitmq template用于接收发送数据
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        /**
         * 若使用confirm-callback或者return-callback，必须配置publishConfirms或publisherReturn为true
         * 每个rabbitmq只能有一个confirm-callback和return-callback
         */
        template.setConfirmCallback(msgSendConfirmCallBack());
//        template.setReturnCallback();
        /**
         * 使用return-callback时必须设置mandatory为true，或者在配置中设置mandatory-expression的值为true，
         * 可针对每次请求的消息去确定mandatory（委托）的Boolean的值
         * 只能在提供return-callback时使用 与mandatory互斥
         */

        //  template.setMandatory(true);
        return template;
    }

    /**
     * 消息确认机制
     * confirms给客户端一种轻量级的方式，能供跟踪那些消息被broker（中间商）宕掉或者网络失败的情况下重新发布
     * 确认并且保证消息被送达，提供了两种方式：发布确认和事务。（两者不可同时使用）在channel为事务时，不可引入确认模式；
     * 同样channel为确认模式下，不可使用事务
     */
    @Bean
    public PutReviewMsgSendConfirmCallBack msgSendConfirmCallBack(){
        return new PutReviewMsgSendConfirmCallBack();
    }

}
