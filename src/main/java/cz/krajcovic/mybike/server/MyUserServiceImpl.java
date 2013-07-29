package cz.krajcovic.mybike.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import cz.krajcovic.mybike.client.modules.MyUser;
import cz.krajcovic.mybike.client.services.MyUserService;

public class MyUserServiceImpl extends RemoteServiceServlet implements
		MyUserService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<MyUser> userList = new ArrayList<MyUser>();

	public MyUserServiceImpl() {
		super();
		MyUser user = new MyUser();
		user.setId("1");
		user.setUsername("Peter");
		user.setNumberOfHits("15");
		userList.add(user);

		user = new MyUser();
		user.setId("2");
		user.setUsername("Hanz");
		user.setNumberOfHits("25");
		userList.add(user);
	}

	@Override
	public List<MyUser> getUserList() {
		return userList;
	}

	@Override
	public MyUser getUser(String id) {
		for (Object object : userList) {
			if (((MyUser) object).getId().equals(id))
				return ((MyUser) object);
		}
		return null;
	}

}
