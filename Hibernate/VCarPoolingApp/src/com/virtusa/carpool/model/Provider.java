package com.virtusa.carpool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provider")

public class Provider {

	public Provider() {
		
	}
	
	@Id
	@Column(name = "id")
	private long id;

}
