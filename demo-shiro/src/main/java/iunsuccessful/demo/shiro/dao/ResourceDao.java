package iunsuccessful.demo.shiro.dao;

import iunsuccessful.demo.shiro.entity.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface ResourceDao {
    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    List<Resource> selectByIds(@Param("ids") Set<Integer> ids);

}