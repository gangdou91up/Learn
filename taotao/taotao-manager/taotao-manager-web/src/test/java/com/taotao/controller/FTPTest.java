package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

public class FTPTest {

	@Test
	public void testFtp() throws SocketException, IOException{
		FTPClient client = new FTPClient();
		client.connect("192.168.229.134", 21);
		client.login("ftpuser", "ftpuser");
		FileInputStream inputStream = new FileInputStream(new File("E:\\流程图\\安检员安检.png"));
		
		client.changeWorkingDirectory("/home/ftpuser/images");
		client.setFileType(FTP.BINARY_FILE_TYPE);
		client.storeFile("hello.png", inputStream);
		client.logout();
	}
}
