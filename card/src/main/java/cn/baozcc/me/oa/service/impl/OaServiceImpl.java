package cn.baozcc.me.oa.service.impl;

import java.util.List;
import java.util.UUID;

import cn.baozcc.me.model.PasmUser;
import cn.baozcc.me.oa.dao.OaDao;
import cn.baozcc.me.oa.model.OaBean;
import cn.baozcc.me.oa.model.WorkLocationUserRelation;
import cn.baozcc.me.oa.model.request.AttendanceHistoryRequest;
import cn.baozcc.me.oa.service.OaService;
import cn.baozcc.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author baozc
 * @date 2019/7/29 1:28 PM
 */
@Service
@Transactional
public class OaServiceImpl implements OaService {

    @Autowired
    private OaDao oaDao;

    @Override
    public void save(OaBean oa) {
        oa.setCreatetime(TimeUtils.formateSecond());
        oa.setCreatetimeMillisecond(System.currentTimeMillis()+"");
        oa.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        oaDao.saveAttendance(oa);
    }

    @Override
    public void update(OaBean oa) {
        oa.setCreatetime(TimeUtils.formateSecond());
        oa.setCreatetimeMillisecond(System.currentTimeMillis()+"");
        oaDao.updateAttendance(oa);
    }

    @Override
    public void saveExceptionCard(OaBean oaBean) {
        oaBean.setCreatetime(TimeUtils.formateSecond());
        oaBean.setCreatetimeMillisecond(System.currentTimeMillis()+"");
        oaDao.saveExceptionCard(oaBean);
    }

    @Override
    public OaBean findAttendanceByUser(OaBean oa) {
        oa.setCreatetime(TimeUtils.formateDate());
        return oaDao.findAttendanceByUser(oa);
    }

    @Override
    public List<OaBean> findAtendanceHistory(AttendanceHistoryRequest today) {
        return oaDao.findAtendanceHistory(today);
    }

    @Override
    public PasmUser getUserByMyphone(String myphone) {
        List<PasmUser> list = oaDao.findByUserPhone(myphone);
        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

    @Override
    public PasmUser getUserByAccount(String account) {
        List<PasmUser> list = oaDao.findByAccount(account);
        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

    @Override
    public List<WorkLocationUserRelation> getWorkLocationByAccount(String account) {
        return oaDao.findWorklocationByAccount(account);
    }

}
