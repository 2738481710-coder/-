package com.itheima.wemedia.mapper;

import com.itheima.wemedia.pojo.WmChannel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WmChannelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WmChannel record);

    int insertSelective(WmChannel record);

    WmChannel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WmChannel record);

    int updateByPrimaryKey(WmChannel record);
}