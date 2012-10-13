package com.inqmobile.android.limit;
import java.util.*;
import android.content.*;
import java.text.*;

public class Limit
{
    private HashMap<String, Long> capabilities;
	private static DateFormat sDateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
	
	public Limit() {
		capabilities = new HashMap<String, Long>();
	}
	
	public void addCapability(String key,long expiry) {
		capabilities.put(key, expiry);
	}

	/**
	 * Expiry String format must be  Jul 1, 2012  (ie MEDIUM, Locale, US)
	 */	
	public void addCapability(String key, String expiry) {
		try {
			Date date = sDateFormat.parse(expiry);
		    addCapability(key, date.getTime());
		} catch (Exception e) {
			throw new IllegalArgumentException(key+":"+expiry, e);
		}
	}
	
	public boolean isExpired(String key){
		Long expiry = capabilities.get(key);
		return (expiry != null) && System.currentTimeMillis() > expiry.longValue();
	}
	
	
	
}
