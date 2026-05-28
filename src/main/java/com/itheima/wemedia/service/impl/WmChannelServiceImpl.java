package com.itheima.wemedia.service.impl;

import com.itheima.wemedia.dto.WmChannelDto;
import com.itheima.wemedia.pojo.WmChannel;
import com.itheima.wemedia.service.WmChannelService;
import com.itheima.wemedia.util.AppHttpCodeEnum;
import com.itheima.wemedia.util.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WmChannelServiceImpl implements WmChannelService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ResponseResult add(WmChannelDto dto) {
        WmChannel wmChannel = new WmChannel();
        BeanUtils.copyProperties(dto,wmChannel);
        wmChannel.setCreatedTime(new Date());

        String sql = "insert into wm_channel values (?,?,?,?,?,?,?);";
        Object[] args = {wmChannel.getId(), wmChannel.getName(), wmChannel.getDescription(),
                wmChannel.getIsDefault(), wmChannel.getStatus(), wmChannel.getOrd(), wmChannel.getCreatedTime() };

        int result = jdbcTemplate.update(sql, args); //result表示生效条数，为0表示失败，大于0表示成功
        if(result==0){
            return ResponseResult.errorResult(AppHttpCodeEnum.ADD_ERROR);
        }

        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }


    @Override
    public ResponseResult update(Integer id, WmChannelDto dto) {
        WmChannel wmChannel = new WmChannel();
        BeanUtils.copyProperties(dto,wmChannel);
        wmChannel.setId(id);

        String sql = "update wm_channel set name=?,description=? where id=?";
        Object[] args = {wmChannel.getName(), wmChannel.getDescription(), wmChannel.getId()};

        int result = jdbcTemplate.update(sql, args); //result表示生效条数，为0表示失败，大于0表示成功
        if(result==0){
            return ResponseResult.errorResult(AppHttpCodeEnum.UPDATE_ERROR);
        }

        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }


    @Override
    public ResponseResult delete(Integer id) {

        String sql = "delete from wm_channel where id=?";
        Object[] args = {id};

        int result = jdbcTemplate.update(sql, args); //result表示生效条数，为0表示失败，大于0表示成功
        if(result==0){
            return ResponseResult.errorResult(AppHttpCodeEnum.DELETE_ERROR);
        }

        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }


    @Override
    public ResponseResult one(Integer id) {

        String sql = "select * from wm_channel where id=?";
        Object[] args = {id};

        WmChannel wmChannel = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(WmChannel.class), args);

        return ResponseResult.okResult(wmChannel);
    }


    @Override
    public ResponseResult list() {

        String sql = "select * from wm_channel";

        List<WmChannel> wmChannelList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(WmChannel.class));

        return ResponseResult.okResult(wmChannelList);
    }
}
