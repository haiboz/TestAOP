package com.staticproxy;

import com.common.PeopleSay;
import com.common.StudentSay;

public class TestStatic {

	/**
	 * 分别演示不使用代理和使用代理的用法
	 * @param args
	 */
	public static void main(String[] args) {
		//不需要执行额外方法的用法
		PeopleSay peopleSay = new StudentSay();
		peopleSay.say("zhaohaibo");
		System.out.println();
		//需要执行额外方法的用法
		StaticProxy proxy = new StaticProxy(peopleSay);
		proxy.say("goodnight","hahaha");
		
	}

}
