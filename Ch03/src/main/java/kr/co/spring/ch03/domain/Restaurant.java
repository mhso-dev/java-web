package kr.co.spring.ch03.domain;

public class Restaurant {

	private final String name;
	private String location;
	
	public Restaurant(String name) {
		this.name = name;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {

		return this.name;
	}

	public String getLocation() {
		// TODO Auto-generated method stub
		return this.location;
	}

}