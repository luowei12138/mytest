package cn.bdqn.service;

import cn.bdqn.common.Result;
import cn.bdqn.entity.Product;
import cn.bdqn.entity.Sale;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (Sale)表服务接口
 *
 * @author makejava
 * @since 2021-04-06 09:18:51
 */
public interface SaleService {

    PageInfo queryAllByOrderBy(String order, Integer pageNo, Integer pageSize);

    List<Product> queryAllProduct(Integer id);

    Result insert(Sale sale);

}
