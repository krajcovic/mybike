package cz.krajcovic.mybike.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import cz.krajcovic.mybike.client.modules.MyUser;


@RemoteServiceRelativePath("userService")
public interface MyUserService extends RemoteService {
	List<MyUser> getUserList();

	MyUser getUser(String id);
}
