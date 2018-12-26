package priv.seesea.seeseabookclub.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.seesea.seeseabookclub.biz.BizLogger;
import priv.seesea.seeseabookclub.constant.Const;
import priv.seesea.seeseabookclub.constant.StringCode;
import priv.seesea.seeseabookclub.mapper.ReviewMapper;
import priv.seesea.seeseabookclub.model.pojo.Review;
import priv.seesea.seeseabookclub.service.ReviewService;
import priv.seesea.seeseabookclub.utils.JsonUtil;
import priv.seesea.seeseabookclub.utils.IDUtil;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 05 -19 -下午 8:51
 */

@Service
public class ReviewServiceimpl extends BizLogger implements ReviewService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public Integer postReview(Review review) throws IOException{
        logger.debug("开始插入书评");
        /**
         * 相关数据
         */
        CorrelationData correlationId = new CorrelationData(IDUtil.getUUID());
        logger.debug("发送消息");
        review.setReviewId(IDUtil.getId(Const.REVIEWPRE));
        String reviewJson = JsonUtil.objToJson(review);
        rabbitTemplate.convertAndSend(Const.EXCHANGE,Const.ROUTINGKEY1,reviewJson,correlationId);
        return 1;
    }

    @Override
    public Review getReviewByReviewId(String reviewId) {
        return reviewMapper.getReviewByReviewId(reviewId);
    }

    @Override
    public List<Review> getReviewByUserId(String userId) {
        return null;
    }

    @Override
    public List<Review> getReviewByBookId(String bookId) {
        return null;
    }

    @Override
    public List<Review> getReviewByTime(Date date) {
        return null;
    }

    @Override
    public Integer delReviewByUserIdAndBookId(String bookId, String userId) {
        return null;
    }

    @Override
    public List<Review> getAllReview(Integer num) {
        return reviewMapper.getAllReview(num);
    }
}
