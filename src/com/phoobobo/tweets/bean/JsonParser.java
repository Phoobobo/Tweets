package com.phoobobo.tweets.bean;

import com.phoobobo.tweets.utils.*;
import com.google.gson.Gson;


public class JsonParser {

	private static final String URL_USER = "http://thoughtworks-ios.herokuapp.com/user/jsmith";
	private static final String URL_TWEETS = "http://thoughtworks-ios.herokuapp.com/user/jsmith/tweets";
	
	public static User parseUser() {
		String userData =  HttpUtils.get(URL_USER);
		Gson gson = new Gson();
		User user = gson.fromJson(userData, User.class);
		return user;
	}
	
}
