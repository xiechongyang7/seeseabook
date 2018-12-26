package priv.seesea.seeseabookclub.mapper;

import org.apache.ibatis.annotations.Param;
import priv.seesea.seeseabookclub.model.pojo.Book;

import java.util.List;

public interface ClassifyMapper {

	/**
	 * 查询分类的内容
	 * 
	 * @param classifyId
	 * @return
	 */
	List<Book> getClassifyContent(@Param("classify") Integer classifyId);

}
