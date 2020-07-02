package cn.com.shop.wap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.regex.Pattern;

import cn.com.easy.utils.FastJSONUtils;
import cn.com.easy.utils.ResponseOutputUtils;
import cn.com.shop.dto.ContentDto;
import cn.com.shop.em.YgProductStatusEnum;
import cn.com.shop.entity.YygYgProduct;
import cn.com.shop.mapper.YygYgProductMapper;
import cn.com.shop.utils.PreventSqlUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 最新揭晓
 * 
 * @author linwk 2016年9月20日
 * 
 */
@Slf4j
@Controller
@RequestMapping("/wap/win")
public class WapJiexiaoController {

    @Autowired
    private YygYgProductMapper ygProductMapper;

	/** 前端公共服务 */
	// @Autowired
	// private CommonService frontCommonService;
    //
	// /** 趣购 */
	// @Autowired
	// private YgProductDao ygProductDao;
	// @Autowired
	// private UserDao userDao;
	// @RequestMapping
    @GetMapping
	public String index(Model model, HttpServletRequest req, HttpServletResponse res) {
		// 删除保存的信息
		String html="";
		html +="<script id=\"index_mobileAjaxTmpl\" type=\"text/html\">";
		html +=" <li class=\"item-djx\" id=\"itemDjx<%=m.buy_id%>\">";
		html +=" <em><a href=\"/product/<%=m.buy_id%>.html\"><img width=\"93\" src=\"<%=m.thumb200w_0%>\" /></a></em>";
		html +=" <div class=\"new-index-3\">";
		html +=" <a href=\"/product/<%=m.buy_id%>.html\">";
		html +="<em style=\"float: none;width: auto;margin-bottom: 3px;display: block;\">";
		html +="<font class=\"lefttime\"><font id=\"leftTimeJx<%=m.buy_id%>\"></font></font>";
		html +="<font class=\"jx-ing\" style=\"display: none;\"><%=data.unit_kaijiang%>计算中...</font>";
		html +="</em>";
		html +="<%=m.qishu_name%>";
		html +="<% if(m.title){ %><%=m.title%>";
		html +="<% }else{ %><%=m.goods_name%>";
		html +="<% } %>";
		html +="</a>";
		html +="</div>";
		html +="</li>";
		html +="</script>";

		html +="<script id=\"mobileAjaxTmpl\" type=\"text/html\">";
		html +="<li class=\"ui-clr item-djx\" id=\"itemDjx<%=m.buy_id%>\" q=\"<%=m.buy_id%>\">";
		html +=" <div class=\"pic\" style=\"overflow: hidden; height: 100px; font-size: 1.3rem\">";
		 html +="<a href=\"/product/<%=m.buy_id%>.html\"><img src=\"<%=m.thumb200w_0%>\" style=\"height: 100px; width: 110px; position: absolute; \" /></a><em></em>";
		 html +="</div>";
		 html +="<div class=\"info\">";
		 html +="<p class=\"title \"><a href=\"/product/<%=m.buy_id%>.html\">";
		html +=" <%=m.qishu_name%>";
		 html +="<% if(m.title){ %><%=m.title%>";
		 html +="<% }else{ %><%=m.goods_name%>";
		 html +="<% } %>";
		 html +="</a></p>";
		 html +="<p class=\"price itemP\">";
		 html +="总&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;需：<span class=\"color\"><%=m.need_num%></span>";
		 html +="</p>";
		 html +="<p>";
		 html +="<p class=\"count\">";
		 html +="<i class=\"ap-icon icon-count\"></i>";
		 html +="<font id=\"leftTimeJx<%=m.buy_id%>\">加载中...</font>";
		 html +="</p>";
		 html +="<a href=\"/product/<%=m.buy_id%>/new.php\" class=\"buynext\" style=\"margin-top: 5px;\">参与下期</a>";
		 html +="</p>";
		 html +="<div class=\"count jx-ing \" style=\"display: none;\">计算中...</div>";
		 html +="</div>";
		 html +="</li>";
		html +="</script>";

		html +="<script id=\"index_mobileTmpl\" type=\"text/html\">";
		html +=" <li class=\"item-db\">";
		 html +="<em><a href=\"/product/<%=m.buy_id%>.html\"><img width=\"93\" src=\"<%=m.thumb200w_0%>\" /></a></em>";
		 html +="<div class=\"new-index-2\">";
		 html +="<span><a href=\"/product/<%=m.buy_id%>.html\">";
		 html +="<%=m.qishu_name%>";
		 html +="<% if(m.goods_name){ %><%=m.goods_name%>";
		 html +="<% }else{ %><%=m.title%>";
		 html +="<% } %>";
		 html +="</a></span>";
		 html +="<p>获&nbsp;&nbsp;得&nbsp;&nbsp;者：<a href=\"/minfo?id=<%=m.mid%>#dbCod\"><%=m.user_name_nick%></a></p>";
		html +=" </div>";
		 html +="</li>";
		html +="</script>";

		html +="<script id=\"mobileTmpl\" type=\"text/html\">";
		 html +="<li class=\"item ui-clr item-db\">";
		 html +="<div class=\"pic\" style=\"overflow: hidden; height: 100px; font-size: 1.3rem\">";
		 html +="<a href=\"/product/<%=m.buy_id%>.html\"><img src=\"<%=m.thumb200w_0%>\" style=\"height: 100px; width: 110px; position: absolute;\"/></a>";
		html +=" <p class=\"timeago\"><span><%=m.end_time_format%></span></p>";
		 html +="</div>";
		html +=" <div class=\"info\">";
		 
		html +=" <p class=\"title \" style=\"border-bottom: 0\"><a href=\"/product/<%=m.buy_id%>.html\">";
		 html +="<%=m.qishu_name%>";
		 html +="<% if(m.title){ %><%=m.title%>";
		 html +="<% }else{ %><%=m.goods_name%>";
		 html +="<% } %>";
		 html +="</a></p>";
		html +=" <p class=\" itemP\">参&nbsp;&nbsp;&nbsp;&nbsp;与：<span class=\"color\"><%=m.qty%></span></p>";
		 html +="<p>幸运码号：<span class=\"color \"><%=m.luck_code%></span></p>";

		html +=" <p class=\" itemP\">获&nbsp;&nbsp;得&nbsp;&nbsp;者：<a href=\"#\" class=\"color\"><%=m.user_name_nick%></a><a href=\"/product/<%=m.buy_id%>/new.php\" class=\"buynext\">参与下期</a></p>";

		 html +="</div>";
		 html +="</li>";
		html +="</script>";
		String ua = req.getHeader("user-agent").toLowerCase();
		model.addAttribute("html", html);

		log.info(html);
		return "/wap/jiexiao/jiexiao";
	}

    @PostMapping("/{pageNo}")
    public void list(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res,
                     @PathVariable("pageNo") Integer pageNo, Integer amount) {
        if (Pattern.compile(PreventSqlUtil.GETFILTER).matcher(pageNo+"").find()) {
            throw new RuntimeException("存在非法参数");
        }
        if (Pattern.compile(PreventSqlUtil.GETFILTER).matcher(amount+"").find()) {
            throw new RuntimeException("存在非法参数");
        }

        QueryWrapper<YygYgProduct> wrapper = new QueryWrapper<>();
        wrapper.in("status", YgProductStatusEnum.END.getValue());
        wrapper.orderByDesc("lastUserBuyDateLong");

        PageHelper.startPage(pageNo, amount);
        List<YygYgProduct> list = ygProductMapper.selectList(wrapper);

        Page<YygYgProduct> page = (Page)list;
        List<ContentDto> contents = Lists.newArrayList();

        QueryWrapper<YygYgProduct> wrapper1 = new QueryWrapper<>();
        list.forEach(product -> {
            String str_html ="";
            String html = "";

            wrapper1.eq("productId", product.getProductid());
            wrapper1.eq("status", YgProductStatusEnum.ING.getValue());
            wrapper1.eq("deleteStatus", false);

            YygYgProduct newYgProduct = ygProductMapper.selectOne(wrapper1);

            if (newYgProduct!=null){
                str_html +="<a href=\"/product/" + newYgProduct.getId() + ".php\" class=\"buynext\">参与下期</a>";
            }
            String time_html="";
            Long time_long = product.getPublishdateLong()*-1/60000;
            if (time_long<60){
                time_html +=time_long+"分钟前";
            }else if (time_long/60<24){
                time_html +=time_long/60+"小时前";
            }else {
                time_html +=time_long/1440+"天前";
            }
            html += "<li class=\"item ui-clr item-db\">";
            html += "<div class=\"pic\" style=\"overflow: hidden; height: 100px; font-size: 1.3rem\">";
            html += " <a href=\"/wap/product/" + product.getId() + "\"><img src=\"" + product.getLogopath() + "\" style=\"height: 100px; width: 110px; position: absolute;\"></a>";
            html += "<p class=\"timeago\"><span>"+time_html+"</span></p>";
            html += "</div>";
            html += "<div class=\"info\">";
            html += "<p class=\"title\" style=\"border-bottom: 0; padding-bottom: 0\"><a href=\"/wap/product/" + product.getId() + "\">(第" + product.getPeriod()+"期)" + product.getName() ;
            html += "</a></p>";
            html += "<p class=\"itemP\">参与人数：<span class=\"\">" + product.getUsednum() + "</span></p>";
            html += "<p class=\"\" style=\"font-weight: blod;\">幸运号码：<span class=\"color\">" + product.getWinno() + "</span></p>";
            html += "<p class=\"itemP\"><span>幸运用户</span>：<a href=\"/win\" class=\"color\">" + product.getWinusernickname() + "</a>"+str_html+"</p>";
            html += "<div></div>";
            html += "</div>";
            html += "</li>";


            ContentDto contentDto = new ContentDto();
            contentDto.setContent(html);
            contents.add(contentDto);
        });

        ResponseOutputUtils.renderJson(res, FastJSONUtils.toJsonString(contents));
    }

}
