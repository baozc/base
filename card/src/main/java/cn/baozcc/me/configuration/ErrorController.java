package cn.baozcc.me.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

/**
 * @author baozc
 * @date 2019/7/22 4:03 PM
 */
@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        ModelAndView modelAndView = new ModelAndView();
        View view = new View() {
            @Override
            public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

            }
        };
        if(statusCode == 401){
            return "/401";
        }else if(statusCode == 404){
            return "404";
        }else if(statusCode == 403){
            return "/403";
        }else{
            return "/500";
        }

    }
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
