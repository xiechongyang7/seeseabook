package priv.seesea.seeseabookclub.utils;/**
 * @author http://blog.csdn.net/thewaiting
 */

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 04 -29 -下午 5:42
 */
public class StringUtil {

    /**
     * 如果是空返回true
     * @param str
     * @return
     */
    public static boolean isNull(String str){
        return str == null || "".equals(str);
//        if ("".equals(str)||str == null||str.length() <= 0||str.isEmpty()){
//            return true;
//        }
//        return false;
    }
}
