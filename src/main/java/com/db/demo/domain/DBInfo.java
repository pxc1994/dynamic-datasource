package com.db.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DBInfo {

    private String id;

    private String brand;

    private String url;

    private String username;

    private String password;

    private String driver;
}
