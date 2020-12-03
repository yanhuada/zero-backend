package com.yanhuada.dao.mapper;

import com.yanhuada.model.SmallVideo;
import com.yanhuada.model.SmallVideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmallVideoMapper {
    long countByExample(SmallVideoExample example);

    int deleteByExample(SmallVideoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmallVideo record);

    int insertSelective(SmallVideo record);

    List<SmallVideo> selectByExample(SmallVideoExample example);

    SmallVideo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmallVideo record, @Param("example") SmallVideoExample example);

    int updateByExample(@Param("record") SmallVideo record, @Param("example") SmallVideoExample example);

    int updateByPrimaryKeySelective(SmallVideo record);

    int updateByPrimaryKey(SmallVideo record);
}