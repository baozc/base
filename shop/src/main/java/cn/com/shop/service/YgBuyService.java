package cn.com.shop.service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import cn.baozcc.util.TimeUtils;
import cn.com.shop.em.YgProductStatusEnum;
import cn.com.shop.entity.YygUser;
import cn.com.shop.entity.YygUserYg;
import cn.com.shop.entity.YygYgProduct;
import cn.com.shop.mapper.YygUserMapper;
import cn.com.shop.mapper.YygUserYgMapper;
import cn.com.shop.mapper.YygYgCartMapper;
import cn.com.shop.mapper.YygYgProductMapper;
import cn.com.shop.utils.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户购买记录
 *
 * @author lvzf    2016年8月23日
 */
@Service
public class YgBuyService {
    private Logger logger = LoggerFactory.getLogger(YgBuyService.class);

    public static void main(String[] args) {
        long init = YygYgProduct.INIT_BUY_NO;
        //商品总份数
        long totalNums = 33l;
        //总时间长
        long totaltime = 4287868890L;
        //最后时间的毫秒3位数
        long l3w = 639;
        //最后购买时间长
        long lastBuyDateLong = 143836000;
        //指定中奖号码
        long zd_winNo = 10000022L;
        long index = 0;
        while (1 == 1) {
            if (((totaltime - l3w + index) % totalNums + init + 1) == zd_winNo) {
                //最后下单时间
                System.out.println("t2:" + (lastBuyDateLong + index));
                System.out.println("winno2:" + zd_winNo);
                break;
            }
            index++;
        }
        System.out.println("winno:" + (7325692979L % 33 + 10000001));
        String no = "160718882";
        int last_H = Integer.parseInt(no.substring(0, 2));
        int last_m = Integer.parseInt(no.substring(2, 4));
        int last_s = Integer.parseInt(no.substring(4, 6));
        int last_SSS = Integer.parseInt(no.substring(6));
        DecimalFormat df = new DecimalFormat("00");
        System.out.println("format:" + df.format(1));

    }

    /**
     * 计算中奖号
     *
     * @author lvzf 2016年8月23日
     */
    @Transactional(rollbackFor = Exception.class)
    public void calWinNo(YygYgProduct yg) {
/*		1 奖品的最后一个号码分配完毕后，将公示该分配时间点前本站全部奖品的最后50个参与时间；
		2 将这50个时间的数值进行求和（得出数值A）（每个时间按时、分、秒、毫秒的顺序组合，如20:15:25.362则为201525362）；
		3 为保证公平公正公开，系统还会等待一小段时间，取最近下一期中国福利彩票“老时时彩”的开奖结果（一个五位数值B）；
		4 （数值A+数值B）除以该奖品总需人次得到的余数  + 原始数 10000001，得到最终幸运号码，拥有该幸运号码者，直接获得该奖品。
		注：最后一个号码分配时间距离“老时时彩”最近下一期开奖大于24小时或无法读取老时时彩下一期开奖结果时，默认“老时时彩”开奖结果为00000*/

        //指定中奖号,需修改最后一笔时间，所以最后一笔最好是自己人购买
        //改动作是指定中奖
        if (yg.getZdwin() && yg.getWinno() != null) {
            long init = YygYgProduct.INIT_BUY_NO;
            //商品总份数
            long totalNums = yg.getTotalnum();
            //1)将这50个时间的数值进行求和（得出数值A）
            List<YygUserYg> buyRecords = getBuyRecords(yg, 50);
            //总时间长
            long totaltime = 0;
            //最后时间
            int lastH = 0;
            int lastM = 0;
            int lastS = 0;
            //毫秒
            int lastSss = 0;
            String lastYmd = "";
            long lasttime = 0;
            for (int i = 0; i < buyRecords.size(); i++) {
                String dl = TimeUtils.parse(buyRecords.get(i).getBuydatelong(), "HHmmssSSS");
                logger.error("指定中奖号码时间明细：" + dl + "," + buyRecords.get(i).getBuyusernickname());
                totaltime += Long.parseLong(dl);
                if (i == 0) {
                    lasttime = Long.parseLong(dl);
                    logger.error("指定中奖号码最后一笔时间old：" + dl);
                    lastYmd = TimeUtils.parse(buyRecords.get(i).getBuydatelong(), "HHmmssSSS");
                    lastH = Integer.parseInt(dl.substring(0, 2));
                    lastM = Integer.parseInt(dl.substring(2, 4));
                    lastS = Integer.parseInt(dl.substring(4, 6));
                    lastSss = Integer.parseInt(dl.substring(6));
                }
            }
            logger.error("指定中奖号码old总时间：" + totaltime);
            long zdWinno = yg.getWinno();
            DecimalFormat df2 = new DecimalFormat("00");
            DecimalFormat df3 = new DecimalFormat("000");
            String newTime;
            boolean calErr = false;
            while (true) {
                newTime = df2.format(lastH) + df2.format(lastM) + df2.format(lastS) + df3.format(lastSss);
                if (((totaltime - lasttime + Long.parseLong(newTime)) % totalNums + init + 1) == zdWinno) {
                    logger.error("指定中奖号码：" + zdWinno + ",新总时间：" + (totaltime - lasttime + Long.parseLong(newTime)) + ",最后一笔时间：" + newTime);
                    break;
                }

                lastSss++;
                if (lastSss >= 1000) {
                    lastSss = 0;
                    lastS++;
                }
                if (lastS >= 60) {
                    lastS = 0;
                    lastM++;
                }
                if (lastM >= 60) {
                    lastM = 0;
                    lastH++;
                }
                //找不到就指定中奖
                if (lastH >= 24) {
                    logger.error("指定中奖就算不出结果");
                    calErr = true;
                    break;
                }
            }
            if (calErr) {
                yg.setZdwin(false);
                //this.calWinNo(yg);
                return;
            }
            //修改最后一笔购买时间
            logger.error("指定中奖号码最后一笔时间：" + lastYmd + " " + newTime);
            Date ldate = DateUtil.getStringToDate(lastYmd + " " + newTime, "yyyy-MM-dd HHmmssSSS");
            QueryWrapper<YygUserYg> userYgQueryWrapper = new QueryWrapper<>();
            userYgQueryWrapper.eq("buydatelong", yg.getLastuserbuydatelong());


            List<YygUserYg> userYgs = userYgMapper.selectList(userYgQueryWrapper);

            if (userYgs.size() > 0) {
                YygUserYg uyg = userYgs.get(0);
                uyg.setBuydatelong(ldate.getTime());
                userYgMapper.updateByPrimaryKey(uyg);
            }
            yg.setLastuserbuydatelong(ldate.getTime());
            yg.setWindate(new Date(yg.getLastuserbuydatelong()));
        } else {//不指定中奖，下面是产生随机中奖号码
            //1)将这50个时间的数值进行求和（得出数值A）
            List<YygUserYg> buyRecords = getBuyRecords(yg, 50);
            long totals = 0;
            for (YygUserYg buyRecord : buyRecords) {
                String dl = DateUtil.getDateToString(new Date(buyRecord.getBuydatelong()), "HHmmssSSS");
                totals += Long.parseLong(dl);

            }
            //2)数值A 除以该奖品总需人次得到的余数  + 原始数 10000001
            long winno = totals % yg.getTotalnum() + YygYgProduct.INIT_BUY_NO + 1;
            //判断是否存在相同商品，相同中奖号
/*				boolean b = true;
				while(b){
					int random=(int)(Math.random()*(yg.getTotalNum()/2)-1);
					long winno_new = winno +random;
					if(winno_new <= (10000000+yg.getTotalNum())){
						b = false;
						winno = winno_new;
					}
				}*/

            logger.info("(第" + yg.getPeriod() + "期)" + yg.getName() + ",中奖号码" + winno);
            yg.setWinno(winno);
            System.out.println(winno);
            yg.setWindate(new Date());


        }
        //更新购买记录为中奖
        QueryWrapper<YygUserYg> userYgQueryWrapper = new QueryWrapper<>();
        userYgQueryWrapper.eq("ygProductId", yg.getId());
        userYgQueryWrapper.like("buyNos", yg.getWinno());

        List<YygUserYg> userYgs = userYgMapper.selectList(userYgQueryWrapper);
        if (yg.getStatus() != YgProductStatusEnum.END.getValue()) {
            if (userYgs.size() > 0) {
                YygUserYg uyg = userYgs.get(0);
                yg.setWinuserid(uyg.getBuyuserid());

                Long totalNums = userYgMapper.totalBuyNums(yg.getId(), yg.getWinuserid());
                if (totalNums == null) {
                    totalNums = 0L;
                }
                yg.setWinuserbuynum(totalNums);
                yg.setWinusernickname(uyg.getBuyusernickname());
                yg.setWinuserbuydatelong((uyg.getBuydatelong()));
                yg.setWinuserlogopath(uyg.getBuyuserlogopath());
                yg.setWinuseripaddr((uyg.getIpaddr()));

                YygUserYg winUyg = userYgMapper.selectByPrimaryKey(userYgs.get(0).getId());
                winUyg.setWin(true);
                winUyg.setWinno(yg.getWinno());
                winUyg.setIsSendSms("0");
                userYgMapper.insert(winUyg);
            }
            yg.setStatus(YgProductStatusEnum.END.getValue());
            ygProductMapper.insert(yg);

            //执行成功发送短信给用户
            if (yg.getWinuserid() != null) {
                YygUser userEntity = userMapper.selectByPrimaryKey(yg.getWinuserid());
                YygUserYg winUyg = userYgMapper.selectByPrimaryKey(userYgs.get(0).getId());
                try {
                    // TODO 短信
                    logger.error("---------发短信，暂没有");
                    // SmsServcie.sendWin(userEntity.getMobile(), userEntity.getNickname(), "(第" + yg.getPeriod() + "期)" + yg.getName());
					 /*if("0".equals(winUyg.getIs_send_sms()) || "".equals(winUyg.getIs_send_sms())){
						 winUyg.setIs_send_sms("1");
						 userYgDao.save(winUyg);//更新
					 }*/
                } catch (Exception e) {
                    logger.error("中奖用户(UsedNum=" + yg.getUsednum() + ")(WinUserId=" + yg.getWinuserid() + ")中奖信息,短信发送失败");
                    logger.error(e.getMessage());
                }

            } else {
                System.out.println("发送用户对象id为null");
            }
        }


    }

    @Autowired
    private YygYgProductMapper ygProductMapper;

    @Autowired
    private YygUserMapper userMapper;

    @Autowired
    private YygUserYgMapper userYgMapper;

    @Autowired
    private YygYgCartMapper ygCartMapper;

    public List<YygUserYg> getBuyRecords(YygYgProduct yg, int top) {
        QueryWrapper<YygUserYg> userYgQueryWrapper = new QueryWrapper<>();
        userYgQueryWrapper.eq("buydatelong", yg.getLastuserbuydatelong());
        userYgQueryWrapper.eq("deleteStatus", 0);
        userYgQueryWrapper.orderByDesc("buyDateLong");

        PageHelper.startPage(1, top);

        return userYgMapper.selectList(userYgQueryWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deteleCart(Long userId, List<Long> ygProductIds) {
        ygCartMapper.deleteByUserIdAndYgProductIds(userId, ygProductIds);
    }

    @Transactional
    public void deteleCartBuy(Long userId) {
        ygCartMapper.deleteByUserId(userId);
    }


}
