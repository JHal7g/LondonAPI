package com.example.demo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;

public class CoordGetter {

	public static ArrayList<Person> Get(HttpURLConnection con) throws IOException {

		ArrayList<Person> people = new ArrayList<Person>();
		ArrayList<Person> people2 = new ArrayList<Person>();
		BufferedReader in = null;

		//create input reader
		try{
			in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
		}
		catch (IOException e) {
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

		

		in.close();
		con.disconnect();
		
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		//add users from people to people2 if they are within 50 miles of London
		for (int i = 0; i < people.size(); i++) {
			if (Calculator.distance(51.5074, 0.1278, Double.parseDouble(people.get(i).getLatitude()),  Double.parseDouble(people.get(i).getLongitude()))) {

				people2.add(people.get(i));

			}
		}

		return people2;

	}


}
