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
       List<Lecturer> lecturers = Admin.readLecturersFromFile();
        for (Lecturer lecturer : lecturers) {
        System.out.println(lecturer.getName());
    }
   }
   }

