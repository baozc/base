package cn.baozcc.util.validator;

import java.util.Map;

/**
 * @author baozc
 * @date 2019/7/29 5:42 PM
 */
public class ValidationResult {
    // 校验结果是否有错
    private boolean hasErrors;

    // 校验错误信息
    private Map<String, String> errorMsg;

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    public void setErrorMsg(Map<String, String> errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean isHasErrors() {
        return hasErrors;
    }

    public Map<String, String> getErrorMsg() {
        return errorMsg;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ValidationResult{");
        sb.append("hasErrors=").append(hasErrors);
        sb.append(", errorMsg=").append(errorMsg);
        sb.append('}');
        return sb.toString();
    }
}
