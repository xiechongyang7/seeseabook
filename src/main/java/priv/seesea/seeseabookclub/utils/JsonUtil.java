package priv.seesea.seeseabookclub.utils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.omg.CORBA.OBJ_ADAPTER;

import java.awt.*;
import java.io.IOException;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 05 -20 -下午 4:51
 */


public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * 将json串转化为指定对象
     * @param json
     * @param type
     * @param <T>
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static <T> T jsonToObject(String json,Class<T> type) throws JsonParseException,JsonMappingException,IOException{
        return mapper.readValue(json,type);
    }

    /**
     * 将对象转化为json串
     * @param obj
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static String objToJson(Object obj) throws JsonGenerationException,JsonMappingException,IOException{
        return mapper.writeValueAsString(obj);
    }
}
