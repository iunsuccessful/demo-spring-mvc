package iunsuccessful.demo.shiro.service;

import iunsuccessful.demo.shiro.entity.User;

import java.util.Set;

/**
 * @author LiQZ on 2016/8/25.
 */
public interface UserService {

    User selectByUsername(String username);

    /**
     * 当前用户拥有的角色
     */
    Set<Integer> findRoles(String username);

}
