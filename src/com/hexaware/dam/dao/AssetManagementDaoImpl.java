package com.hexaware.dam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.hexaware.dam.entity.AssetAllocations;
import com.hexaware.dam.entity.Assets;
import com.hexaware.dam.entity.MaintenanceRecords;
import com.hexaware.dam.entity.Reservations;
import com.hexaware.dam.util.DBConnUtil;

/**
 * Implementation of the IAssetManagementDao interface.
 * Provides methods for managing assets, including insertion, update, deletion,
 * allocation, deallocation, maintenance logging, and reservations.
 * 
 * This class uses JDBC for direct database operations.
 * 
 * @authors Pavithra,Shifa Fathima
 * @Date 2025-04-20
 */


public class AssetManagementDaoImpl implements IAssetManagementDao {
	
	//Adds a new asset to the system by calling insertAsset.
	@Override
    public boolean addAsset(Assets asset) {
        return insertAsset(asset);
    }

	
	//Inserts a new asset record into the 'assets' table.
    @Override
    public boolean insertAsset(Assets asset) {
        String sql = "INSERT INTO assets (asset_id, name, type, serial_number, purchase_date, location, status, owner_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, asset.getAssetId());
            pstmt.setString(2, asset.getName());
            pstmt.setString(3, asset.getType());
            pstmt.setString(4, asset.getSerialNumber());
            pstmt.setString(5, asset.getPurchaseDate());
            pstmt.setString(6, asset.getLocation());
            pstmt.setString(7, asset.getStatus());
            pstmt.setInt(8, asset.getOwnerId());

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    //Updates an existing asset in the 'assets' table.
    @Override
    public boolean updateAsset(Assets asset) {
        String sql = "UPDATE assets SET name = ?, type = ?, serial_number = ?, purchase_date = ?, location = ?, status = ?, owner_id = ? WHERE asset_id = ?";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, asset.getName());
            pstmt.setString(2, asset.getType());
            pstmt.setString(3, asset.getSerialNumber());
            pstmt.setString(4, asset.getPurchaseDate());
            pstmt.setString(5, asset.getLocation());
            pstmt.setString(6, asset.getStatus());
            pstmt.setInt(7, asset.getOwnerId());
            pstmt.setInt(8, asset.getAssetId());

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    //Deletes an asset from the system using its asset ID.
    @Override
    public boolean deleteAsset(int assetId) {
        String sql = "DELETE FROM assets WHERE asset_id = ?";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, assetId);
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    //Allocates an asset to an employee by inserting a record into 'AssetAllocations'.
    @Override
    public boolean allocateAsset(AssetAllocations allocation) {
        String sql = "INSERT INTO AssetAllocations (allocation_id, asset_id, employee_id, allocation_date, return_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, allocation.getAllocationId());
            pstmt.setInt(2, allocation.getAssetId());
            pstmt.setInt(3, allocation.getEmployeeId());
            pstmt.setString(4, allocation.getAllocationDate());
            pstmt.setString(5, allocation.getReturnDate());

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    //Deallocates an asset by removing the corresponding allocation record.
    @Override
    public boolean deallocateAsset(int allocationId) {
        String sql = "DELETE FROM Asset_allocations WHERE allocation_id = ?";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, allocationId);
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    //Logs a maintenance record for an asset.
    @Override
    public boolean performMaintenance(MaintenanceRecords record) {
        String sql = "INSERT INTO maintenance_records (maintenance_id, asset_id, maintenance_date, description, cost) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, record.getMaintenanceId());
            pstmt.setInt(2, record.getAssetId());
            pstmt.setString(3, record.getMaintenanceDate());
            pstmt.setString(4, record.getDescription());
            pstmt.setDouble(5, record.getCost());

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    //Reserves an asset for future use by inserting a reservation record.
    @Override
    public boolean reserveAsset(Reservations reservation) {
        String sql = "INSERT INTO reservations (reservation_id, asset_id, employee_id, reservation_date, start_date, end_date, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, reservation.getReservationId());
            pstmt.setInt(2, reservation.getAssetId());
            pstmt.setInt(3, reservation.getEmployeeId());
            pstmt.setString(4, reservation.getReservationDate());
            pstmt.setString(5, reservation.getStartDate());
            pstmt.setString(6, reservation.getEndDate());
            pstmt.setString(7, reservation.getStatus());

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


