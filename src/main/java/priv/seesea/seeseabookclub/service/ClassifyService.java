package priv.seesea.seeseabookclub.service;

import priv.seesea.seeseabookclub.mapper.ClassifyMapper;
import priv.seesea.seeseabookclub.model.pojo.Book;

import java.util.List;

/**
 * @author http://blog.csdn.net/thewaiting
 */
public interface ClassifyService {

   List<Book> getClassifyContent(Integer classifyId);

}
