package database;

import java.util.Date;

public class Employee {
 
    private int empId;
    private String empName;
    private Date dob;
    private double salary;
    private int deptId;
    private int emp_height;
 
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
    public int getDeptId() {
        return deptId;
    }
    public void setEmpHeight(int emp_height) {
        this.emp_height = emp_height;
    }
    public int getEmpHeight() {
        return emp_height;
    }    

 
    //toString()
    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", empName=" + empName + ", dob="
                + dob + ", salary=" + salary + ", deptId=" + deptId + "]";
    }
}