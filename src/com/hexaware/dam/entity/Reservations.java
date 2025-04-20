package com.hexaware.dam.entity;
/**
 * Represents a reservation record for an asset in the Digital Asset Management system.
 * This class includes details like the reservation ID, asset and employee IDs, 
 * reservation and usage dates, and current reservation status.
 * @authors Shifa Fathima
 * @date 20-04-2025
 */
public class Reservations {

    private int reservationId;       // Unique ID of the reservation
    private int assetId;             // ID of the reserved asset
    private int employeeId;          // ID of the employee who made the reservation
    private String reservationDate;  // Date when the reservation was made
    private String startDate;        // Start date of asset usage
    private String endDate;          // End date of asset usage
    private String status;           // Current status of the reservation (e.g., "Pending", "Approved", "Cancelled")

    /**
     * Default constructor to create an empty Reservations object.
     */
    public Reservations() {
    }

    // Parameterized constructor to initialize a Reservations object with the given values.
     
	public Reservations(int reservationId, int assetId, int employeeId, String reservationDate, String startDate,
			String endDate, String status) 
	{
		super();
		this.reservationId = reservationId;
		this.assetId = assetId;
		this.employeeId = employeeId;
		this.reservationDate = reservationDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	//Getters and Setters
	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
