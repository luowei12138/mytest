package cn.bdqn.mapper;

import cn.bdqn.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Users)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-06 09:18:51
 */
@Mapper
@Repository
public interface UsersMapper {

    /**
     * @Author: hah
     * @Date: 2021-04-06 09:04:38
     * @Description: 根据userName，查询用户
     * @param userName 用户名
     * @return cn.bdqn.entity.Users
     **/
    Users doLong(@Param("userName")String userName);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Users queryById(Integer id);



}

