
package com.Model;

public class Session {
    protected int id;
    protected String name;
    protected String branch;
    protected String type;
    protected String status;
    public Session() {}
    public Session(String name, String branch, String type, String status) {
    super();
    this.name = name;
    this.branch = branch;
    this.type = type;
    this.status = status;
    }
    public Session(int id, String name, String branch, String type, String status) {
    super();
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.type = type;
        this.status = status;  
    }

    public Session(int id, String name, String branch, String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int getId() {
    return id;
    }
    public void setId(int id) {
    this.id = id;
    }
    public String getName() {
    return name;
    }
    public void setName(String name) {
    this.name = name;
    }
    public String getBranch() {
    return branch;
    }
    public void setBranch(String branch) {
    this.branch = branch;
    }
    public String getType() {
    return type;
    }
    public void setType(String type) {
    this.type = type;
    }
    public String getStatus() {
    return status;
    }
    public void setStatus(String status) {
    this.status = status;
    }
    
}
