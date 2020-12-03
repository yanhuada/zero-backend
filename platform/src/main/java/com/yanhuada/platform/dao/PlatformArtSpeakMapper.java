package com.yanhuada.platform.dao;

import com.yanhuada.common.model.PagerDto;
import com.yanhuada.dao.mapper.ArtSpeakMapper;
import com.yanhuada.model.ArtSpeak;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanhuada
 * CREATE ON 2020/8/14 14:29
 */
public interface PlatformArtSpeakMapper extends ArtSpeakMapper {

    /**
     * 查询句子列表
     *
     * @param artSpeakTypeId 类型ID
     * @param content        内容
     * @param ifEnable       是否启动
     * @param page           分页请求参数
     * @return list
     */
    List<ArtSpeak> list(@Param("artSpeakTypeId") Long artSpeakTypeId, @Param("content") String content,
                        @Param("ifEnable") Boolean ifEnable, @Param("page") PagerDto page);

    /**
     * 查询句子数量
     *
     * @param artSpeakTypeId 类型ID
     * @param content        内容
     * @param ifEnable       是否启动
     * @return 数量
     */
    Long total(@Param("artSpeakTypeId") Long artSpeakTypeId, @Param("content") String content,
               @Param("ifEnable") Boolean ifEnable);
}
