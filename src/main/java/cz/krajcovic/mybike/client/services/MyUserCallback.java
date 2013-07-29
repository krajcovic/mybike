package cz.krajcovic.mybike.client.services;

import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import cz.krajcovic.mybike.client.modules.MyUser;
import cz.krajcovic.mybike.client.table.DataSource;
import cz.krajcovic.mybike.client.table.MyTable;


public class MyUserCallback implements AsyncCallback<List<MyUser>> {

	private MyTable table;

	public MyUserCallback(MyTable table2) {
		this.table = table2;
	}

	@Override
	public void onFailure(Throwable caught) {
		Window.alert(caught.getMessage());

	}

	@Override
	public void onSuccess(List<MyUser> result) {
		List<MyUser> users = result;
		DataSource datasource = new DataSource(users);
		table.setInput(datasource);
		for (MyUser user : users) {
			System.out.println(user.getUsername());
		}
	}

}
