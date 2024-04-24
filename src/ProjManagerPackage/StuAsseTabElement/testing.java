/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ProjManagerPackage.StuAsseTabElement;

import StuPackage.StuData_IO;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StuData_IO.readFrTxt();
        ArrayList<String> intakeList = IntakeBasedMethod.getIntake();
        
        for (String intake : intakeList){
            String assessment = IntakeBasedMethod.getAssessment(intake);
            System.out.println(intake + " -> " + assessment);
        }
    }
    
}
