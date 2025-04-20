package com.hexaware.dam.exception;

/**
 * Exception thrown when an asset is not found in the system.
 * 
 * @author Pavithra
 * @Date 2025-04-20
 */
public class AssetNotFoundException extends Exception {
	
	//Constructs a new AssetNotFoundException with the specified detail message.
	public AssetNotFoundException(String message) {
        super(message);
    }
	

}
