/**
 *    Copyright ${license.git.copyrightYears} the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.xxt.mybatis.config;

import java.util.HashMap;
import java.util.Map;

import com.xxt.mybatis.binding.MapperProxyFactory;
import com.xxt.mybatis.session.SqlSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Configuration {
	//记录mapper xml文件存放的位置
	public static final String MAPPER_CONFIG_LOCATION = "config";
	//记录数据库连接信息文件存放位置
	public static final String DB_CONFIG_FILE = "db.properties";
    
	private String dbUrl;

	private String dbUserName;

	private String dbPassword;

	private String dbDriver;

    //mapper xml解析完以后select节点的信息存放在mappedStatements
	protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();
	
	//为mapper接口生成动态代理的方法
	public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
		return MapperProxyFactory.getMapperProxy(sqlSession, type);
	}
	

	public Map<String, MappedStatement> getMappedStatements() {
		return mappedStatements;
	}

	public MappedStatement getMappedStatement(String sourceId) {
		return mappedStatements.get(sourceId);
	}

}
