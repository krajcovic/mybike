package cz.krajcovic.mybike.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import cz.krajcovic.mybike.client.model.Bike;
import cz.krajcovic.mybike.client.service.BikeService;

public class BikeServiceImpl extends RemoteServiceServlet implements
		BikeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -202129429149817165L;

	private List<Bike> bikeList = new ArrayList<Bike>();

	public BikeServiceImpl() {
		super();

		Bike bikeTestedData = new Bike();
		bikeTestedData.setId(1);
		bikeTestedData.setNickname("MRX");
		bikeTestedData.setStatus(0);

		bikeTestedData = new Bike();
		bikeTestedData.setId(2);
		bikeTestedData.setNickname("Author");
		bikeTestedData.setStatus(1);
	}

	@Override
	public List<Bike> getUserBikes() {

		return bikeList;
	}

	@Override
	public Bike getBike(Integer id) {
		for (Bike bike : bikeList) {
			if (bike.getId().equals(id)) {
				return bike;
			}
		}
		return null;
	}
}
