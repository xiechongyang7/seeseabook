package priv.seesea.seeseabookclub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.seesea.seeseabookclub.mapper.ClassifyMapper;
import priv.seesea.seeseabookclub.model.pojo.Book;
import priv.seesea.seeseabookclub.service.ClassifyService;

import java.util.List;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 06 -09 -下午 9:39
 */

@Service
public class ClassifyServiceImpl implements ClassifyService {


    @Autowired
    private ClassifyMapper classifyMapper;

    @Override
    public List<Book> getClassifyContent(Integer classifyId) {
        return classifyMapper.getClassifyContent(classifyId);
    }

}
