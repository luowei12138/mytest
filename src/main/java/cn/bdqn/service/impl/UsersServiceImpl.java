package cn.bdqn.service.impl;

import cn.bdqn.common.Result;
import cn.bdqn.common.ResultEnum;
import cn.bdqn.common.ResultUtils;
import cn.bdqn.entity.Users;
import cn.bdqn.mapper.UsersMapper;
import cn.bdqn.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * (Users)表服务实现类
 *
 * @author makejava
 * @since 2021-04-06 09:18:51
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;

    @Override
    public Result<Users> dologin(Users users) {
        Users newUsers = usersMapper.doLong(users.getUserName());
        if(ObjectUtils.isEmpty(newUsers)){
            //返回用户不存在
            return ResultUtils.returnResult(ResultEnum.FAIL_USER_ACCOUNT_ISNULL);
        }
        else if(newUsers.getPassword().equals(users.getPassword())){
            //返回成功！
            return ResultUtils.returnDataSuccess(newUsers);
        }
        //返回用户，或密码错误
        return ResultUtils.returnResult(ResultEnum. FAIL_USER_LOGIN_ERROR);
    }

}
