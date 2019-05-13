package com.xxt.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TUser implements Serializable{
	
    private Integer id;

    private String userName;

    private String realName;

    private String mobile;

    private String email;

    private String note;

}