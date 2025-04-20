package com.hexaware.dam.exception;

/**
 * Exception thrown when an asset cannot be maintained or a maintenance action fails.
 * This might occur due to invalid asset state, missing records, or failed validations.
 * 
 * @author Shifa Fathima
 * @Date 2025-04-20
 */
public class AssetNotMaintainException extends Exception {

	//Constructs a new AssetNotMaintainException with the specified detail message.
	public AssetNotMaintainException(String message) 
	{
        super(message);
    }
}

