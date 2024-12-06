package model;

import java.time.LocalDate;

public class MtEmployee {
    private int employeeCode;
    private String employeeName;
    private int employeeAge;
    private LocalDate dateOfBirth;

    public MtEmployee() {	
	}
    
    
    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public void print(MtEmployee e) {
        System.out.println(e.getEmployeeCode() + " - " + e.getEmployeeName() + " - " + e.getEmployeeAge() + " - " + e.getDateOfBirth());
    }

}
