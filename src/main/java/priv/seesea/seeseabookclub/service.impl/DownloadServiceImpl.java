package priv.seesea.seeseabookclub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.seesea.seeseabookclub.mapper.DownloadMapper;
import priv.seesea.seeseabookclub.model.pojo.Download;
import priv.seesea.seeseabookclub.service.DownloadService;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 05 -13 -下午 4:22
 */

@Service
public class DownloadServiceImpl implements DownloadService{

    @Autowired
    private DownloadMapper downloadMapper;

    @Override
    public Download getDownloadByBookId(String bookId) {
        return downloadMapper.getDownloadByBookId(bookId);
    }
}
