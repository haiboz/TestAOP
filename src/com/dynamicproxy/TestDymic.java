package com.dynamicproxy;

import com.common.PeopleSay;
import com.common.StudentSay;

public class TestDymic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//绑定代理 这种方法会在所有的方法上面加上切面方法
		PeopleSay student = (PeopleSay) new DynamicProxy().bind(new StudentSay());
		student.say("say hello.");
		student.cry();
		
	}

}
