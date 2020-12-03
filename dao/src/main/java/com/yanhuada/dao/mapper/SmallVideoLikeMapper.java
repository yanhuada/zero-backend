package com.yanhuada.dao.mapper;

import com.yanhuada.model.SmallVideoLike;
import com.yanhuada.model.SmallVideoLikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmallVideoLikeMapper {
    long countByExample(SmallVideoLikeExample example);

    int deleteByExample(SmallVideoLikeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmallVideoLike record);

    int insertSelective(SmallVideoLike record);

    List<SmallVideoLike> selectByExample(SmallVideoLikeExample example);

    SmallVideoLike selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmallVideoLike record, @Param("example") SmallVideoLikeExample example);

    int updateByExample(@Param("record") SmallVideoLike record, @Param("example") SmallVideoLikeExample example);

    int updateByPrimaryKeySelective(SmallVideoLike record);

    int updateByPrimaryKey(SmallVideoLike record);
}