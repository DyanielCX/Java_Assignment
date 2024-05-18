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
public class classtest {
   public static void main(String args[]) {
       List<Lecturer> lecturers = Admin.readLectData("LecData.txt");
        for (Lecturer lecturer : lecturers) {
        // Print the contents of the parts[] array along with the index of each element
        System.out.println("Lecturer Name: " + lecturer.lectName);
        String[] parts = {lecturer.lectName, lecturer.lectid,
                          String.valueOf(lecturer.isProjectManager), String.valueOf(lecturer.isSecondMarker), 
                          String.valueOf(lecturer.isSupervisor),String.valueOf(lecturer.password)};
        for (int i = 0; i < parts.length; i++) {
            System.out.println("Part " + i + ": " + parts[i]);
        }
        System.out.println(); // Add a newline for clarity
    }
   }
   }

