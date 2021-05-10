package cn.bdqn.service;

import cn.bdqn.common.Result;
import cn.bdqn.entity.Users;

import java.util.List;

/**
 * (Users)表服务接口
 *
 * @author makejava
 * @since 2021-04-06 09:18:51
 */
public interface UsersService {

    Result<Users> dologin(Users users);

}
