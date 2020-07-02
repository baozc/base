package cn.com.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author baozc
 * @date 2019/11/21 12:50 PM
 */
@Controller
@RequestMapping
// @EnableWebMvc
@SpringBootApplication
@MapperScan({"cn.com.shop.mapper"})
public class ShopApplication {

    public static void main(String[] args){
        SpringApplication.run(ShopApplication.class, args);
    }

    @GetMapping("test")
    public String test(Model model){
        return "test";
    }
}
