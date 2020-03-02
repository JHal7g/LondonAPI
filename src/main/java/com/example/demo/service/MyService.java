package com.example.demo.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.example.demo.service.Person;

@Service
public class MyService {

	public ArrayList<Person> getPeople(HttpURLConnection con1, HttpURLConnection con2) throws IOException{

		ArrayList<Person> people = new ArrayList<Person>();

		people.addAll(CityGetter.Get(con1));

		people.addAll(CoordGetter.Get(con2));

		return people;


	}

}
