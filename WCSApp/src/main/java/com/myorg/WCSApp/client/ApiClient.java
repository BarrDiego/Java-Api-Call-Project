package com.myorg.WCSApp.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.internal.ClientConfiguration;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.myorg.WCSApp.model.CityData;
import com.myorg.WCSApp.model.WeatherData;

public class ApiClient {
	
	private static final String keyApi = "97bffcbd2f42bde918d8b4385778a928";
	private static final String URL_BASE =
			"https://api.openweathermap.org/data/2.5/weather?q=London&appid="+keyApi;
	@Autowired
	static CityData cityData;

//asignamos la sobrecarga a la url	
public static String setDataSearch(CityData cityData) {
	
	final String URL_BASE_Charged =
			"https://api.openweathermap.org/data/2.5/weather?q="+cityData.getCity()+","+cityData.getState()+","+cityData.getCountry()+"&appid="+keyApi;
	
	return URL_BASE_Charged;
}	
	
//metodo que obtiene una respuesta generica	
/*public static List<String> getData() {

	ArrayList<String> weatherList = new ArrayList<String>();
	Client client = ClientBuilder.newClient();
	WebTarget webTarget = client.target(URL_BASE);
	String request = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

	JSONObject jsonObject = new JSONObject(request);

	weatherList.add(jsonObject.toString());

	return weatherList;

}*/

public static List<String> getData()  {	
	
	ArrayList<String> weatherList = new ArrayList<String>();
	Client client = ClientBuilder.newClient();
	WebTarget webTarget = client.target(setDataSearch(cityData));
	String request = webTarget
			.request(MediaType.APPLICATION_JSON_TYPE)
			.get(String.class);
	
	JSONObject jsonObject = new JSONObject(request);
	
	weatherList.add(jsonObject.toString());	
	
	return weatherList;
	
}	
	
	
public static void main(String[] args)  {
		
		System.out.println(getData());
	}

}
