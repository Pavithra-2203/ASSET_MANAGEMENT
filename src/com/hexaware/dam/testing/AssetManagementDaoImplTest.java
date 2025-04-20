package com.hexaware.dam.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hexaware.dam.dao.AssetManagementDaoImpl;
import com.hexaware.dam.entity.Assets;

/**
 * Unit tests for the {@link AssetManagementDaoImpl} class.
 * 
 * These tests require an active database connection and valid data setup.
 * Tests are not isolated, and results may vary depending on existing database state.
 * 
 * Ensure that asset IDs used in tests are either available for creation or exist for update/delete operations.
 * 
 * @authors Pavithra , Shifa Fathima
 * @Date 2025-04-20
 */
class AssetManagementDaoImplTest {

	 private final AssetManagementDaoImpl dao = new AssetManagementDaoImpl();

	 /**
	     * Tests insertion of a new asset into the database.
	     * Ensures that the method returns true when insertion is successful.
	     */

	    @Test
	    void testInsertAsset() {
	        Assets asset = new Assets(1002, "Projector", "Laptop", "SN1002", "2024-02-15", "Branch Office", "Available", 2);
	        boolean result = dao.insertAsset(asset);
	        assertTrue(result);
	    }
	    
	    /**
	     * Tests updating an existing asset in the database.
	     * Requires the asset  ID  to exist beforehand.
	     */

	    @Test
	    void testUpdateAsset() {
	        Assets asset = new Assets(2, "Projector X", "Laptop", "SN1002X", "2024-02-20", "Branch Office", "In Use", 2);
	        boolean result = dao.updateAsset(asset);
	        assertTrue(result);
	    }

	    /**
	     * Tests deletion of an asset from the database.
	     * Ensure that asset  ID  exists before running this test.
	     */
	    
	    @Test
	    void testDeleteAsset() {
	        boolean result = dao.deleteAsset(1002); // Make sure this ID exists before running test
	        assertTrue(result);
	    }

	    /**
	     * Tests deallocation of an asset based on allocation ID.
	     * Allocation  ID  must exist in the database.
	     */

	    @Test
	    void testDeallocateAsset() {
	        boolean result = dao.deallocateAsset(1); // Must exist before test
	        assertTrue(result);
	    }

	    

	    
}