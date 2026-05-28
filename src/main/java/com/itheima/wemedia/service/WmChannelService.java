package com.itheima.wemedia.service;

import com.itheima.wemedia.dto.WmChannelDto;
import com.itheima.wemedia.util.ResponseResult;

public interface WmChannelService {

    /**
     * 新增频道
     * @param dto
     * @return
     */
    ResponseResult add(WmChannelDto dto);

    /**
     * 更新频道
     * @param id
     * @param dto
     * @return
     */
    ResponseResult update(Integer id, WmChannelDto dto);


    /**
     * 删除频道
     * @param id
     * @return
     */
    ResponseResult delete(Integer id);


    /**
     * 查询单条频道
     * @param id
     * @return
     */
    ResponseResult one(Integer id);


    /**
     * 查询全部频道列表
     * @return
     */
    ResponseResult list();
}
