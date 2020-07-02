package cn.baozcc.me.oa.model;

import javax.validation.constraints.NotNull;

import cn.baozcc.me.annotation.Sig;

/**
 * @author baozc
 * @date 2019/8/6 4:52 PM
 */
public class OutSideOaBean extends OaBean {

    @NotNull
    @Sig
    @Override
    public String getReason() {
        return super.getReason();
    }

    public static void main(String[] args){

    }
}
