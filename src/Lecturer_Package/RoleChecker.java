/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lecturer_Package;

import Java_Assignment.Session;
import java.util.List;

/**
 *
 * @author User
 */
public class RoleChecker {
    String UserName = Session.getUserID();
    public static boolean isProjectManager(String lecturerName, List<Lecturer> lecturers) {
        for (Lecturer lecturer : lecturers) {
            if (lecturer.lectName.equals(lecturerName)) {
                return lecturer.isProjectManager;
            }
        }
        return false;
    }

    public static boolean isSupervisor(String lecturerName, List<Lecturer> lecturers) {
        for (Lecturer lecturer : lecturers) {
            if (lecturer.lectName.equals(lecturerName)) {
                return lecturer.isSupervisor;
            }
        }
        return false;
    }

    public static boolean isSecondMarker(String lecturerName, List<Lecturer> lecturers) {
        for (Lecturer lecturer : lecturers) {
            if (lecturer.lectName.equals(lecturerName)) {
                return lecturer.isSecondMarker;
            }
        }
        return false;
    }
}
