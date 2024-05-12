package ProjManagerPackage;

import ProjManagerPackage.AssignSupvElem.LectData_IO;
import StuPackage.StuData_IO;
import StuPackage.Student;
import assignment_ood.Lecturer;


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
        String RMCP_Lecture = StuData_IO.StuData.get(stuIndex).RMCP_lecture;
        String Password = StuData_IO.StuData.get(stuIndex).password;

        Student editedStudent = new Student(Name, Age, stuID, Intake, Assessment, Supervisor, SecondMaker, RMCP_Lecture, Password);
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
        String RMCP_Lecture = StuData_IO.StuData.get(stuIndex).RMCP_lecture;
        String Password = StuData_IO.StuData.get(stuIndex).password;

        Student editedStudent = new Student(Name, Age, stuID, Intake, Assessment, Supervisor, SecondMaker, RMCP_Lecture, Password);
        StuData_IO.edit(stuIndex, editedStudent);
    }
    
    public static void editLectRole(int lectIndex, boolean isSupervisor, boolean isSecondMarker){
        //Get all the selected lecturer data
        String Name = LectData_IO.LectData.get(lectIndex).lectName;
        String LectID = LectData_IO.LectData.get(lectIndex).lectid;
        boolean IsProjectManager = LectData_IO.LectData.get(lectIndex).isProjectManager;
        boolean IsSecondMarker = isSupervisor;
        boolean IsSupervisor = isSupervisor;
        String password = LectData_IO.LectData.get(lectIndex).password;

        Lecturer editedLecturer = new Lecturer(Name, LectID, IsProjectManager, IsSecondMarker, IsSupervisor, password);
        LectData_IO.edit(lectIndex, editedLecturer);
    }
}
