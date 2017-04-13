package com.taotao.controller;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPageHelper {
	@Test
	public void testPageHelper(){
		ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:spring/application-*.xml");
		
	}
}
