/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_ood;

import java.util.List;

/**
 *
 * @author User
 */
public class RoleChecker {
    public static boolean isProjectManager(String lecturerId, List<Lecturer> lecturers) {
        for (Lecturer lecturer : lecturers) {
            if (lecturer.lectid.equals(lecturerId)) {
                return lecturer.isProjectManager;
            }
        }
        return false;
    }

    public static boolean isSupervisor(String lecturerId, List<Lecturer> lecturers) {
        for (Lecturer lecturer : lecturers) {
            if (lecturer.lectid.equals(lecturerId)) {
                return lecturer.isSupervisor;
            }
        }
        return false;
    }

    public static boolean isSecondMarker(String lecturerId, List<Lecturer> lecturers) {
        for (Lecturer lecturer : lecturers) {
            if (lecturer.lectid.equals(lecturerId)) {
                return lecturer.isSecondMarker;
            }
        }
        return false;
    }
}
