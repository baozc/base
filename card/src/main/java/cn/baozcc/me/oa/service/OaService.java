package cn.baozcc.me.oa.service;

import java.util.List;

import cn.baozcc.me.model.PasmUser;
import cn.baozcc.me.oa.model.OaBean;
import cn.baozcc.me.oa.model.WorkLocationUserRelation;
import cn.baozcc.me.oa.model.request.AttendanceHistoryRequest;

/**
 * @author baozc
 * @date 2019年08月09日 10:47:34
 */
public interface OaService
{
    /**
     * 保存打卡信息
     * @param oa
     * @author baozc
     * @date 2019年08月09日 10:47:21
     */
    void save(OaBean oa);

    /**
     * 更新打卡信息
     * @param oa 打卡信息
     * @return
     * @author baozc
     * @date 2019年08月09日 10:47:58
     */
    void update(OaBean oa);

    /**
     * 保存异常打卡信息
     * @author baozc
     * @date 2019年08月09日 10:48:12
     */
    void saveExceptionCard(OaBean oaBean);

    /**
     * 查询用户最新的打卡信息
     * @param oa userPhone、timecard、createtime
     * @author baozc
     * @date 2019年08月09日 10:49:10
     */
    OaBean findAttendanceByUser(OaBean oa);

    /**
     * 查询用户一段时间内的打卡记录
     * @param today userPhone、startTime、endTime
     * @return 
     * @author baozc
     * @date 2019年08月09日 10:52:40       
     */
    List<OaBean> findAtendanceHistory(AttendanceHistoryRequest today);

   /**
    * 根据手机号获取pasmUser
    * @param myphone 手机号
    * @return pasmUser
    * @author baozc
    * @date 2019年08月09日 10:53:09
    */
    PasmUser getUserByMyphone(String myphone);

    /**
     * 根据帐号获取pasmUser
     * @param account 帐号
     * @return pasmUser
     * @author baozc
     * @date 2019年08月09日 10:53:09
     */
    PasmUser getUserByAccount(String account);

    /**
     * 根据帐号，查询该用户维护的可打卡地址信息
     * @param account 帐号
     * @return 打卡地址信息
     * @author baozc
     * @date 2019年08月09日 10:54:37
     */
    List<WorkLocationUserRelation> getWorkLocationByAccount(String account);

}
