/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_ood;

import java.util.List;


public class Lecturer {
    private String lectname;
    private String lectid;
     private boolean isProjectManager;
     private boolean isSecondMarker;
     private boolean isSupervisor;
     private List<Lecturer> lecturers;
     
    public Lecturer(String name, String lectid, boolean isProjectManager, boolean isSecondMarker, boolean isSupervisor) {
        this.lectname = lectname;
        this.lectid = lectid;
        this.isProjectManager = isProjectManager;
        this.isSecondMarker = isSecondMarker;
        this.isSupervisor = isSupervisor;
    }
    public Lecturer(String name, String lectid) {
    this.lectname = name;
    this.lectid = lectid;
    this.isProjectManager = false; // Assuming default value for isProjectManager
}

    public boolean isIsSecondMarker() {
        return isSecondMarker;
    }

    public void setIsSecondMarker(boolean isSecondMarker) {
        this.isSecondMarker = isSecondMarker;
    }

    public boolean isIsSupervisor() {
        return isSupervisor;
    }

    public void setIsSupervisor(boolean isSupervisor) {
        this.isSupervisor = isSupervisor;
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

