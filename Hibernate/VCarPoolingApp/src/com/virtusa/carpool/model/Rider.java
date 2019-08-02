package com.virtusa.carpool.model;

import javax.persistence.*;
@Entity
@Table(name = "rider")
public class Rider {

	public Rider() {
		
	}

	
	@Id
	@Column(name = "id")
	private long id;
	
	@OneToOne
	private Car car;
	
	
}
