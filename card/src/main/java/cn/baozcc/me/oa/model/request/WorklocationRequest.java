package cn.baozcc.me.oa.model.request;

import javax.validation.constraints.NotNull;

import cn.baozcc.me.annotation.Sig;
import cn.baozcc.me.oa.model.Base.BaseBean;

/**
 * @author baozc
 * @date 2019/8/6 3:54 PM
 */
public class WorklocationRequest extends BaseBean {

    // @NotNull
    // @Sig
    // private String uid;
    //
    // @NotNull
    // @Sig(isSig = true)
    // private String sig;

    @Override
    @NotNull
    @Sig
    public String getUid() {
        return uid;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WorklocationRequest{");
        sb.append("sig='").append(sig).append('\'');
        sb.append(", uid='").append(uid).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
