package com.hexaware.dam.service;

import com.hexaware.dam.entity.AssetAllocations;

import com.hexaware.dam.entity.Assets;
import com.hexaware.dam.entity.MaintenanceRecords;
import com.hexaware.dam.entity.Reservations;
import com.hexaware.dam.exception.AssetNotFoundException;
import com.hexaware.dam.exception.AssetNotMaintainException;

/**
 * Interface representing the services for managing assets.
 * Provides methods for adding, updating, deleting, allocating, 
 * deallocating, performing maintenance, and reserving assets.
 * @authors Pavithra , Shifa Fathima
 * @Date 20-04-2025
 */

public interface IAssetManagementService {
    boolean addAsset(Assets asset) throws AssetNotMaintainException;//Adds a new asset to the system.
    boolean updateAsset(Assets asset) throws AssetNotFoundException,AssetNotMaintainException;//Updates an existing asset in the system.
    boolean deleteAsset(int assetId) throws AssetNotFoundException;//Deletes an asset from the system.
    boolean allocateAsset(AssetAllocations allocation) throws AssetNotFoundException,AssetNotMaintainException;//Allocates an asset to an employee.
    boolean deallocateAsset(int allocationId) throws AssetNotFoundException;//Deallocates an asset from an employee.
    boolean performMaintenance(MaintenanceRecords record) throws AssetNotMaintainException,AssetNotFoundException;//Performs maintenance on an asset.
    boolean reserveAsset(Reservations reservation)throws AssetNotFoundException,AssetNotMaintainException;//Reserves an asset for future use.
}

