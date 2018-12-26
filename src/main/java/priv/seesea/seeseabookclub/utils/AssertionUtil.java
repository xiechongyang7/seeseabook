package priv.seesea.seeseabookclub.utils;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 05 -26 -下午 2:09
 */


public class AssertionUtil {

    public static boolean isNotNull(Object obj){
        if(obj!=null){
            return true;
        }
        return false;
    }

    public static boolean isValidCollection(Object obj){

        if(obj instanceof List){
            return ((List) obj).size() == 0?false:true;
        }

        if(obj instanceof Map){
            return ((Map) obj).isEmpty()?false:true;
        }
        return false;
    }

}
