package com.cg.springrestwithexceptions.dao;



import java.util.List;

import com.cg.springrestwithexceptions.beans.Country;





public interface ICountryDao {
	public List<Country> getAllCountries();
	public void addCountry(Country country);
	public Country deleteCountry(int id);
	public Country searchCountry(int id);
}
