package com.yanhuada.dao.mapper;

import com.yanhuada.model.Author;
import com.yanhuada.model.AuthorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthorMapper {
    long countByExample(AuthorExample example);

    int deleteByExample(AuthorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Author record);

    int insertSelective(Author record);

    List<Author> selectByExample(AuthorExample example);

    Author selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByExample(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);
}