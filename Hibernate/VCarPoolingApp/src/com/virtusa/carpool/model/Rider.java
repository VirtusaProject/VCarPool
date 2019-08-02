package com.virtusa.carpool.model;

import javax.persistence.*;

public class Rider {

	public Rider() {
		
	}

	
	@Id
	private long id;
	
	@OneToOne
	private Car car;
	
	
}
