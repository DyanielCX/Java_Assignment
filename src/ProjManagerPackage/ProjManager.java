package ProjManagerPackage;

import StuPackage.StuData_IO;
import StuPackage.Student;
import java.util.Scanner;


public class ProjManager {
    
    
    public static void editStuAssessment(){
        Scanner Sc = new Scanner(System.in);
        System.out.print("Student ID: ");
        String StuID = Sc.nextLine();
        
        int Index = StuData_IO.checkStu(StuID);
        System.out.print("Assessment: ");
        String Assessment = Sc.nextLine();

        
        String Name = StuData_IO.StuData.get(Index).name;
        int Age = StuData_IO.StuData.get(Index).age;
        String Intake = StuData_IO.StuData.get(Index).intake;
        String Supervisor = StuData_IO.StuData.get(Index).supervisor;
        String SecondMaker = StuData_IO.StuData.get(Index).secondMaker;
        
        Student Edited_Student = new Student(Name, Age, StuID, Intake, Assessment, Supervisor, SecondMaker);
        StuData_IO.edit(Index, Edited_Student);
    }
}
