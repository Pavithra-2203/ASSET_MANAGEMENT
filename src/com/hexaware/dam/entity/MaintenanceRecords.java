package com.hexaware.dam.entity;
/**
 * Represents the maintenance records for assets in the Digital Asset Management system.
 * This class contains information about maintenance activities performed on assets, 
 * including the maintenance ID, asset ID, maintenance date, description, and cost.
 * @author Shifa Fathima
 * @Date 20-04-2025
 */
public class MaintenanceRecords {

    private int maintenanceId;   // Unique identifier for the maintenance record
    private int assetId;         // ID of the asset being maintained
    private String maintenanceDate; // Date when the maintenance was performed
    private String description;  // Description of the maintenance performed
    private double cost;         // Cost of the maintenance

    /**
     * Default constructor for creating an empty MaintenanceRecords object.
     * This can be used when creating a new maintenance record object.
     */
    public MaintenanceRecords() {
    }

    // Parameterized constructor to create a new MaintenanceRecords object with the given details.
   
	public MaintenanceRecords(int maintenanceId, int assetId, String maintenanceDate, String description, double cost) 
	{
		super();
		this.maintenanceId = maintenanceId;
		this.assetId = assetId;
		this.maintenanceDate = maintenanceDate;
		this.description = description;
		this.cost = cost;
	}

 
	//Getters Nad Setters
	public int getMaintenanceId() {
		return maintenanceId;
	}


	public void setMaintenanceId(int maintenanceId) {
		this.maintenanceId = maintenanceId;
	}


	public int getAssetId() {
		return assetId;
	}


	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}


	public String getMaintenanceDate() {
		return maintenanceDate;
	}


	public void setMaintenanceDate(String maintenanceDate) {
		this.maintenanceDate = maintenanceDate;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}
    
    

}



