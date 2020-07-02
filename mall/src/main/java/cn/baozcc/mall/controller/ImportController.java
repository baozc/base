package cn.baozcc.mall.controller;

import java.util.HashMap;
import java.util.Map;

import cn.baozcc.mall.entity.A;
import cn.baozcc.mall.entity.B;
import cn.baozcc.mall.entity.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baozc
 * @date 2019/11/3 5:43 PM
 */
@RestController
@RequestMapping("import")
public class ImportController {

    @Autowired
    private A a;

    @Autowired
    private B b;

    @Autowired
    private C c;

    @GetMapping
    public Map<String, Object> index(){
        Map<String, Object> map = new HashMap<>();
        map.put("a", a);
        map.put("b", b);
        map.put("c", c);

        return map;
    }
}
