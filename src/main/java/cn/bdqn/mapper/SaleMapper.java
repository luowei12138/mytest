package cn.bdqn.mapper;

import cn.bdqn.entity.Product;
import cn.bdqn.entity.Sale;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * (Sale)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-06 09:18:51
 */
@Mapper
@Repository
public interface SaleMapper {

    List<Map<String, Object>> queryAllByOrderBy(String order);

    List<Product> queryAllProduct(@Param("id")Integer id);

    Product queryByIdProduct(Integer id);
    int updateProduct(Product product);
    int insert(Sale sale);

}

