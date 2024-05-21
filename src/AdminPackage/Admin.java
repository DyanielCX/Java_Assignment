package AdminPackage;

import StuPackage.StuData_IO;
import StuPackage.Student;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Admin {
    
    public static void addNewIntake(String newIntake){
        
        // Add a new intake
        IntakeRecord newRecord = new IntakeRecord(newIntake, "-", "-", "-", "-", "-", "-", "-", "-");
        IntakeRecord.add(newRecord);
    }
    
    public static void editIntake(String oriIntake, String editedIntake, String selectedAssess){
        // Get selected intake position
        int intakeIndex = IntakeRecord.checkIntake(oriIntake);
        
        //Get all intake record data
        String Spv1 = IntakeRecord.IntakeRecordData.get(intakeIndex).Spv1;
        String Spv2 = IntakeRecord.IntakeRecordData.get(intakeIndex).Spv2;
        String Spv3 = IntakeRecord.IntakeRecordData.get(intakeIndex).Spv3;
        String SecondMkr1 = IntakeRecord.IntakeRecordData.get(intakeIndex).SecondMkr1;
        String SecondMkr2 = IntakeRecord.IntakeRecordData.get(intakeIndex).SecondMkr2;
        String SecondMkr3 = IntakeRecord.IntakeRecordData.get(intakeIndex).SecondMkr3;
        String RMCP_Lect = IntakeRecord.IntakeRecordData.get(intakeIndex).RMCP_Lecturer;
        
        // Update the intake record data
        IntakeRecord editedRecord = new IntakeRecord(editedIntake, selectedAssess, Spv1, Spv2, Spv3, SecondMkr1, SecondMkr2, SecondMkr3, RMCP_Lect);
        IntakeRecord.edit(intakeIndex, editedRecord);
    }
    
    public static void editStuAssessment(int stuIndex, String editedIntake, String selectedAssess){

        /* Edit the StuData.txt file */
        //Get all the selected student data
        String Name = StuData_IO.StuData.get(stuIndex).name;
        int Age = StuData_IO.StuData.get(stuIndex).age;
        String stuID = StuData_IO.StuData.get(stuIndex).id;
        String Intake = editedIntake;
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
}
