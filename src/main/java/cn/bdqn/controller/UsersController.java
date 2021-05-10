package cn.bdqn.controller;

import cn.bdqn.common.Result;
import cn.bdqn.entity.Product;
import cn.bdqn.entity.Sale;
import cn.bdqn.entity.Users;
import cn.bdqn.service.SaleService;
import cn.bdqn.service.UsersService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Users)表控制层
 *
 * @author makejava
 * @since 2021-04-06 09:18:51
 */
@Controller
@RequestMapping("users")
public class UsersController {
    /**
     * 服务对象
     */
    @Resource
    private UsersService usersService;

    @Autowired
    SaleService saleService;


    @ResponseBody
    @RequestMapping("doLogin")
    public Result<Users> doLong(String username,String password){
        Users users = new Users(username,password);
        Result<Users> result = usersService.dologin(users);
        return result;
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("userSession");
        return "Login";
    }


    /*toSaleList*/
    @ResponseBody
    @RequestMapping("/toSaleList")
    public PageInfo toSaleList(@RequestParam(value = "order", required = false) String order,
                                          @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                                          @RequestParam(value = "pageSize", required = false, defaultValue = "4") Integer pageSize){
        order = order == null ? "sale_date" : order;

        PageInfo pageInfo = saleService.queryAllByOrderBy(order, pageNo, pageSize);
        return pageInfo;
    }

    @ResponseBody
    @RequestMapping("/queryAllProduct")
    public List<Product> queryAllProduct(@RequestParam(value = "id", required = false) Integer id){
        List<Product> products = saleService.queryAllProduct(id);
        return products;
    }

    @ResponseBody
    @RequestMapping("doAddSale")
    public Result doAddSale(Sale sale){

        return saleService.insert(sale);
    }





}
