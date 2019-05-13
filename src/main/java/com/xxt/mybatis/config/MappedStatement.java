package com.xxt.mybatis.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MappedStatement {
	
	private String namespace;
	
	private String sourceId;
	
	private String sql;
	
	private String resultType;


	
	

}
