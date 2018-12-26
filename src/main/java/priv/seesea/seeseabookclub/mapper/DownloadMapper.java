package priv.seesea.seeseabookclub.mapper;

import org.apache.ibatis.annotations.Param;
import priv.seesea.seeseabookclub.model.pojo.Download;

/**
 * 下载地址
 * @author http://blog.csdn.net/thewaiting
 *
 */
public interface DownloadMapper {

	/**
	 * 增加下载地址
	 * @param download 下载地址类
	 * @return 增加后影响的行数
	 */
	Integer postDownload(Download download);
	
	/**
	 * 通过书id查询下载地址
	 * @param bookId 书id
	 * @return 一个下载地址实例
	 */
	Download getDownloadByBookId(@Param("bookId") String bookId);
}
