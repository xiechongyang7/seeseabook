package priv.seesea.seeseabookclub.service;

import priv.seesea.seeseabookclub.model.pojo.Download;

/**
 * @author http://blog.csdn.net/thewaiting
 */
public interface DownloadService {

    /**
     * 书籍id查询下载地址
     * @param bookId
     * @return
     */
    Download getDownloadByBookId(String bookId);
}
