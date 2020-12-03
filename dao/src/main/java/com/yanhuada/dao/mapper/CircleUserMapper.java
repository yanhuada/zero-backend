package com.yanhuada.dao.mapper;

import com.yanhuada.model.CircleUser;
import com.yanhuada.model.CircleUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CircleUserMapper {
    long countByExample(CircleUserExample example);

    int deleteByExample(CircleUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CircleUser record);

    int insertSelective(CircleUser record);

    List<CircleUser> selectByExample(CircleUserExample example);

    CircleUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CircleUser record, @Param("example") CircleUserExample example);

    int updateByExample(@Param("record") CircleUser record, @Param("example") CircleUserExample example);

    int updateByPrimaryKeySelective(CircleUser record);

    int updateByPrimaryKey(CircleUser record);
}