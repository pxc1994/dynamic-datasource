package com.db.demo.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChannelRequest {

    private String brand;

    private String channel;

    private String key;
}
