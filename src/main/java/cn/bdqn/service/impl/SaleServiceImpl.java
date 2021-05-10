package cn.bdqn.service.impl;

import cn.bdqn.common.Result;
import cn.bdqn.common.ResultEnum;
import cn.bdqn.common.ResultUtils;
import cn.bdqn.entity.Product;
import cn.bdqn.entity.Sale;
import cn.bdqn.entity.Users;
import cn.bdqn.mapper.SaleMapper;
import cn.bdqn.service.SaleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (Sale)表服务实现类
 *
 * @author makejava
 * @since 2021-04-06 09:18:51
 */
@Service("saleService")
public class SaleServiceImpl implements SaleService {
    @Resource
    private SaleMapper saleMapper;

    @Override
    public PageInfo queryAllByOrderBy(String order, Integer pageNo, Integer pageSize) {

        Page<Sale> page = PageHelper.startPage(pageNo, pageSize);
        List<Map<String, Object>> maps = saleMapper.queryAllByOrderBy(order);
        PageInfo pageInfo = new PageInfo(maps);

        return pageInfo;
    }

    @Override
    public List<Product> queryAllProduct(Integer id) {
        return saleMapper.queryAllProduct(id);
    }

    @Override
    public Result insert(Sale sale) {

        DecimalFormat df = new DecimalFormat("#.00");
        Double sum = Double.parseDouble(df.format(sale.getPrice() * sale.getQuantity()));
        //添加总价
        sale.setTotalPrice(sum);
        sale.setSaleDate(new Date());


        int num =saleMapper.insert(sale);

        if(num == 1){
            Product product = saleMapper.queryByIdProduct(sale.getProductId());
            //获取新库存：旧的库存-要添加的销售的库存
            int newQuan = (product.getQuantity()-sale.getQuantity());
            //修改选择的商品的库存
            product.setQuantity(newQuan);
            saleMapper.updateProduct(product);

            return ResultUtils.returnSuccess();
        }
        return ResultUtils.returnResult(ResultEnum.FAIL_USER_ADD_ERROR);
    }


}
