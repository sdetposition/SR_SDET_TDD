package com.parabank.commons;

import com.parabank.TestContext;

public class Test2 {

	static UserInfo uInfo;
	
	Test1 t1 = new Test1();

	public static void main(String[] args) {
		
		Test1.test();

		System.out.println(uInfo.getUser());
		System.out.println(uInfo.getPwd());

	}

}
