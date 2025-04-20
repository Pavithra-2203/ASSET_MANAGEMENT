package com.hexaware.dam.dao;

import com.hexaware.dam.entity.AssetAllocations;
import com.hexaware.dam.entity.Assets;
import com.hexaware.dam.entity.MaintenanceRecords;
import com.hexaware.dam.entity.Reservations;

/**
 * Interface for asset management operations.
 * Defines the contract for asset CRUD, allocation, maintenance, and reservation functionality.
 * 
 * Implementations of this interface should handle the data persistence layer,
 * typically through JDBC.
 * 
 * @authors Pavithra, Shifa Fathima
 * @Date 2025-04-20
 */
public interface IAssetManagementDao {
	boolean addAsset(Assets asset);//Adds a new asset to the system.
	 boolean insertAsset(Assets asset);//Inserts a new asset into the database.
	    boolean updateAsset(Assets asset);// Updates an existing asset in the database.
	    boolean deleteAsset(int assetId);//Deletes an asset from the database using its ID.
	    boolean allocateAsset(AssetAllocations allocation);//Allocates an asset to an employee.
	    boolean deallocateAsset(int allocationId);//Deallocates an asset using its allocation ID.
	    boolean performMaintenance(MaintenanceRecords record);//Records a maintenance activity for an asset.
	    boolean reserveAsset(Reservations reservation);//Creates a reservation for an asset.
	}
