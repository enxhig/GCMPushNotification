package com.example.server.vo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.io.Serializable;
import java.util.Map;

public class Content implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<String> registration_ids;
	private Map<String, String> data;
	private Map<String, String> notification;
	
	public void addRegId(String regId) {
		if(registration_ids == null) {
			registration_ids = new LinkedList<String>();
		}
		
		registration_ids.add(regId);
	} 
	
	public void createData(String title, String message) {
		if(data == null) {
			data = new HashMap<String, String>();
		}
		data.put("title", title);
		data.put("message", message);
	}
	
	public void createNotification(String title, String body) {
		if(notification == null) {
			notification = new HashMap<String, String>();
		}
		notification.put("title", title);
		notification.put("body", body);
	}

	@Override
	public String toString() {
		return "Content [registration_ids=" + registration_ids + ", data=" + data + ", notification=" + notification
				+ "]";
	}

	
}
