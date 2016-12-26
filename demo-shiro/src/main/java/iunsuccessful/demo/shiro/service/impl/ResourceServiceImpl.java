package iunsuccessful.demo.shiro.service.impl;

import iunsuccessful.demo.shiro.dao.ResourceDao;
import iunsuccessful.demo.shiro.entity.Resource;
import iunsuccessful.demo.shiro.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author LiQZ on 2016/8/25.
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public List<Resource> findByIds(Set<Integer> ids) {
        return resourceDao.selectByIds(ids);
    }
}
