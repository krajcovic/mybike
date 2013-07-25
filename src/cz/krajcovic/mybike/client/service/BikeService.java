package cz.krajcovic.mybike.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import cz.krajcovic.mybike.client.model.Bike;

@RemoteServiceRelativePath("bikeService")
public interface BikeService extends RemoteService {

	List<Bike> getUserBikes();

	Bike getBike(Integer id);
}
