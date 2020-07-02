package cn.baozcc.oauth.controller;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baozc
 * @date 2020/6/2 12:10 AM
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/me")
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping("/{name}")
    public String getUserName(@PathVariable String name) {
        SecurityContext context = SecurityContextHolder.getContext();
        context
                .getAuthentication().getPrincipal();
        return "hello,"+ name;
    }
}
