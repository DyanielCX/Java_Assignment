package AdminPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class IntakeRecord {
    public String Intake, Assessment, Spv1, Spv2, Spv3, SecondMkr1, SecondMkr2, SecondMkr3, RMCP_Lecturer;

    public IntakeRecord(String Intake, String Assessment, String spv1, String spv2, String spv3, String secondMkr1, String secondMkr2, String secondMkr3, String RMCP_lecturer) {
        this.Intake = Intake;
        this.Assessment = Assessment;
        this.Spv1 = spv1;
        this.Spv2 = spv2;
        this.Spv3 = spv3;
        this.SecondMkr1 = secondMkr1;
        this.SecondMkr2 = secondMkr2;
        this.SecondMkr3 = secondMkr3;
        this.RMCP_Lecturer = RMCP_lecturer;
    }
    
    // Array List for advisor record
    public static ArrayList<IntakeRecord> IntakeRecordData = new ArrayList<>();
    
    // Read all advisor record data from text file
    public static void readFrTxt(){
        try{
            IntakeRecordData.clear();
            Scanner scan = new Scanner(new File("IntakeRecord.txt"));

            // Read all lines
            while(scan.hasNext()){
                String currentLine = scan.nextLine();
                String[] AdvisorRecord_Array = currentLine.split(",");
                
                // Save the data into variables
                String Intake = AdvisorRecord_Array[0];
                String Assessment = AdvisorRecord_Array[1];
                String Supervisor1 = AdvisorRecord_Array[2];
                String Supervisor2 = AdvisorRecord_Array[3];
                String Supervisor3 = AdvisorRecord_Array[4];
                String SecondMarker1 = AdvisorRecord_Array[5];
                String SecondMarker2 = AdvisorRecord_Array[6];
                String SecondMarker3 = AdvisorRecord_Array[7];
                String RMCP_Lecturer = AdvisorRecord_Array[8];

                // Add into ArrayList
                IntakeRecordData.add(new IntakeRecord(Intake, Assessment, Supervisor1, Supervisor2, Supervisor3, SecondMarker1, SecondMarker2, SecondMarker3, RMCP_Lecturer));
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,"!Read advisor record text file error!");
        }
    }
    
    
    // Write all advisor record data from ArrayList into text file
    public static void writeToTxt() {
        try {
            PrintWriter write = new PrintWriter(new FileWriter("IntakeRecord.txt"));

            // Write all student data from the ArrayList into the text file
            for (IntakeRecord advisorsRecord : IntakeRecordData) {
                String writeInLine = advisorsRecord.Intake + "," + advisorsRecord.Assessment + "," +
                                     advisorsRecord.Spv1 + "," + advisorsRecord.Spv2 + "," + advisorsRecord.Spv3 + "," + 
                                     advisorsRecord.SecondMkr1 + "," + advisorsRecord.SecondMkr2 + "," + advisorsRecord.SecondMkr3 + "," +
                                     advisorsRecord.RMCP_Lecturer;
                write.println(writeInLine);
            }
            write.close();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"!Write text file error!");
        }
    }
    
    
    // Get the index of Intake Records based on intake from ArrayList
    public static int checkIntake(String intake){
        for (int i=0; i< IntakeRecordData.size(); i++){
            if(intake.equals(IntakeRecordData.get(i).Intake)){
                return i;
            }
        }
        throw new IllegalArgumentException("Intake not found: " + intake);
    }
    
    // Add new intake record data into intake record ArrayList & text file
    public static void add(IntakeRecord newRecord){
        IntakeRecordData.add(newRecord);
        writeToTxt(); // Update text file
    }
    
    // Edit the intake record data in intake record ArrayList & text file
    public static void edit(int index, IntakeRecord editedData){
        IntakeRecordData.set(index, editedData);
        writeToTxt(); // Update text file
    }
}
