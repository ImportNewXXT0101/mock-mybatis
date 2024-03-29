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
package com.xxt.mybatis.excutor;

import java.sql.SQLException;
import java.util.List;

import com.xxt.mybatis.config.MappedStatement;

/**
 *
 * MyBaits核心接口之一，定义了数据库操作最基本的方法，SqlSession的功能都是基于它来实现的
 * 
 */
public interface Executor {


  <E> List<E> query(MappedStatement ms, Object parameter) throws SQLException;


}
