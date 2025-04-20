package com.hexaware.dam.entity;
/**
 * Represents an asset in the Digital Asset Management system.
 * This class contains all the details about an asset, including its ID, name, type, 
 * serial number, purchase date, location, status, and owner ID.
 * @author Pavithra 
 * @date 20-04-2025
 */
public class Assets {

    private int assetId;       // Unique identifier for the asset
    private String name;       // Name of the asset
    private String type;       // Type of the asset (e.g., Laptop, Vehicle, Equipment)
    private String serialNumber; // Serial number of the asset
    private String purchaseDate; // Purchase date of the asset
    private String location;   // Location where the asset is stored
    private String status;     // Current status of the asset (e.g., Available, Allocated)
    private int ownerId;       // ID of the asset's owner (could be an employee or department)

    /**
     * Default constructor for creating an empty Assets object.
     * This can be used when creating a new asset object.
     */
    public Assets() {
    }

    // Parameterized constructor to create a new Assets object with the given details.
	public Assets(int assetId, String name, String type, String serialNumber, String purchaseDate, String location,
			String status, int ownerId)
	{
		super();
		this.assetId = assetId;
		this.name = name;
		this.type = type;
		this.serialNumber = serialNumber;
		this.purchaseDate = purchaseDate;
		this.location = location;
		this.status = status;
		this.ownerId = ownerId;
	}

 //Getters and Setters
	public int getAssetId() {
		return assetId;
	}


	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}


	public String getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
    
	

}
