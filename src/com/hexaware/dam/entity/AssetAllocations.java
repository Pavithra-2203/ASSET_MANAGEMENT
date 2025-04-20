package com.hexaware.dam.entity;

/**
 * Represents an asset allocation to an employee.
 * This class contains the details about the allocation, such as the asset ID, 
 * employee ID, allocation date, and return date.
 * @author Pavithra 
 * @date 20-04-2025
 */

public class AssetAllocations {

	
	 private int allocationId;   // Unique ID for the asset allocation
	    private int assetId;        // ID of the allocated asset
	    private int employeeId;     // ID of the employee to whom the asset is allocated
	    private String allocationDate; // Date when the asset was allocated
	    private String returnDate;    // Date when the asset is expected to be returned

	    /**
	     * Default constructor for creating an empty AssetAllocations object.
	     * This can be used when creating a new allocation from the database.
	     */
    
    public AssetAllocations() 
    {
    	
    }

    //Parameterized constructor to create a new AssetAllocations object with the given details.
	public AssetAllocations(int allocationId, int assetId, int employeeId, String allocationDate, String returnDate) {
		super();
		this.allocationId = allocationId;
		this.assetId = assetId;
		this.employeeId = employeeId;
		this.allocationDate = allocationDate;
		this.returnDate = returnDate;
	}

	//Getters and Setters
	public int getAllocationId() {
		return allocationId;
	}

	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
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

	public String getAllocationDate() {
		return allocationDate;
	}

	public void setAllocationDate(String allocationDate) {
		this.allocationDate = allocationDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
    
    

}
