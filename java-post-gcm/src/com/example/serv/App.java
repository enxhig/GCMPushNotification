package com.example.serv;

import com.example.server.vo.Content;

public class App {
	public static void main(String[] args) {
		
		System.out.println("Sending POST to GCM");
		
		String apiKey = "AIzaSyCmbjpOvobN5_2rJ39to3-fJpwJnuzUlHs";
		Content content = createContent();
		System.out.println(content.toString());
		Post2Gcm.post(apiKey, content);
	}

	public static Content createContent() {
		Content c = new Content();
		
		c.addRegId("cn6H860sb1U:APA91bFClU8_rIBRwwQKtEBaWPppdy1otZStHglricffNasiYCVBi56qwNFrSY8Yo7rh1QRDErhI7P4XVfuKnoC7w6SDoDaKveACX04mQAOCQGVQjJ9zj_fTLTmU1hkRtFuwVC8n2x8d");
		
		c.createData("Test title", "Test message");
		c.createNotification("Titull", "Body");
		
		return c;
	}
}
