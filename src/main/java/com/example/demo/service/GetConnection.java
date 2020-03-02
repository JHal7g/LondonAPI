package com.example.demo.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetConnection {

	public static HttpURLConnection Connection (String s) {

		HttpURLConnection con = null;
		URL url = null;
		try {
			url = new URL("https://bpdts-test-app.herokuapp.com"+s);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (IllegalStateException e) {
            e.printStackTrace();
        }
		try {
			con = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return con;
		
	}
}