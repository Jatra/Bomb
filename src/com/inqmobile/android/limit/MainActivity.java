package com.inqmobile.android.limit;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {
    private Limit mLimit;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		mLimit = new Limit();
		
		mLimit.addCapability("newsfeedx","Oct 11, 2012");
		
		TextView tv = (TextView)findViewById(R.id.tv);
		tv.setText("Expired: "+mLimit.isExpired("newsfeed"));
    }
}
