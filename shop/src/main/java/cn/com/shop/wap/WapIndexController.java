package cn.com.shop.wap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import cn.com.easy.utils.ResponseOutputUtils;
import cn.com.shop.configuration.YygConstants;
import cn.com.shop.mapper.YygYgProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * pc首页
 * 
 * @author lvzf 2016年8月20日
 * 
 */
@Slf4j
@Controller
@RequestMapping("/wap")
public class WapIndexController {

    @Autowired
    private YygYgProductMapper productMapper;

	/**
	 * 统计趣购份数
	 * 
	 * @param modelMap
	 * @param req
	 * @param res
	 * @return
	 * @author lvzf 2016年8月20日
	 */
	@RequestMapping("/buyCount.html")
	public String buyCount(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute(YygConstants.KEY_SESSION_BUY_NUMS, totalBuyNums());
		return "redirect:/";
	}

    /**
     * 统计趣购份数
     *
     * @param res
     * @author lvzf 2016年8月20日
     */
    @RequestMapping("/buyCount.json")
    public void buyCount(HttpServletRequest req, HttpServletResponse res) {
        try {
            String count = totalBuyNums();
            req.getSession().setAttribute(YygConstants.KEY_SESSION_BUY_NUMS, count);
            ResponseOutputUtils.renderJson(res, count);
        } catch (Exception ex) {
            ResponseOutputUtils.renderJson(res, "");
            log.error(ex.getMessage(), ex);
        }
    }

    /**
     * 统计趣购份数
     *
     * @return
     * @author lvzf 2016年8月20日
     */
    public String totalBuyNums() {
        Integer count = productMapper.selectCount(null);
        if (count == null) {
            count = 1;
        }
        DecimalFormat df = new DecimalFormat("000000000");
        String val = df.format(BigDecimal.valueOf(count.longValue() * 27));
        return val;
    }

}
