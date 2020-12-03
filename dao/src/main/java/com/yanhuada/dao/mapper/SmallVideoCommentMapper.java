package com.yanhuada.dao.mapper;

import com.yanhuada.model.SmallVideoComment;
import com.yanhuada.model.SmallVideoCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmallVideoCommentMapper {
    long countByExample(SmallVideoCommentExample example);

    int deleteByExample(SmallVideoCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmallVideoComment record);

    int insertSelective(SmallVideoComment record);

    List<SmallVideoComment> selectByExample(SmallVideoCommentExample example);

    SmallVideoComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmallVideoComment record, @Param("example") SmallVideoCommentExample example);

    int updateByExample(@Param("record") SmallVideoComment record, @Param("example") SmallVideoCommentExample example);

    int updateByPrimaryKeySelective(SmallVideoComment record);

    int updateByPrimaryKey(SmallVideoComment record);
}