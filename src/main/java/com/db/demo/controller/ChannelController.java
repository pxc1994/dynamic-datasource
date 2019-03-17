package com.db.demo.controller;


import com.alibaba.fastjson.JSON;
import com.db.demo.domain.ChannelRequest;
import com.db.demo.service.ChannelService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ChannelController {

    @Resource
    private ChannelService channelService;

    @RequestMapping(value = "/channel",method = RequestMethod.POST)
    public String add(@RequestBody String channel){
        ChannelRequest json = JSON.parseObject(channel,ChannelRequest.class);
        channelService.handle(json);
        return "success";
    }
}
