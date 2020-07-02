package cn.baozcc.me.oa.model.Base;

import java.util.UUID;

import org.springframework.util.StringUtils;

/**
 * @author baozc
 * @date 2019/8/6 4:02 PM
 */
public class UUIDBean {

    protected String uuid;

    @cn.baozcc.me.annotation.UUID
    public String getUuid() {
        if (StringUtils.isEmpty(uuid)) {
            uuid = UUID.randomUUID().toString().replaceAll("-", "");
        }
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
