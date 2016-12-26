package iunsuccessful.demo.shiro.service;

import java.util.Set;

/**
 * @author LiQZ on 2016/8/25.
 */
public interface RoleService {

    Set<String> findPermissions(Set<Integer> roleIds);

}
