package com.db.demo.service.impl;

import com.db.demo.annotation.Check;
import com.db.demo.domain.ChannelRequest;
import com.db.demo.mapper.ChannelMapper;
import com.db.demo.service.ChannelService;
import com.db.demo.utils.Converter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChannelServiceImpl implements ChannelService {

    @Resource
    private ChannelMapper channelMapper;

    @Override
    @Check
    public void handle(ChannelRequest request) {
        try{
            channelMapper.add(Converter.channel(request));
            System.out.println("service+++++++++"+request.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
