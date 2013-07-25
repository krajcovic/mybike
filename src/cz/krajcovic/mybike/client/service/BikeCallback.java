package cz.krajcovic.mybike.client.service;

import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import cz.krajcovic.mybike.client.model.Bike;
import cz.krajcovic.mybike.client.table.DataSource;
import cz.krajcovic.mybike.client.table.FormatedTable;

public class BikeCallback implements AsyncCallback<List<Bike>> {

	private FormatedTable table;

	public BikeCallback(FormatedTable table) {
		super();
		this.table = table;
	}

	@Override
	public void onFailure(Throwable arg0) {
		Window.alert(arg0.getMessage());

	}

	@Override
	public void onSuccess(List<Bike> result) {
		List<Bike> bikeList = result;
		DataSource dataSource = new DataSource(bikeList);
		table.setData(dataSource);

		for (Bike bike : bikeList) {
			System.out.println(bike.getNickname());
		}

	}

}
