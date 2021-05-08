package com.cg.springrestwithexceptions.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cg.springrestwithexceptions.beans.Country;
import com.cg.springrestwithexceptions.exceptions.CountryNotFoundException;
import com.cg.springrestwithexceptions.service.ICountryService;


@RestController
public class CountryController {
	@Autowired
	ICountryService service;

	/*
	 * without exception handling
	 * 
	 * 
	 * public Country getCounty(@PathVariable int id) {
		return service.searchCountry(id);
		
	}
	*/
	@RequestMapping(value = "/countries/search/{id}",method = RequestMethod.GET,headers="Accept=application/json")

	public Country getCounty(@PathVariable int id) throws CountryNotFoundException{
		Country c =null;
		try {
			c = service.searchCountry(id);
			System.out.println("country"+c);
		}catch(Exception e) {
			throw new CountryNotFoundException("No country with this id");
		}
         return c;
		
	}



	
	@RequestMapping(value = "/countries",method = RequestMethod.GET,headers="Accept=application/json")
	public List<Country> getAllCounties(Model model) {
		return service.getAllCountries();
		
	}
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = {CountryNotFoundException.class})
	  protected String handleConflict2(Exception ex, HttpServletRequest req) {
        String bodyOfResponse = ex.getMessage();// "Country with this id not present";
       
        return   bodyOfResponse; 
    }
	
	
}
