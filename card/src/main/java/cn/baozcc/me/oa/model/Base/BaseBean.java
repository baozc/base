package cn.baozcc.me.oa.model.Base;

import javax.validation.constraints.NotNull;

import cn.baozcc.me.annotation.Sig;
import cn.baozcc.me.configuration.constant.Constants;
import cn.baozcc.util.Des3Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * @author baozc
 * @date 2019/8/5 4:12 PM
 */
public class BaseBean extends UUIDBean{

    private Logger logger = LoggerFactory.getLogger(BaseBean.class);

    @NotNull
    @Sig(isSig = true)
    protected String sig;

    protected String uid;

    protected String umobile;
    protected String userPhone;
    protected String os;

    public String getUserPhone() {
        if (StringUtils.hasText(userPhone)) {
            return userPhone;
        }

        try {
            if (Constants.config_app_mobile.equals(Constants.config_app_getInfoType)) {
                String umobile = Des3Util.decode(this.umobile);
                userPhone = umobile.substring(0, umobile.lastIndexOf("_"));
                logger.info(getUuid() + ", 根据手机号记录,解密完成umobile:      " + umobile);
            } else {
                String uid = Des3Util.decode(this.uid);
                userPhone = uid.substring(0, uid.lastIndexOf("_"));
                logger.info(getUuid() + ", 根据账号记录,解密完成uid:     " + uid);
            }
        } catch (Exception e) {
            logger.error(getUuid() + ", parse userPhone error " + e.getMessage());
        }

        return userPhone;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUmobile() {
        return umobile;
    }

    public void setUmobile(String umobile) {
        this.umobile = umobile;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}
