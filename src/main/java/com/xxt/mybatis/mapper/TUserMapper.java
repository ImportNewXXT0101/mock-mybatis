package com.xxt.mybatis.mapper;

import java.util.List;

import com.xxt.mybatis.entity.TUser;

public interface TUserMapper {
	


    TUser selectByPrimaryKey(Integer id);
    
    List<TUser> selectAll();

    
    
    
    
    
}