package iunsuccessful.demo.shiro.service.impl;

import iunsuccessful.demo.shiro.common.utils.StringUtils;
import iunsuccessful.demo.shiro.dao.UserDao;
import iunsuccessful.demo.shiro.entity.User;
import iunsuccessful.demo.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @author LiQZ on 2016/8/25.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectByUsername(String username) {
        checkArgument(StringUtils.isNotBlank(username), "用户名为空");
        return userDao.selectByUsername(username);
    }

    @Override
    public Set<Integer> findRoles(String username) {
        User user = selectByUsername(username);
        String roleIds = user.getRoleIds();
        return StringUtils.splitIds(roleIds);
    }
}
