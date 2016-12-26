package iunsuccessful.demo.shiro.service.impl;

import iunsuccessful.demo.shiro.common.utils.StringUtils;
import iunsuccessful.demo.shiro.dao.ResourceDao;
import iunsuccessful.demo.shiro.dao.RoleDao;
import iunsuccessful.demo.shiro.entity.Resource;
import iunsuccessful.demo.shiro.entity.Role;
import iunsuccessful.demo.shiro.service.ResourceService;
import iunsuccessful.demo.shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author LiQZ on 2016/8/25.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private ResourceService resourceService;

    /**
     * 查询这些角色拥有的资源
     */
    @Override
    public Set<String> findPermissions(Set<Integer> roleIds) {
        Set<Integer> resourceIds = findResourceIds(roleIds);
        List<Resource> resources = resourceService.findByIds(resourceIds);
        Set<String> permissions = new HashSet<>();
        for (Resource resource :resources) {
            permissions.add(resource.getPermission());
        }
        return permissions;
    }

    private Set<Integer> findResourceIds(Set<Integer> roleIds) {
        List<Role> roleList = roleDao.selectByIds(roleIds);
        StringBuilder builder = new StringBuilder();
        for (Role role :roleList) {
            builder.append(role.getResourceIds()).append(",");
        }
        return StringUtils.splitIds(builder.toString());
    }

}
