package com.xxt.mybatis.binding;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;

import com.xxt.mybatis.session.SqlSession;

public class MapperProxy<T> implements InvocationHandler {

	private SqlSession sqlSession;
	
	private final Class<T> mapperInterface;
	

	public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
		super();
		this.sqlSession = sqlSession;
		this.mapperInterface = mapperInterface;
	}

	private <T> boolean isCollection(Class<T> type) {
		return Collection.class.isAssignableFrom(type);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (Object.class.equals(method.getDeclaringClass())) {// 如果是Object本身的方法不增强
			return method.invoke(this, args);
		}
		// 获取方法的返回参数class对象
		Class<?> returnType = method.getReturnType();
		Object ret ;
		// 根据不同的返回参数类型调用不同的sqlsession不同的方法
		if (isCollection(returnType)) {
			ret = sqlSession.selectList(mapperInterface.getName()+"."+ method.getName(), args);
		} else {
			ret = sqlSession.selectOne(mapperInterface.getName()+"."+ method.getName(), args);
		}

		return ret;
	}

}
