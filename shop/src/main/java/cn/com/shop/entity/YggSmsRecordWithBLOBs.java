package cn.com.shop.entity;

import java.io.Serializable;

public class YggSmsRecordWithBLOBs extends YggSmsRecord implements Serializable {
    private String content;

    private String body;

    private static final long serialVersionUID = 1L;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }
}