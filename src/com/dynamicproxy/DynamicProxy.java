package com.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 演示动态代理类
 * @author 浮生若梦
 *
 */
public class DynamicProxy implements InvocationHandler{

	/**
	 * 需要代理的目标类
	 */
	private Object target;
	
	/**
	 * 写法固定，AOP专用：绑定委托对象，并返回一个代理类
	 * @param target
	 * @return
	 */
	public Object bind(Object target){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	/**
	 * @param proxy
	 * 		target:被代理的对象
	 * @param method
	 * 		method:要调用的方法
	 * @param args
	 * 		args:放法调用时要传的参数
	 * 		
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		//切面之前执行
		System.out.println("切面之前执行");
		//执行业务
		result = method.invoke(target, args);
		//切面之后执行
		System.out.println("切面之后执行");
		return result;
	}

}
