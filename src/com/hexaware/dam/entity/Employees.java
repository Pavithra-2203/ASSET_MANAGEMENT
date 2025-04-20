package com.hexaware.dam.entity;
/**
 * Represents an employee in the Digital Asset Management system.
 * This class contains all the details about an employee, including their ID, name, 
 * department, email, and password.
 * @author Shifa Fathima
 * @date 20-04-2025
 */
public class Employees {

    private int employeeId;    // Unique identifier for the employee
    private String name;       // Name of the employee
    private String department; // Department the employee belongs to
    private String email;      // Email address of the employee
    private String password;   // Password for the employee's account

    /**
     * Default constructor for creating an empty Employees object.
     * This can be used when creating a new employee object.
     */
    public Employees() {
    }

    // Parameterized constructor to create a new Employees object with the given details.
     
	public Employees(int employeeId, String name, String department, String email, String password) 
	{
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.department = department;
		this.email = email;
		this.password = password;
	}

	//Getters and Setters
	public int getEmployeeId() {
		return employeeId;
	}
	

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
