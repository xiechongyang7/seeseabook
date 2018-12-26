package priv.seesea.seeseabookclub.utils;

import priv.seesea.seeseabookclub.constant.Const;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 05 -13 -上午 12:05
 */


public class IDUtil {



    /**
     * 获取uuid
     * @return
     */
    public static String getUUID(){
       return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
//        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

//        System.out.println(getLoginId());
    }

    /**
     * 获取id
     * @param pre id前置标志
     * @return
     */
    public static String getId(String pre) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
        String id = pre + sdf.format(now);
        return id;
    }


}
