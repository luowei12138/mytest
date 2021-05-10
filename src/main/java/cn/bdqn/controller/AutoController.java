package cn.bdqn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package: cn.bdqn.controller
 * @Description: 公共类
 * @Author hah
 * @Create 2021年05月06日 14时25分20秒
 */
@Controller
public class AutoController {

    @RequestMapping("/")
    public String index(){
        return "Login";
    }

    @RequestMapping("/index")
    public String shouye(){
        return "index";
    }
}
