package com.hexaware.dam.service;
import java.time.LocalDate;


import com.hexaware.dam.dao.*;

import com.hexaware.dam.entity.*;
import com.hexaware.dam.exception.AssetNotFoundException;
import com.hexaware.dam.exception.AssetNotMaintainException;

/**
 * Implementation of the Asset Management Service Interface.
 * This service provides methods for adding, updating, deleting, allocating,
 * deallocating, maintaining, and reserving assets in the system.
 * It also contains validation logic for asset types and dates.
 * @authors Pavithra , Shifa Fathima
 * @Date 20-04-2025
 */
public class AssetManagementServiceImpl implements IAssetManagementService {

	// Data Access Object (DAO) for interacting with the database
	protected IAssetManagementDao dao;

	/**
     * Default constructor that initializes the DAO to the default implementation.
     */
    public AssetManagementServiceImpl() {
        dao = new AssetManagementDaoImpl();  // or use dependency injection if you're managing dependencies
    }
    // New constructor to inject a custom DAO (useful for testing with DB)
    public AssetManagementServiceImpl(IAssetManagementDao dao) {
        this.dao = dao;
    }
    
    //Adds a new asset to the system.
    @Override
    public boolean addAsset(Assets asset) throws AssetNotMaintainException {
    	validateAssetType(asset.getType());
    	return dao.insertAsset(asset);
    }

    //Updates an existing asset in the system.
    @Override
    public boolean updateAsset(Assets asset) throws AssetNotFoundException,AssetNotMaintainException {
    	validateAssetType(asset.getType());
    	return dao.updateAsset(asset);
    }

    //Deletes an asset from the system by its ID.
    @Override
    public boolean deleteAsset(int assetId) throws AssetNotFoundException {
    	return dao.deleteAsset(assetId);
    }

    //Allocates an asset to an employee.
    @Override
    public boolean allocateAsset(AssetAllocations allocation) throws AssetNotFoundException,AssetNotMaintainException{
    	 validateDate(allocation.getAllocationDate(), "Allocation Date");
         validateDate(allocation.getReturnDate(), "Return Date");
    	return dao.allocateAsset(allocation);
    }

    //Deallocates an asset from an employee based on the allocation ID.
    @Override
    public boolean deallocateAsset(int allocationId) throws AssetNotFoundException{
        return dao.deallocateAsset(allocationId);
    }

    //Performs maintenance on an asset.
    @Override
    public boolean performMaintenance(MaintenanceRecords record) throws AssetNotMaintainException, AssetNotFoundException{
    	validateDate(record.getMaintenanceDate(), "Maintenance Date");
    	return dao.performMaintenance(record);
        
    }

    //Reserves an asset for an employee.
    @Override
    public boolean reserveAsset(Reservations reservation) throws AssetNotFoundException,AssetNotMaintainException {
    	validateDate(reservation.getReservationDate(), "Reservation Date");
        validateDate(reservation.getStartDate(), "Start Date");
        validateDate(reservation.getEndDate(), "End Date");
    	return dao.reserveAsset(reservation);
    }
    
    //Validates that the asset type is one of the allowed values: "Laptop", "Vehicle", or "Equipment".
    private void validateAssetType(String type) throws AssetNotMaintainException {
        if (type == null) {
            throw new AssetNotMaintainException("Asset type cannot be null.");
        }

        String normalized = type.trim().toLowerCase();
        if (!(normalized.equals("laptop") || normalized.equals("vehicle") || normalized.equals("equipment"))) {
            throw new AssetNotMaintainException("Asset type must be 'Laptop', 'Vehicle', or 'Equipment'.");
        }
    }
//Validates that the date is a valid future date.
    private void validateDate(String dateStr, String fieldName) throws AssetNotMaintainException, AssetNotFoundException {
        try {
            LocalDate date = LocalDate.parse(dateStr);
            if (!date.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException(fieldName + " must be a future date.");
            }
        } catch (Exception e) {
            String msg = fieldName + " is invalid or not a future date.";
            if (fieldName.toLowerCase().contains("maintenance")) {
                throw new AssetNotMaintainException(msg);
            } else {
                throw new AssetNotFoundException(msg);
            }
        }
    }
}