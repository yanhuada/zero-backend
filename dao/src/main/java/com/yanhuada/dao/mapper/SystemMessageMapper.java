package com.yanhuada.dao.mapper;

import com.yanhuada.model.SystemMessage;
import com.yanhuada.model.SystemMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemMessageMapper {
    long countByExample(SystemMessageExample example);

    int deleteByExample(SystemMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemMessage record);

    int insertSelective(SystemMessage record);

    List<SystemMessage> selectByExample(SystemMessageExample example);

    SystemMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemMessage record, @Param("example") SystemMessageExample example);

    int updateByExample(@Param("record") SystemMessage record, @Param("example") SystemMessageExample example);

    int updateByPrimaryKeySelective(SystemMessage record);

    int updateByPrimaryKey(SystemMessage record);
}