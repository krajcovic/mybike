package cz.krajcovic.mybike.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cz.krajcovic.mybike.client.model.Bike;

public interface BikeServiceAsync {

	void getUserBikes(AsyncCallback<List<Bike>> callback);

	void getBike(Integer id, AsyncCallback<Bike> callback);

}
