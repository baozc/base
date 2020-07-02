package cn.com.shop;

import cn.com.shop.entity.YggAddress;
import cn.com.shop.mapper.YggAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author baozc
 * @date 2019/11/21 1:46 PM
 */
@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    private YggAddressMapper addressMapper;

    @GetMapping("test")
    public String test(){
        addressMapper.selectByPrimaryKey(1L);
        return "test";
    }
}
