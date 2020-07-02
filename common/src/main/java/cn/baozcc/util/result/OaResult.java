package cn.baozcc.util.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import cn.baozcc.util.json.JsonUtil;

/**
 * @author baozc
 * @date 2019/8/9 9:28 AM
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OaResult {

    public OaResult(String result, String description) {
        this.result = result;
        this.description = description;
    }

    public OaResult(String result, String description, Object jsonData) {
        this.result = result;
        this.description = description;
        this.jsonData = jsonData;
    }

    private String result;
    private String description;
    private Object jsonData;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getJsonData() {
        return jsonData;
    }

    public void setJsonData(Object jsonData) {
        this.jsonData = jsonData;
    }

    @Override
    public String toString() {
        return JsonUtil.format(this);
    }
}
