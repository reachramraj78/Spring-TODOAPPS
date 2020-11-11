package com.balaji.todoapp.utiltest;

import org.junit.Test;

import com.balaji.todoapp.util.ConnectionUtil;

public class ConnectionUtilTest {
	
	@Test
	public void connectionTest() {
		System.out.println(ConnectionUtil.getConnection());
	}

}
