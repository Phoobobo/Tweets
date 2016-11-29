package com.phoobobo.tweets.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtils {

	private static final String URL_USER = "http://thoughtworks-ios.herokuapp.com/user/jsmith";
	private static final String URL_TWEETS = "http://thoughtworks-ios.herokuapp.com/user/jsmith/tweets";
	
	public static String get(String url) {
		String result = "";
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try {
			URL netUrl = new URL(url);
			// 打开一个链接
			HttpURLConnection conn = (HttpURLConnection) netUrl.openConnection();
			conn.setReadTimeout(5*1000);
			conn.setConnectTimeout(5*1000);
			conn.setRequestMethod("GET");
			
			is = conn.getInputStream();
			int len = -1;
			byte[] buffer = new byte[128];
			baos = new ByteArrayOutputStream();
			//读取输入流
			while((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			baos.flush(); //清除缓冲区
			result = new String(baos.toByteArray()); //输入流本地化
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// lose all the resources!!
			if (baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
