package cn.baozcc.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author baozc
 * @date 2019/8/7 4:54 PM
 */
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    /**
     * 转换Json
     * @param object
     * @return json
     * @author baozc
     * @date 2019年08月07日 16:57:31
     */
    public static String format(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("format error: "+ e.getMessage(), e);
            return null;
        }
    }
}
