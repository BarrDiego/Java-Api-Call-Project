package com.myorg.WCSApp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.myorg.WCSApp.client.ApiClient;
import com.myorg.WCSApp.model.CityData;
import com.myorg.WCSApp.model.WeatherData;

@Controller
public class ApiController {
	
	@RequestMapping(value="/my_search", method = RequestMethod.GET)
	public ModelAndView userBusqueda(HttpServletRequest req, HttpServletResponse res){
		
		ModelAndView mav = new ModelAndView("my_search");
		mav.addObject("my_search", new CityData());
		return mav;
		
		
	}
	
	@RequestMapping(value="/my_result", method = RequestMethod.POST)	
	public ModelAndView busquedaResponse(@ModelAttribute("my_search") CityData cityData,  HttpServletRequest req, HttpServletResponse res) {
		
		ModelAndView mav = null;
		ApiClient apiClient = new ApiClient();
		apiClient.setDataSearch(cityData);
		
		
		if(apiClient != null) {
			
			mav = new ModelAndView("my_result");
			mav.addObject("my_result", apiClient.getData());
		}else {
			mav = new ModelAndView("my_search");
			mav.addObject("message", "Ingrese los datos de su busqueda");
			
		}
		
		return mav;
		
		
	}
	
	

}
