package com.cg.springrestwithexceptions.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.springrestwithexceptions.beans.Country;
import com.cg.springrestwithexceptions.staticdb.CountryDb;



@Repository
public class CountryDaoImpl implements ICountryDao {


	public List<Country> getAllCountries() {
		// TODO Auto-generated method stub
		return CountryDb.getCountryList();
	}


	public void addCountry(Country country) {
		// TODO Auto-generated method stub
		CountryDb.getCountryList().add(country);
	}

	@Override
	public Country deleteCountry(int id) {
		// TODO Auto-generated method stub
		return CountryDb.getCountryList().remove(id);
	}
	@Override
	public Country searchCountry(int id) {
		return CountryDb.getCountryList().stream().filter(c->Integer.parseInt(c.getCountryId())==id).findFirst().get();
	}
}
