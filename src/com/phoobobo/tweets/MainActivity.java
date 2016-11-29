package com.phoobobo.tweets;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.phoobobo.tweets.bean.*;

public class MainActivity extends ActionBarActivity {

	private ImageView avatarUserImg;
	private ImageView profileImg;
	private TextView userNickText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initUI();
	}
	
	private void initUI() {
		User usr = JsonParser.parseUser();
		String avatarUserUrl = usr.getAvatarUrl();
		String profileUrl = usr.getProfileImageUrl();
		String userNick = usr.getNickName();
		Bitmap bitmapAvatar = getHttpBitmap(avatarUserUrl);  
        avatarUserImg = (ImageView) findViewById(R.id.id_avatar_user);  
        //显示  
        avatarUserImg.setImageBitmap(bitmapAvatar);
        Bitmap bitmapProfile = getHttpBitmap(profileUrl);  
        profileImg = (ImageView) findViewById(R.id.id_profile_image);  
        //显示  
        profileImg.setImageBitmap(bitmapProfile);
        userNickText = (TextView) findViewById(R.id.id_nick_user);
        userNickText.setText(userNick);
	}

	public static Bitmap getHttpBitmap(String url){  
        URL myFileURL;  
        Bitmap bitmap=null;  
        try{  
            myFileURL = new URL(url);  
            //获得连接  
            HttpURLConnection conn=(HttpURLConnection)myFileURL.openConnection();  
            //设置超时时间为6000毫秒，conn.setConnectionTiem(0);表示没有时间限制  
            conn.setConnectTimeout(6000);  
            //连接设置获得数据流  
            conn.setDoInput(true);  
            //不使用缓存  
            conn.setUseCaches(false);  
            //这句可有可无，没有影响  
            //conn.connect();  
            //得到数据流  
            InputStream is = conn.getInputStream();  
            //解析得到图片  
            bitmap = BitmapFactory.decodeStream(is);  
            //关闭数据流  
            is.close();  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
          
        return bitmap;  
          
    }  

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
