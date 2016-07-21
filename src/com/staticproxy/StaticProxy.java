package com.staticproxy;

import com.common.PeopleSay;

/**
 * 静态代理类：包含对真是对象的引用，并提供和真实对象相同的接口
 * @author 浮生若梦
 *
 */
public class StaticProxy implements PeopleSay {
	
	private PeopleSay peopleSay;
	
	public StaticProxy(PeopleSay peopleSay){
		super();
		this.peopleSay = peopleSay;
	}

	@Override
	public void say(String msg) {
		peopleSay.say(msg);
		
	}
	
	public void say(String name,String msg){
		System.out.println("进入代理方法执行");
		peopleSay.say(msg);
		this.sing();
	}
	
	public void sing(){
		System.out.println("I'm singing.");
	}

	@Override
	public void cry() {
		
		
	}

}
