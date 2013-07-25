package cz.krajcovic.mybike.client.table;

import java.util.ArrayList;
import java.util.List;

import cz.krajcovic.mybike.client.model.Bike;

public class DataSource {
	private final List<Bike> bikeList;
	private List<String> header;
	
	public DataSource(List<Bike> bikeList)
	{
		header = new ArrayList<String>();
		header.add("Id");
		header.add("Nickname");
		header.add("Status");
		this.bikeList = bikeList;
	}
	
	public List<Bike> getBikes() {
		return bikeList;
	}
	
	public List<String> getTableHeader() {
		return header;
	}
}
