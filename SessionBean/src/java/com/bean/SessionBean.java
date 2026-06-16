/*
 . JavaBean/Model (10 Marks): Create a JavaBean class named SessionBean.java. 
a. Declare all the corresponding private variables. 
b. Generate an empty constructor and a parameterized constructor. 
c. Generate standard getter and setter methods for all variables. 
*/
package com.bean;

public class SessionBean {
    private String name;
    private String branch;
    private String type;
    private String status;
    
    public SessionBean() {
    }
    
    public String getName() {
    return name;
    }
    public void setName(String setName) {
    this.name = name;
    }
    
        public String getBranch() {
    return branch;
    }
    public void setBranch(String setBranch) {
    this.branch = branch;
    }
    
        public String getType() {
    return type;
    }
    public void setType(String setType) {
    this.type = type;
    }
    
        public String getStatus() {
    return status;
    }
    public void setStatus(String setStatus) {
    this.status = status;
    }
}
