package com.db.demo;

import com.db.demo.domain.ChannelRequest;
import com.db.demo.service.ChannelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatasourceApplicationTests {

    @Resource
    private ChannelService channelService;


    @Test
    public void contextLoads() {
//        ChannelRequest req = new ChannelRequest();
//        req.setBrand("KFC");
//        req.setChannel("kfcchannel");
//        req.setKey("kfckey");
//        channelService.handle(req);
    }

}
