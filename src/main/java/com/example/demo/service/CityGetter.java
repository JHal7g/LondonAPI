package com.example.demo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.util.ArrayList;

public class CityGetter {

	public static ArrayList<Person> Get(HttpURLConnection con){

		ArrayList<Person> people = new ArrayList<Person>();
		BufferedReader in = null;
		
		try {
			con.setRequestMethod("GET");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		//create input reader
		try {
			in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String inputLine;

		//convert JSON data to Person objects and add to people array
		try {
			while ((inputLine = in.readLine()) != null) {
				inputLine = inputLine.substring(2, inputLine.length()-4);
				for (int j = 0; j < inputLine.split("\\}, \\{").length; j++) {
					people.add(new Person());
					String[] data = inputLine.split("\\}, \\{");
					String id, first_name, last_name, email, ip_address, latitude, longitude;
					String[] data2 = data[j].split(", ");
					id = data2[0].substring(5);
					first_name = data2[1].substring(15, data2[1].length()-1);
					last_name = data2[2].substring(14, data2[2].length()-1);
					email = data2[3].substring(10, data2[3].length()-1);
					ip_address = data2[4].substring(15, data2[4].length()-1);
					latitude = data2[5].substring(11);
					latitude = latitude.replaceAll("\"", "");
					longitude = data2[6].substring(13);
					longitude = longitude.replaceAll("\"", "");
					people.get(j).setId(id);
					people.get(j).setEmail(email);
					people.get(j).setFirst_name(first_name);
					people.get(j).setLast_name(last_name);
					people.get(j).setLatitude(latitude);
					people.get(j).setLongitude(longitude);
					people.get(j).setIp_address(ip_address);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		//close connections
		con.disconnect();

		return people;

	}
}