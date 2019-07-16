package com.virtusa.carpool.model;

public class Bill {
	
	private int txnId;
	private String status;
	private double fare;
	private Ride rideId;
	
	public Bill(String status, double fare, Ride rideId) {
		super();
		this.status = status;
		this.fare = fare;
		this.rideId = rideId;
	}

	public Bill(int txnId, String status, double fare, Ride rideId) {
		super();
		this.txnId = txnId;
		this.status = status;
		this.fare = fare;
		this.rideId = rideId;
	}

	/**
	 * @return the txnId
	 */
	public int getTxnId() {
		return txnId;
	}

	/**
	 * @param txnId the txnId to set
	 */
	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the fare
	 */
	public double getFare() {
		return fare;
	}

	/**
	 * @param fare the fare to set
	 */
	public void setFare(double fare) {
		this.fare = fare;
	}

	/**
	 * @return the rideId
	 */
	public Ride getRideId() {
		return rideId;
	}

	/**
	 * @param rideId the rideId to set
	 */
	public void setRideId(Ride rideId) {
		this.rideId = rideId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bill [txnId=" + txnId + ", status=" + status + ", fare=" + fare + "]";
	}
	
	

}
