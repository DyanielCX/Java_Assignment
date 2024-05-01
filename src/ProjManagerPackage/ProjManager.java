package ProjManagerPackage;

import ProjManagerPackage.StuAssessElem.IntakeBasedMethod;
import StuPackage.StuData_IO;
import StuPackage.Student;
import javax.swing.JOptionPane;


public class ProjManager {
    
    
    public static void editStuAssessment(int stuIndex, String selectedAssess){

        //Get all the selected student data
        String Name = StuData_IO.StuData.get(stuIndex).name;
        int Age = StuData_IO.StuData.get(stuIndex).age;
        String stuID = StuData_IO.StuData.get(stuIndex).id;
        String Intake = StuData_IO.StuData.get(stuIndex).intake;
        String Assessment = selectedAssess;
        String Supervisor = StuData_IO.StuData.get(stuIndex).supervisor;
        String SecondMaker = StuData_IO.StuData.get(stuIndex).secondMarker;

        Student editedStudent = new Student(Name, Age, stuID, Intake, Assessment, Supervisor, SecondMaker);
        StuData_IO.edit(stuIndex, editedStudent);
    }
    
    public static void editStuAcc(int stuIndex, String editedName, String editedID, int editedAge, String editedIntake){
        //Get all the selected student data
        String Name = editedName;
        int Age = editedAge;
        String stuID = editedID;
        String Intake = editedIntake;
        String Assessment = StuData_IO.StuData.get(stuIndex).assessment;
        String Supervisor = StuData_IO.StuData.get(stuIndex).supervisor;
        String SecondMaker = StuData_IO.StuData.get(stuIndex).secondMarker;

        Student editedStudent = new Student(Name, Age, stuID, Intake, Assessment, Supervisor, SecondMaker);
        StuData_IO.edit(stuIndex, editedStudent);
    }
}
