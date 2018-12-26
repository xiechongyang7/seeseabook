package priv.seesea.seeseabookclub.service;

import priv.seesea.seeseabookclub.model.pojo.Book;
import priv.seesea.seeseabookclub.model.pojo.Collection;

import java.util.List;

/**
 * @author http://blog.csdn.net/thewaiting
 */
public interface UserCollectionService {

    /**
     * 用户id查询收藏
     * @param userId
     * @return
     */
    List<Book> getCollectionBookByUserId(String userId);

    /**
     * 用户id删除收藏
     * @param userId
     * @return
     */
    Integer delBookByUserIdAndBookID(String userId);

    /**
     * 收藏id删除
     * @param collectionId
     * @return
     */
    Integer delBookByCollectionId(String collectionId);

    /**
     * 增加收藏
     * @param collection
     * @return
     */
    Integer postCollection(Collection collection);
}
