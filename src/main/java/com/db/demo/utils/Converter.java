package com.db.demo.utils;

import com.db.demo.domain.ChannelRequest;
import com.db.demo.domain.ChannelVo;

public class Converter {

    public static ChannelVo channel(ChannelRequest req){
        ChannelVo vo = new ChannelVo();
        vo.setChannel(req.getChannel());
        vo.setSignkey(req.getKey());
        return vo;
    }
}
