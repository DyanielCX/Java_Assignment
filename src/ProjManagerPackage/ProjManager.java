package ProjManagerPackage;

import ProjManagerPackage.AssignSupvElem.IntakeRecord;
import ProjManagerPackage.AssignSupvElem.LectData_IO;
import StuPackage.StuData_IO;
import static StuPackage.StuData_IO.StuData;
import StuPackage.Student;
import assignment_ood.Lecturer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class ProjManager {
    
    public static void editIntakeAssessment(String selectedIntake, String selectedAssess){
        // Get selected intake position
        int intakeIndex = IntakeRecord.checkIntake(selectedIntake);
        
        //Get all intake record data
        String Spv1 = IntakeRecord.IntakeRecordData.get(intakeIndex).Spv1;
        String Spv2 = IntakeRecord.IntakeRecordData.get(intakeIndex).Spv2;
        String Spv3 = IntakeRecord.IntakeRecordData.get(intakeIndex).Spv3;
        String SecondMkr1 = IntakeRecord.IntakeRecordData.get(intakeIndex).SecondMkr1;
        String SecondMkr2 = IntakeRecord.IntakeRecordData.get(intakeIndex).SecondMkr2;
        String SecondMkr3 = IntakeRecord.IntakeRecordData.get(intakeIndex).SecondMkr3;
        String RMCP_Lect = IntakeRecord.IntakeRecordData.get(intakeIndex).RMCP_Lecturer;
        
        // Update the intake record data
        IntakeRecord editedRecord = new IntakeRecord(selectedIntake, selectedAssess, Spv1, Spv2, Spv3, SecondMkr1, SecondMkr2, SecondMkr3, RMCP_Lect);
        IntakeRecord.edit(intakeIndex, editedRecord);
    }
    
    public static void editStuAssessment(int stuIndex, String selectedAssess){

        /* Edit the StuData.txt file */
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

        // Update the student data
        Student editedStudent = new Student(Name, Age, stuID, Intake, Assessment, Supervisor, SecondMaker, RMCP_Lecture, Password);
        StuData_IO.edit(stuIndex, editedStudent);
        
        
        /* Edit in ReportData.txt file */
        ArrayList<String> StuData = new ArrayList<>();
        // Read data from text file
        try{
            Scanner scan = new Scanner(new File("ReportData.txt"));
            String line;

            // Read all lines and modified the assessment of selected student
            while(scan.hasNext()){
                String currentLine = scan.nextLine();
                String[] StuData_Array = currentLine.split(",");
                
                if (StuData_Array[0].trim().equals(stuID)) {
                    StuData_Array[1] = selectedAssess;
                }

                // Add into ArrayList
                line = String.join(",", StuData_Array);
                StuData.add(line);
            }
            
            // Write the updated contents back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("ReportData.txt"))) {
                for (String eachLine : StuData) {
                    writer.write(eachLine);
                    writer.newLine();
                }
            } 
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,"!Edit student assessment error!");
        }   
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

        // Update the student data
        Student editedStudent = new Student(Name, Age, stuID, Intake, Assessment, Supervisor, SecondMaker, RMCP_Lecture, Password);
        StuData_IO.edit(stuIndex, editedStudent);
    }
    
    public static void editLectAcc(int lectIndex, String editedName, String editedID){
        
        //Get all the selected lecturer data
        String Name = editedName;
        String LectID = editedID;
        boolean IsProjectManager = LectData_IO.LectData.get(lectIndex).isProjectManager;
        boolean IsSecondMarker = LectData_IO.LectData.get(lectIndex).isSecondMarker;
        boolean IsSupervisor = LectData_IO.LectData.get(lectIndex).isSupervisor;
        String password = LectData_IO.LectData.get(lectIndex).password;

        // Update the lecturer data
        Lecturer editedLecturer = new Lecturer(Name, LectID, IsProjectManager, IsSecondMarker, IsSupervisor, password);
        LectData_IO.edit(lectIndex, editedLecturer);
    }
    
    public static void editLectRole(int lectIndex, boolean isSupervisor, boolean isSecondMarker){
        
        //Get all the selected lecturer data
        String Name = LectData_IO.LectData.get(lectIndex).lectName;
        String LectID = LectData_IO.LectData.get(lectIndex).lectid;
        boolean IsProjectManager = LectData_IO.LectData.get(lectIndex).isProjectManager;
        boolean IsSecondMarker = isSecondMarker;
        boolean IsSupervisor = isSupervisor;
        String password = LectData_IO.LectData.get(lectIndex).password;

        // Update the lecturer data
        Lecturer editedLecturer = new Lecturer(Name, LectID, IsProjectManager, IsSecondMarker, IsSupervisor, password);
        LectData_IO.edit(lectIndex, editedLecturer);
    }
    
    public static void autoAssignAdvisor(String selectedIntake, String selectedAsses){

        /* Common Condition */
        if (selectedAsses.equals("Investigation Report") || selectedAsses.equals("CP1") || selectedAsses.equals("CP2") || selectedAsses.equals("FYP")) {
            //Get advisor list
            int intakeIndex = IntakeRecord.checkIntake(selectedIntake);
            IntakeRecord intakeData = IntakeRecord.IntakeRecordData.get(intakeIndex);

            String[] SpvList = {intakeData.Spv1, intakeData.Spv2, intakeData.Spv3};
            String[] SecondMkrList = {intakeData.SecondMkr1, intakeData.SecondMkr2, intakeData.SecondMkr3};

            // Set the count range variable
            int spvCount = 0;
            int secondMkrCount = 0;

            // Auto Assign to Student
            for (int stuIndex = 0; stuIndex < StuData_IO.StuData.size();stuIndex ++){
                if (StuData_IO.StuData.get(stuIndex).intake.equals(selectedIntake)) {
                    String assignedSecondMkr = null;
                    String assignedSpv = null;

                    //Assign supervisor
                    while(true){
                        if (!SpvList[spvCount].equals("-")) {
                            assignedSpv = SpvList[spvCount];
                            spvCount ++;
                            
                            //Reset spvCount
                            if (spvCount == 3) {
                                spvCount = 0;
                            }
                            break;
                        }
                        else{
                            spvCount ++;
                            
                            //Reset spvCount
                            if (spvCount == 3) {
                                spvCount = 0;
                            }
                        }
                    }

                    //Assign second marker
                    while(true){
                        if (!SecondMkrList[secondMkrCount].equals(assignedSpv) && !SecondMkrList[secondMkrCount].equals("-")) {
                            assignedSecondMkr = SecondMkrList[secondMkrCount];
                            secondMkrCount ++;

                            //Reset secondMkrCount
                            if (secondMkrCount == 3) {
                                secondMkrCount = 0;
                            }
                            break;
                        }
                        else{
                            secondMkrCount ++;
                            
                            if (secondMkrCount == 3) {
                                if (spvCount!=1) {
                                    assignedSpv = SpvList[1];
                                }
                                else{
                                    assignedSpv = SpvList[0];
                                }
                                secondMkrCount = 0;
                            }
                        } 
                    }


                    //Get student data
                    String Name = StuData_IO.StuData.get(stuIndex).name;
                    int Age = StuData_IO.StuData.get(stuIndex).age;
                    String stuID = StuData_IO.StuData.get(stuIndex).id;
                    String Intake = StuData_IO.StuData.get(stuIndex).intake;
                    String Assessment = StuData_IO.StuData.get(stuIndex).assessment;
                    String Supervisor = assignedSpv;
                    String SecondMaker = assignedSecondMkr;
                    String RMCP_Lecture = "-";
                    String Password = StuData_IO.StuData.get(stuIndex).password;

                    // Update the student data
                    Student editedStudent = new Student(Name, Age, stuID, Intake, Assessment, Supervisor, SecondMaker, RMCP_Lecture, Password);
                    StuData_IO.edit(stuIndex, editedStudent);
                }
            }
        }
        
        /* Intern Condition */
        else if (selectedAsses.equals("Intern")) {
            //Get advisor list
            int intakeIndex = IntakeRecord.checkIntake(selectedIntake);
            IntakeRecord intakeData = IntakeRecord.IntakeRecordData.get(intakeIndex);

            String[] SpvList = {intakeData.Spv1, intakeData.Spv2, intakeData.Spv3};

            // Auto Assign to Student
            int spvCount = 0;

            for (int stuIndex = 0; stuIndex < StuData_IO.StuData.size();stuIndex ++){
                if (StuData_IO.StuData.get(stuIndex).intake.equals(selectedIntake)) {
                    String assignedSecondMkr = null;
                    String assignedSpv = null;

                    //Assign supervisor
                    while(true){
                        if (!SpvList[spvCount].equals("-")) {
                            assignedSpv = SpvList[spvCount];
                            spvCount ++;
                            
                            //Reset spvCount
                            if (spvCount == 3) {
                                spvCount = 0;
                            }
                            break;
                        }
                        else{
                            spvCount ++;
                            
                            //Reset spvCount
                            if (spvCount == 3) {
                                spvCount = 0;
                            }
                        }
                    }

                    //Get student data
                    String Name = StuData_IO.StuData.get(stuIndex).name;
                    int Age = StuData_IO.StuData.get(stuIndex).age;
                    String stuID = StuData_IO.StuData.get(stuIndex).id;
                    String Intake = StuData_IO.StuData.get(stuIndex).intake;
                    String Assessment = StuData_IO.StuData.get(stuIndex).assessment;
                    String Supervisor = assignedSpv;
                    String SecondMaker = assignedSecondMkr;
                    String RMCP_Lecture = "-";
                    String Password = StuData_IO.StuData.get(stuIndex).password;

                    // Update the student data
                    Student editedStudent = new Student(Name, Age, stuID, Intake, Assessment, Supervisor, SecondMaker, RMCP_Lecture, Password);
                    StuData_IO.edit(stuIndex, editedStudent);
                }
            }
        }
        
        /* RMCP Condition */
        else if (selectedAsses.equals("RMCP")) {
            //Get advisor list
            int intakeIndex = IntakeRecord.checkIntake(selectedIntake);
            IntakeRecord intakeData = IntakeRecord.IntakeRecordData.get(intakeIndex);

            String RMCP_Lect = intakeData.RMCP_Lecturer;

            // Auto Assign to Student
            for (int stuIndex = 0; stuIndex < StuData_IO.StuData.size();stuIndex ++){
                if (StuData_IO.StuData.get(stuIndex).intake.equals(selectedIntake)) {

                    //Get student data
                    String Name = StuData_IO.StuData.get(stuIndex).name;
                    int Age = StuData_IO.StuData.get(stuIndex).age;
                    String stuID = StuData_IO.StuData.get(stuIndex).id;
                    String Intake = StuData_IO.StuData.get(stuIndex).intake;
                    String Assessment = StuData_IO.StuData.get(stuIndex).assessment;
                    String Supervisor = "-";
                    String SecondMaker = "-";
                    String RMCP_Lecture = RMCP_Lect;
                    String Password = StuData_IO.StuData.get(stuIndex).password;

                    // Update the student data
                    Student editedStudent = new Student(Name, Age, stuID, Intake, Assessment, Supervisor, SecondMaker, RMCP_Lecture, Password);
                    StuData_IO.edit(stuIndex, editedStudent);
                }
            }
        } 
    }
    
    public static void manualAssignStuAdvs(int stuIndex, String selectedSpv, String selectedSecondMkr, String selectedRMCP_Lect){
        
        //Get all the selected student data
        String Name = StuData_IO.StuData.get(stuIndex).name;
        int Age = StuData_IO.StuData.get(stuIndex).age;
        String stuID = StuData_IO.StuData.get(stuIndex).id;
        String Intake = StuData_IO.StuData.get(stuIndex).intake;
        String Assessment = StuData_IO.StuData.get(stuIndex).assessment;
        String Supervisor = selectedSpv;
        String SecondMaker = selectedSecondMkr;
        String RMCP_Lecture = selectedRMCP_Lect;
        String Password = StuData_IO.StuData.get(stuIndex).password;

        // Update the student data
        Student editedStudent = new Student(Name, Age, stuID, Intake, Assessment, Supervisor, SecondMaker, RMCP_Lecture, Password);
        StuData_IO.edit(stuIndex, editedStudent);
    }
}
