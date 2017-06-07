package com.example.serv;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.example.server.vo.Content;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Post2Gcm {

	public static void post(String apiKey, Content content) {
		try {
			
			URL url = new URL("https://android.googleapis.com/gcm/send");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("POST");
			
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", "key="+apiKey);
			
			conn.setDoOutput(true);
			
			ObjectMapper mapper = new ObjectMapper();
			
			mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			System.out.println(wr.toString());
			mapper.writeValue(wr, content);
			System.out.println(content);
			wr.flush();
			
			wr.close();
		
			int responseCode = conn.getResponseCode();
			System.out.println("\nSending 'POST' request to URL:" + url);
			System.out.println("Response Code: " + responseCode);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			
			in.close();
			
			System.out.println(response.toString());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
