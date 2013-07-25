package cz.krajcovic.mybike.client.model;

import java.io.Serializable;

public class Bike implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5538342360544890448L;
	
	private Integer id;
	
	private String nickname;
	
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
