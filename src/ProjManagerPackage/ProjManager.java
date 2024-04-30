package ProjManagerPackage;

import ProjManagerPackage.StuAsseTabElement.IntakeBasedMethod;
import StuPackage.StuData_IO;
import StuPackage.Student;
import javax.swing.JOptionPane;


public class ProjManager {
    
    
    public static void editStuAssessment(int stuIndex, String selectedAssess){

        //Get all the selected student data
        String Name = StuData_IO.StuData.get(stuIndex).name;
        String stuID = StuData_IO.StuData.get(stuIndex).id;
        int Age = StuData_IO.StuData.get(stuIndex).age;
        String Intake = StuData_IO.StuData.get(stuIndex).intake;
        String Assessment = selectedAssess;
        String Supervisor = StuData_IO.StuData.get(stuIndex).supervisor;
        String SecondMaker = StuData_IO.StuData.get(stuIndex).secondMarker;

        Student editedStudent = new Student(Name, Age, stuID, Intake, Assessment, Supervisor, SecondMaker);
        StuData_IO.edit(stuIndex, editedStudent);
    }
}
