package com.itheima.wemedia.controller;

import com.itheima.wemedia.dto.WmChannelDto;
import com.itheima.wemedia.service.WmChannelService;
import com.itheima.wemedia.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/channel")
public class WmChannelController {

    @Autowired
    private WmChannelService wmChannelService;


    @PostMapping("/add")
    public ResponseResult add(@RequestBody WmChannelDto dto){

        return wmChannelService.add(dto);

    }


    @PutMapping("/update/{id}")
    public ResponseResult update(@PathVariable("id")Integer id, @RequestBody WmChannelDto dto){
         System.out.println("update"+id);
        return wmChannelService.update(id,dto);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseResult delete(@PathVariable("id") Integer id){

        return wmChannelService.delete(id);
    }


    @GetMapping("/{id}")
    public ResponseResult one(@PathVariable("id") Integer id){
        return wmChannelService.one(id);
    }


    @GetMapping("/list")
    public ResponseResult list(){
        System.out.println("你好");
        return wmChannelService.list();
    }
}
