/**
 * Main.java
 * 
 * This is the entry point for the Digital Asset Management system. It provides
 * a menu-driven console interface for managing assets, including adding, updating,
 * deleting, allocating, deallocating, performing maintenance, and reserving assets.
 * 
 * Authors: Pavithra , Shifa Fathima
 * Date: April 2025 ,20
 */
package com.hexaware.dam.presentation;

import java.util.Scanner;
import com.hexaware.dam.service.*;
import com.hexaware.dam.exception.AssetNotFoundException;
import com.hexaware.dam.exception.AssetNotMaintainException;

import com.hexaware.dam.entity.AssetAllocations;
import com.hexaware.dam.entity.Assets;
import com.hexaware.dam.entity.*;
public class Main {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        IAssetManagementService service = new AssetManagementServiceImpl();

	        while (true) {
	        	try {
	            System.out.println("\n--- Digital Asset Management Menu ---");
	            System.out.println("1. Add Asset");
	            System.out.println("2. Update Asset");
	            System.out.println("3. Delete Asset");
	            System.out.println("4. Allocate Asset");
	            System.out.println("5. Deallocate Asset");
	            System.out.println("6. Perform Maintenance");
	            System.out.println("7. Reserve Asset");
	            System.out.println("8. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = sc.nextInt();
	            sc.nextLine(); // consume newline

	            switch (choice) {
	                case 1:
	                    System.out.println("---- Enter asset details ----");
	                    System.out.println();
	                    System.out.println("Asset ID: ");
	                    int assetId = sc.nextInt();
	                    sc.nextLine();
	                    System.out.println("Asset Name: ");
	                    String name = sc.nextLine();
	                    System.out.println("Asset Type: ");
	                    String type = sc.nextLine();
	                    System.out.println("Serial Number: ");
	                    String serialNumber = sc.nextLine();
	                    System.out.println("Purchase Date (YYYY-MM-DD): ");
	                    String purchaseDate = sc.nextLine();
	                    System.out.println("Location: ");
	                    String location = sc.nextLine();
	                    System.out.println("Status: ");
	                    String status = sc.nextLine();
	                    System.out.println("Owner ID: ");
	                    int ownerId = sc.nextInt();

	                    Assets asset = new Assets(assetId, name, type, serialNumber, purchaseDate, location, status, ownerId);
	                    service.addAsset(asset);
	                    System.out.println(" Asset inserted Successfully");
	                    break;

	                case 2:
	                    System.out.print("---- Enter Asset ID to update ---- ");
	                    int updateId = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("New Name: ");
	                    String newName = sc.nextLine();
	                    System.out.print("New Type: ");
	                    String newType = sc.nextLine();
	                    System.out.print("New Serial Number: ");
	                    String newSerial = sc.nextLine();
	                    System.out.print("New Purchase Date (YYYY-MM-DD): ");
	                    String newPurchase = sc.nextLine();
	                    System.out.print("New Location: ");
	                    String newLocation = sc.nextLine();
	                    System.out.print("New Status: ");
	                    String newStatus = sc.nextLine();
	                    System.out.print("New Owner ID: ");
	                    int newOwnerId = sc.nextInt();

	                    Assets updatedAsset = new Assets(updateId, newName, newType, newSerial, newPurchase, newLocation, newStatus, newOwnerId);
	                    service.updateAsset(updatedAsset);
	                    System.out.println(" Asset updated Successfully");
	                    break;

	                case 3:
	                    System.out.print("Enter Asset ID to delete: ");
	                    int deleteId = sc.nextInt();
	                    service.deleteAsset(deleteId);
	                    System.out.println(" Asset Deleted Successfully");
	                    break;

	                case 4:
	                    System.out.println("---- Enter allocation details ----");
	                    System.out.print("Allocation ID: ");
	                    int allocationId = sc.nextInt();
	                    System.out.print("Asset ID: ");
	                    int allocAssetId = sc.nextInt();
	                    System.out.print("Employee ID: ");
	                    int empId = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Allocation Date (YYYY-MM-DD): ");
	                    String allocDate = sc.nextLine();
	                    System.out.print("Return Date (YYYY-MM-DD): ");
	                    String returnDate = sc.nextLine();

	                    AssetAllocations allocation = new AssetAllocations(allocationId, allocAssetId, empId, allocDate, returnDate);
	                    service.allocateAsset(allocation);
	                    System.out.println(" Asset allocated Successfully");
	                    break;

	                case 5:
	                    System.out.print("Enter Allocation ID to deallocate: ");
	                    int deallocId = sc.nextInt();
	                    service.deallocateAsset(deallocId);
	                    System.out.println(" Asset deallocated Successfully");
	                    break;

	                case 6:
	                    System.out.println("---- Enter maintenance details ----");
	                    System.out.print("Maintenance ID: ");
	                    int maintenanceId = sc.nextInt();
	                    System.out.print("Asset ID: ");
	                    int mAssetId = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Maintenance Date (YYYY-MM-DD): ");
	                    String mDate = sc.nextLine();
	                    System.out.print("Description: ");
	                    String desc = sc.nextLine();
	                    System.out.print("Cost: ");
	                    double cost = sc.nextDouble();

	                    MaintenanceRecords record = new MaintenanceRecords(maintenanceId, mAssetId, mDate, desc, cost);
	                    service.performMaintenance(record);
	                    break;

	                case 7:
	                    System.out.println("---- Enter reservation details ---- ");
	                    System.out.print("Reservation ID: ");
	                    int reservationId = sc.nextInt();
	                    System.out.print("Asset ID: ");
	                    int rAssetId = sc.nextInt();
	                    System.out.print("Employee ID: ");
	                    int rEmpId = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Reservation Date (YYYY-MM-DD): ");
	                    String resDate = sc.nextLine();
	                    System.out.print("Start Date (YYYY-MM-DD): ");
	                    String startDate = sc.nextLine();
	                    System.out.print("End Date (YYYY-MM-DD): ");
	                    String endDate = sc.nextLine();
	                    System.out.print("Status: ");
	                    String resStatus = sc.nextLine();

	                    Reservations reservation = new Reservations(reservationId, rAssetId, rEmpId, resDate, startDate, endDate, resStatus);
	                    service.reserveAsset(reservation);
	                    System.out.println(" Asset Reserved Successfully");
	                    break;

	                case 8:
	                    System.out.println("Exited Successfully");
	                    sc.close();
	                    System.exit(0);

	                default:
	                    System.out.println("Invalid choice. Try again.");
	            }
	        	}
	        	catch (AssetNotFoundException | AssetNotMaintainException e) {
	                System.out.println("Error: " + e.getMessage());
	            } catch (Exception e) {
	                System.out.println("Something went wrong: " + e.getMessage());
	                sc.nextLine(); // clear buffer in case of input mismatch
	            }
	        }
	 }
}
	        
	    
