package priv.seesea.seeseabookclub.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.seesea.seeseabookclub.constant.Const;
import priv.seesea.seeseabookclub.mapper.UserCollectionMapper;
import priv.seesea.seeseabookclub.model.pojo.Book;
import priv.seesea.seeseabookclub.model.pojo.Collection;
import priv.seesea.seeseabookclub.service.UserCollectionService;
import priv.seesea.seeseabookclub.utils.IDUtil;

import java.util.List;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 05 -05 -下午 10:13
 */

@Service
public class UserCollectionServiceImpl implements UserCollectionService{


    @Autowired
    private UserCollectionMapper userCollectionMapper;

    @Override
    public List<Book> getCollectionBookByUserId(String userId) {
        return userCollectionMapper.getCollectionBookByUserId(userId);
    }

    @Override
    public Integer delBookByUserIdAndBookID(String userId) {
        return null;
    }

    @Override
    public Integer delBookByCollectionId(String collectionId) {
        return null;
    }

    @Override
    @Transactional
    public Integer postCollection(Collection collection) {
        collection.setCollectionId(IDUtil.getId(Const.CONLLECTIONPRE));
        int a = userCollectionMapper.getCollectionByUserIdAndBookId(collection.getCollectionUserId(),collection.getCollectionBookId());
        if(a!=0){
            return 0;
        }
        return userCollectionMapper.postCollection(collection);
    }
}
