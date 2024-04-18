/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_ood;


public class Lecturer {
    private String lectname;
    private String lectid;
     private boolean isProjectManager;

    public Lecturer(String name, String lectid, boolean isProjectManager) {
        this.lectname = lectname;
        this.lectid = lectid;
        this.isProjectManager = isProjectManager;
    }
    public Lecturer(String name, String lectid) {
    this.lectname = name;
    this.lectid = lectid;
    this.isProjectManager = false; // Assuming default value for isProjectManager
}

    public String getName() {
        return lectname;
    }

    public void setName(String name) {
        this.lectname = name;
    }

    public String getId() {
        return lectid;
    }

    public void setId(String id) {
        this.lectid = id;
    }

    public boolean isIsProjectManager() {
        return isProjectManager;
    }

    public void setIsProjectManager(boolean isProjectManager) {
        this.isProjectManager = isProjectManager;
    }
     
     
     public void assignProjectManagerRole() {
        isProjectManager = true;
    }
     public void removeProjectManagerRole() {
        isProjectManager = false;
    }
}
