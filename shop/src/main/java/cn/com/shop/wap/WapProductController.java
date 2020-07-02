package cn.com.shop.wap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

import cn.com.easy.exception.BusinessException;
import cn.com.easy.utils.FastJSONUtils;
import cn.com.easy.utils.PageRequest;
import cn.com.easy.utils.PageRequestUtils;
import cn.com.easy.utils.PageUtils;
import cn.com.easy.utils.RequestUtils;
import cn.com.easy.utils.ResponseOutputUtils;
import cn.com.shop.dto.ContentDto;
import cn.com.shop.em.YgProductStatusEnum;
import cn.com.shop.entity.YygContent;
import cn.com.shop.entity.YygProduct;
import cn.com.shop.entity.YygStore;
import cn.com.shop.entity.YygSysDict;
import cn.com.shop.entity.YygUser;
import cn.com.shop.entity.YygUserYg;
import cn.com.shop.entity.YygYgProduct;
import cn.com.shop.mapper.YygContentMapper;
import cn.com.shop.mapper.YygProductMapper;
import cn.com.shop.mapper.YygStoreMapper;
import cn.com.shop.mapper.YygSysDictMapper;
import cn.com.shop.mapper.YygUserMapper;
import cn.com.shop.mapper.YygUserYgMapper;
import cn.com.shop.mapper.YygYgProductMapper;
import cn.com.shop.service.YgBuyService;
import cn.com.shop.utils.DateUtil;
import cn.com.shop.utils.PreventSqlUtil;
import cn.com.shop.utils.StringUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.github.pagehelper.PageHelper;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商品
 * 
 * @author lvzf 2016年8月20日
 * 
 */
@SuppressWarnings("Duplicates")
@Controller
@RequestMapping("/wap/product")
public class WapProductController {

	private Logger logger = LoggerFactory.getLogger(WapProductController.class);

	
	@Value("${istest}")
	private boolean istest = false;
	
	@Value("${img.serverpath}")
	private String serverpath;
	
	/**服务器 */
	@Value("${www.domain}")
	private String host;

	/**
	 * 商品列表
	 * 
	 * @param modelMap
	 * @param req
	 * @param res
	 * @return
	 * @author lvzf 2016年8月22日
	 * @throws IOException 
	 */
	@RequestMapping
	public String list_index(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res, String keyword)  {

		return this.list(modelMap, req, res, 0L, keyword);
	}

	/**
	 * 商品列表
	 * 
	 * @param modelMap
	 * @param req
	 * @param res
	 * @return
	 * @author lvzf 2016年8月22日
	 */
	@RequestMapping("/list/{cateId:\\d+}")
	public String list(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res, @PathVariable Long cateId, String keyword) {
		return this.list(modelMap, req, res, cateId + "-0-1", keyword);
	}

	@Autowired
    private YygSysDictMapper sysDictMapper;

	@Autowired
    private YygYgProductMapper ygProductMapper;

	/**
	 * 商品列表
	 * 
	 * @param modelMap
	 * @param req
	 * @param res
	 * @param list
	 *            分类id-品牌id-排序id
	 * @return
	 * @author lvzf 2016年8月22日
	 */
	@RequestMapping("/list/{list}-{pageNo}")
	public String list(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res, @PathVariable String list, String keyword) {
		// 商品分类
		if(!istest){
			String ua = ((HttpServletRequest) req).getHeader("user-agent").toLowerCase();
			/*if (ua.indexOf("micromessenger") > 0) {// 是微信浏览器
				String url = RequestUtils.getUrl(req);
				WinXinEntity wx = WeixinUtils.getWinXinEntity(url);
				modelMap.addAttribute("wx", wx);	
			}else{
				return null;
			}*/
		}
		
		if(!StringUtils.isEmpty(list)){
			if (Pattern.compile(PreventSqlUtil.GETFILTER).matcher(list).find()) {
				throw new BusinessException("存在非法参数");
			}
		}
		if(!StringUtils.isEmpty(keyword)){
			if (Pattern.compile(PreventSqlUtil.GETFILTER).matcher(keyword).find()) {
				throw new BusinessException("存在非法参数");
			}
		}

        List<YygSysDict> pcates = getYygSysDicts();

        modelMap.addAttribute("pcates", pcates);
        String[] ids = list.split("-");
		if (ids.length < 2) {
			return this.list_index(modelMap, req, res, null);
		}
        getProduct(modelMap, keyword, ids);
        // 查询
		return "/wap/product/product_list";
	}

    @RequestMapping("/listAjax/{list}-{pageNo}")
    public String listJson(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res, @PathVariable String list, String keyword, @PathVariable int pageNo) {
        if(!StringUtil.isBlank(list)){
            if (Pattern.compile(PreventSqlUtil.GETFILTER).matcher(list).find()) {
                throw new BusinessException("存在非法参数");
            }
        }
        if (Pattern.compile(PreventSqlUtil.GETFILTER).matcher(pageNo+"").find()) {
            throw new BusinessException("存在非法参数");
        }

        // 商品分类
        List<YygSysDict> pcates = getYygSysDicts();

        modelMap.addAttribute("pcates", pcates);
        String[] ids = list.split("-");
        if (ids.length < 2) {
            return this.list_index(modelMap, req, res, null);
        }
        getProduct(modelMap, keyword, ids);

        // 查询
        return "/wap/product/product_list_json";
    }

    @RequestMapping("/search")
    public String search(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res, Integer pageNo, String keyword) {
        return this.list_index(modelMap, req, res, keyword);
    }

    /**
     * 商品详情
     */
    @RequestMapping("/{id}/new")
    public String nextview(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res, @PathVariable Long id) {
        YygYgProduct yg = ygProductMapper.selectByPrimaryKey(id);

        QueryWrapper<YygYgProduct> productWrapper = new QueryWrapper<>();
        productWrapper.eq("productId", yg.getProductid());
        productWrapper.eq("status", YgProductStatusEnum.ING.getValue());
        productWrapper.eq("deleteStatus", false);

        YygYgProduct newYgProduct = ygProductMapper.selectOne(productWrapper);

        System.out.println(newYgProduct.getId());
        return this.view(modelMap, req, res, newYgProduct.getId());
    }

    /**
     * 商品详情
     * @author lvzf 2016年8月22日
     */
    @RequestMapping("/{id}/pnew")
    public String productview(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res, @PathVariable Long id) {
        QueryWrapper<YygYgProduct> productWrapper = new QueryWrapper<>();
        productWrapper.eq("productId", id);
        productWrapper.eq("status", YgProductStatusEnum.ING.getValue());
        productWrapper.eq("deleteStatus", false);

        YygYgProduct newYgProduct = ygProductMapper.selectOne(productWrapper);
        if (newYgProduct == null){
            return "/wap/jiexiao/jiexiao";
        }else{
            return this.view(modelMap, req, res, newYgProduct.getId());
        }

    }

    @Autowired
    private YygUserMapper userMapper;

    @Autowired
    private YygUserYgMapper userYgMapper;

    @Autowired
    private YygStoreMapper storeMapper;

    @Autowired
    private YygProductMapper productMapper;

    @Autowired
    private YygContentMapper contentMapper;

    @Autowired
    private YgBuyService ygBuyService;

    /**
     * 夺宝商品详情
     * @author lvzf 2016年8月22日
     */
    @RequestMapping("/{id}")
    public String view(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res, @PathVariable Long id) {

        if(!istest){
            String ua = ((HttpServletRequest) req).getHeader("user-agent").toLowerCase();
            if (ua.indexOf("micromessenger") > 0) {// 是微信浏览器
//				String url = RequestUtils.getUrl(req);
//				WinXinEntity wx = WeixinUtils.getWinXinEntity(url);
//				modelMap.addAttribute("wx", wx);
//				modelMap.addAttribute("url", url);
//				System.out.println(wx.getSignature());
            }else{
                return null;
            }
        }
        YygUser user = RequestUtils.getCurrentUser(req);
        if(user !=null){
            user = userMapper.selectByPrimaryKey(user.getId());
            RequestUtils.setCurrentUser(req, user);
            modelMap.addAttribute("accountBalance", user.getAccountbalance());
        }else{
            modelMap.addAttribute("accountBalance", 0);
        }

        YygYgProduct ygProduct = ygProductMapper.selectByPrimaryKey(id);

        modelMap.addAttribute("product", ygProduct);
        modelMap.addAttribute("weixin_buy", ygProduct.getWeixinBuy());

        YygStore store = storeMapper.selectByPrimaryKey(ygProduct.getStoreid());
        modelMap.addAttribute("store", store);

        if (ygProduct == null) {
            return "/error/404";
        }
        if (ygProduct.getDeletestatus()) {
            return "/error/404";
        }


        QueryWrapper<YygYgProduct> ygProductWrapper = new QueryWrapper<>();
        ygProductWrapper.eq("productId", ygProduct.getProductid());


        // 期数列表
        modelMap.addAttribute("periods", ygProductMapper.selectList(ygProductWrapper));
        // 商品
        YygProduct op = productMapper.selectByPrimaryKey(ygProduct.getProductid());
        if (op != null) {
            // 获取正文
            if (op.getContentid() != null) {
                YygContent ct = contentMapper.selectByPrimaryKey(op.getContentid());
                if (ct != null) {
                    op.setContent(ct.getContent());
                }
            }
        }
        modelMap.addAttribute("totalPeriods", op.getLimitperiods()-ygProduct.getPeriod()+1);
        modelMap.addAttribute("oProduct", op);
        // 本期我的趣购记录

        // 中奖者
        if (ygProduct.getWinuserid() != null) {
            user = userMapper.selectByPrimaryKey(ygProduct.getWinuserid());
        }
        //每期购买记录
        if (user != null) {
            QueryWrapper<YygUserYg> userYgQueryWrapper = new QueryWrapper<>();
            userYgQueryWrapper.eq("ygproductid", ygProduct.getId());
            userYgQueryWrapper.eq("buyUserId", user.getId());

            List<YygUserYg> myBuyRecords = userYgMapper.selectList(userYgQueryWrapper);
            long myTotalBuyNums = 0;
            for (YygUserYg re : myBuyRecords) {
                myTotalBuyNums += re.getBuynum();
            }
            List<String> mBuyNos = Lists.newArrayList();
            for (YygUserYg re : myBuyRecords) {
                mBuyNos.addAll(Lists.newArrayList(re.getBuynos().split(",")));
            }
            if (mBuyNos.size() >= 9) {
                modelMap.addAttribute("mBuyNos", mBuyNos.subList(0, 9));
            } else {
                modelMap.addAttribute("mBuyNos", mBuyNos);
            }

            modelMap.addAttribute("myTotalBuyNums", myTotalBuyNums);
            modelMap.addAttribute("myBuyRecords", myBuyRecords);
        }
        // 获取前50条购买记录
/*		List<UserYgEntity> buyRecords = ygBuyService.getBuyRecords(product, 55);

		long totals = 0;
		for (int i = 0; i < buyRecords.size(); i++) {
			if (i > 49) {
				break;
			}
			String dl = DateUtil.getDateToString(new Date(buyRecords.get(i).getBuyDateLong().longValue()), "HHmmssSSS");
			totals += Long.parseLong(dl);

		}
		modelMap.addAttribute("buyDateTotals", totals);
		modelMap.addAttribute("buyRecords", buyRecords);*/

        modelMap.addAttribute("nowDate", DateUtil.getNowDateToString("yyyyMMdd"));
        if (ygProduct.getStatus() == YgProductStatusEnum.DEL.getValue()) {
            // 下架
            if (ygProduct.getPreygproductid() != null) {
                modelMap.addAttribute("perYgProduct", ygProductMapper.selectByPrimaryKey(ygProduct.getPreygproductid()));
            }
            return "/wap/product/product_detail_down";
        }// 进行中
        else if (ygProduct.getStatus() == YgProductStatusEnum.ING.getValue()) {
            //随机金额
            Random rand = new Random();
            int integral_price1 = rand.nextInt(100)+50;
            int integral_price2 = rand.nextInt(200)+150;
            int integral_price3 = rand.nextInt(200)+200;
            modelMap.addAttribute("integral_price1",integral_price1);
            modelMap.addAttribute("integral_price2",integral_price2);
            modelMap.addAttribute("integral_price3",integral_price3);


            // 获取上一期商品
            if (ygProduct.getPreygproductid() != null) {
                modelMap.addAttribute("perYgProduct", ygProductMapper.selectByPrimaryKey(ygProduct.getPreygproductid()));
            }
            return "/wap/product/product_detail_ing";
        }
        // 即将揭晓
        else if (ygProduct.getStatus() == YgProductStatusEnum.PRE.getValue() || ygProduct.getStatus() == YgProductStatusEnum.DO.getValue()) {

            Long time_long = ygProduct.getPublishdateLong();
            System.out.println(time_long);
            if (time_long < 1000){
                ygBuyService.calWinNo(ygProduct);
            }
            if (time_long < 0){
                time_long = (long) 0;
                ygBuyService.calWinNo(ygProduct);
            }

            QueryWrapper<YygYgProduct> ygProductQueryWrapper = new QueryWrapper<>();
            ygProductQueryWrapper.eq("productId", op.getId());
            ygProductQueryWrapper.eq("period", op.getPeriod());

            modelMap.addAttribute("newYgProduct", ygProductMapper.selectOne(ygProductQueryWrapper));
            modelMap.addAttribute("lose_time", time_long);
            return "/wap/product/product_detail_pre";
        }
        // 已揭晓
        else if (ygProduct.getStatus() == YgProductStatusEnum.END.getValue()) {
            QueryWrapper<YygYgProduct> ygProductQueryWrapper = new QueryWrapper<>();
            ygProductQueryWrapper.eq("productId", op.getId());
            ygProductQueryWrapper.eq("period", op.getPeriod());

            // 获取最新一期商品
            modelMap.addAttribute("newYgProduct", ygProductMapper.selectOne(ygProductQueryWrapper));
            // 中奖号码拆分
            List<Object> winNoChars = Lists.newArrayList();
            if (ygProduct.getWinno() != null) {
                for (int i = 0; i < ygProduct.getWinno().toString().length(); i++) {
                    winNoChars.add(ygProduct.getWinno().toString().charAt(i));
                }
                modelMap.addAttribute("winNoChars", winNoChars);
            }
            // 获取上一期商品
            if (ygProduct.getPreygproductid() != null) {
                modelMap.addAttribute("perYgProduct", ygProductMapper.selectByPrimaryKey(ygProduct.getPreygproductid()));
            }
            return "/wap/product/product_detail_end";
        }
        return "/wap/product/product_detail_ing";
    }

    private List<YygSysDict> getYygSysDicts() {
        QueryWrapper<YygSysDict> wrapper = new QueryWrapper<>();
        wrapper.eq("parentId", YygSysDict.ROOT_PRODUCT);
        wrapper.eq("display", 1);
        wrapper.eq("deleteStatus", 0);
        wrapper.orderByDesc("seqNo");

        return sysDictMapper.selectList(wrapper);
    }


    private void getProduct(ModelMap modelMap, String keyword, String[] ids) {
        String cateId = ids[0];
        modelMap.addAttribute("cateId", cateId);

        Integer orderType = Integer.parseInt(ids[ids.length - 1]);
        modelMap.addAttribute("orderType", orderType);

        QueryWrapper<YygYgProduct> ygProductWrapper = new QueryWrapper<>();

        switch (orderType) {
            case 1:
                ygProductWrapper.orderByDesc("seqNo");
                break;
            case 2:
                ygProductWrapper.orderByDesc("leaveNum");
                break;
            case 3:
                ygProductWrapper.orderByDesc("createTime");
                break;
            case 4:
                ygProductWrapper.orderByAsc("totalNum");
                break;
            case 5:
                ygProductWrapper.orderByDesc("totalNum");
                break;
            default:
                break;
        }

        ygProductWrapper.eq("status", YgProductStatusEnum.ING.getValue());
        ygProductWrapper.eq("deleteStatus", 0);

        PageHelper.startPage(1, 20);

        // 按名称查找
        if (StringUtils.hasText(keyword)) {
            ygProductWrapper.like("name", keyword);
            // 全部
        } else if (!"0".equals(cateId)) {
            ygProductWrapper.eq("cateId", cateId);
        }

        List<YygYgProduct> productList = ygProductMapper.selectList(ygProductWrapper);
        modelMap.addAttribute("page", productList);
    }

    @RequestMapping("/{id}/buyRecord")
    public String buyRecord(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res, @PathVariable Long id, Integer pageNo) {
        modelMap.addAttribute("productId", id);
        return "/wap/product/product_buy_record";
    }

    /**
     * 商品购买记录
     * @author lvzf 2016年9月4日
     */
    @RequestMapping("/{id}/buyRecord/{pageNo}")
    public void buyRecordAjax(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res, @PathVariable Long id, @PathVariable int pageNo) {
        if (pageNo == 0) {
            pageNo = 1;
        }

        QueryWrapper<YygUserYg> userYgQueryWrapper = new QueryWrapper<>();
        userYgQueryWrapper.orderByDesc("createTime");
        userYgQueryWrapper.lambda().eq(YygUserYg::getYgproductid, id);

        PageHelper.startPage(pageNo, 15);

        List<YygUserYg> list = userYgMapper.selectList(userYgQueryWrapper);

        // 按天分组
        Map<String, List<YygUserYg>> resultMap = new LinkedHashMap<>();
        for (YygUserYg u : list) {
            String dl = DateUtil.getDateToString(new Date(u.getBuydatelong()), DateUtil.YMD);
            List<YygUserYg> tl = resultMap.get(dl);
            if (tl == null) {
                tl = Lists.newArrayList();
            }
            tl.add(u);
            resultMap.put(dl, tl);
        }
        String html = "";
        List<ContentDto> contents = Lists.newArrayList();
        for (Map.Entry<String, List<YygUserYg>> map : resultMap.entrySet()) {
            // 日期
            html += "<div class=\"day-box\">";
            html += "<div class=\"record-time\">" + map.getKey() + "</div>";
            html += "<ul class=\"record-list\">";
            // 数组
            List<YygUserYg> lists = resultMap.get(map.getKey());
            if (CollectionUtils.isNotEmpty(list)) {
                for (YygUserYg userYgEntity : lists) {
                    YygUser sEntity = userMapper.selectByPrimaryKey(userYgEntity.getBuyuserid());
                    html += "<li>";
                    String buyUserLogoPath = sEntity.getHeadphotopath();
                    if (org.apache.commons.lang3.StringUtils.contains(buyUserLogoPath, "http") == false) {
                        buyUserLogoPath = "/" + buyUserLogoPath;
                    }
                    html += "<div class=\"pic\"><a><img src=\"" + buyUserLogoPath + "\"> </a> </div>";
                    html += "<div class=\"text\">";
                    html += "<p>"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(userYgEntity.getBuydatelong())) + "</p>";
                    html += "<p class=\"to\"><a class=\"blue\" href=\"#\">" + userYgEntity.getBuyusernickname() + "</a>";
                    html += "参与了<span class=\"color\">" + userYgEntity.getBuynum() + "</span> "+ "</p>";
                    // +userYgEntity.getBuyDate()+ "</p>";
                    html += "</div>";
                    html += "</li>";
                }
            }
            html += "</ul>";
            html += "</div>";
        }
        ContentDto contentDto = new ContentDto();
        contentDto.setContent(html);
        contents.add(contentDto);
        ResponseOutputUtils.renderJson(res, FastJSONUtils.toJsonString(contentDto));
    }

    /**
     * 计算结果
     * @author linwk 2016年9月29日
     */
    @RequestMapping("/{id}/luck")
    public String buyLuck(ModelMap modelMap, HttpServletRequest req, HttpServletResponse res, @PathVariable Long id, Integer pageNo) {
        modelMap.addAttribute("productId", id);
        YygYgProduct product = ygProductMapper.selectByPrimaryKey(id);
        modelMap.addAttribute("product", product);
        // 商品
        YygProduct op = productMapper.selectByPrimaryKey(product.getProductid());
        if (op != null) {
            // 获取正文
            if (op.getContentid() != null) {
                YygContent ct = contentMapper.selectByPrimaryKey(op.getContentid());
                if (ct != null) {
                    op.setContent(ct.getContent());
                }
            }
        }
        modelMap.addAttribute("oProduct", op);
        // 获取前50条购买记录
        List<YygUserYg> buyRecords = ygBuyService.getBuyRecords(product, 50);

        long totals = 0;
        for (int i = 0; i < buyRecords.size(); i++) {
            if (i > 49) {
                break;
            }
            String dl = DateUtil.getDateToString(new Date(buyRecords.get(i).getBuydatelong()), "HHmmssSSS");
            totals += Long.parseLong(dl);

        }
        modelMap.addAttribute("buyDateTotals", totals);
        modelMap.addAttribute("buyRecords", buyRecords);
        return "/wap/product/product_detail_luck";
    }

}
