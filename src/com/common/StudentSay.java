package com.common;

public class StudentSay implements PeopleSay{
	@Override
	public void say(String msg){
		System.out.println("I'm a student."+msg);
	}
	
	public void study(){
		System.out.println("I'm read a book.");
	}

	@Override
	public void cry() {
		System.out.println("I'm crying.");
	}
}
