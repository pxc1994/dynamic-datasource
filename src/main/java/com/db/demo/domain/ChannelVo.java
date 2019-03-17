package com.db.demo.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChannelVo {

    private int id;

    private String channel;

    private String signkey;

    private String desc;
}
