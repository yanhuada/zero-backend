package com.yanhuada.dao.mapper;

import com.yanhuada.model.WeeklyLike;
import com.yanhuada.model.WeeklyLikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeeklyLikeMapper {
    long countByExample(WeeklyLikeExample example);

    int deleteByExample(WeeklyLikeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WeeklyLike record);

    int insertSelective(WeeklyLike record);

    List<WeeklyLike> selectByExample(WeeklyLikeExample example);

    WeeklyLike selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WeeklyLike record, @Param("example") WeeklyLikeExample example);

    int updateByExample(@Param("record") WeeklyLike record, @Param("example") WeeklyLikeExample example);

    int updateByPrimaryKeySelective(WeeklyLike record);

    int updateByPrimaryKey(WeeklyLike record);
}