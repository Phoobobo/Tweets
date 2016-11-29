package com.phoobobo.tweets.test;

import com.phoobobo.tweets.utils.HttpUtils;

import android.test.AndroidTestCase;
import android.util.Log;

public class TestHttpUtils extends AndroidTestCase {
	
	private static final String URL_USER = "http://thoughtworks-ios.herokuapp.com/user/jsmith";
	private static final String URL_TWEETS = "http://thoughtworks-ios.herokuapp.com/user/jsmith/tweets";

	private static final String TAG = "TestHttpUtils";

	public void testSendInfo() {
		String res = HttpUtils.get(URL_USER);
		Log.e(TAG, res);
	}
}
