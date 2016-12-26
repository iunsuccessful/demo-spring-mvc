package iunsuccessful.demo.shiro.service;

import iunsuccessful.demo.shiro.entity.Resource;

import java.util.List;
import java.util.Set;

/**
 * @author LiQZ on 2016/8/25.
 */
public interface ResourceService {

    List<Resource> findByIds(Set<Integer> ids);

}
