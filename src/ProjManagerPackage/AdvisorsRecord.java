package ProjManagerPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class AdvisorsRecord {
    String Intake, Spv1, Spv2, Spv3, SecondMkr1, SecondMkr2, SecondMkr3, RMCP_Lecturer;

    public AdvisorsRecord(String Intake, String spv1, String spv2, String spv3, String secondMkr1, String secondMkr2, String secondMkr3, String RMCP_lecturer) {
        this.Intake = Intake;
        this.Spv1 = spv1;
        this.Spv2 = spv2;
        this.Spv3 = spv3;
        this.SecondMkr1 = secondMkr1;
        this.SecondMkr2 = secondMkr2;
        this.SecondMkr3 = secondMkr3;
        this.RMCP_Lecturer = RMCP_lecturer;
    }
    
    public static ArrayList<AdvisorsRecord> AdvisorsRecordData = new ArrayList<>();
    
    // Read all advisor record data from text file
    public static void readFrTxt(){
        try{
            AdvisorsRecordData.clear();
            Scanner scan = new Scanner(new File("AdvisorRecord.txt"));

            // Read all lines
            while(scan.hasNext()){
                String currentLine = scan.nextLine();
                String[] AdvisorRecord_Array = currentLine.split(",");
                
                // Save the data into variables
                String Intake = AdvisorRecord_Array[0];
                String Supervisor1 = AdvisorRecord_Array[1];
                String Supervisor2 = AdvisorRecord_Array[2];
                String Supervisor3 = AdvisorRecord_Array[3];
                String SecondMarker1 = AdvisorRecord_Array[4];
                String SecondMarker2 = AdvisorRecord_Array[5];
                String SecondMarker3 = AdvisorRecord_Array[6];
                String RMCP_Lecturer = AdvisorRecord_Array[7];

                // Add into ArrayList
                AdvisorsRecordData.add(new AdvisorsRecord(Intake, Supervisor1, Supervisor2, Supervisor3, SecondMarker1, SecondMarker2, SecondMarker3, RMCP_Lecturer));
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,"!Read advisor record text file error!");
        }
    }
    
    // Write all student data from ArrayList into text file
    public static void writeToTxt() {
        try {
            PrintWriter write = new PrintWriter(new FileWriter("AdvisorRecord.txt"));

            // Write all student data from the ArrayList into the text file
            for (AdvisorsRecord advisorsRecord : AdvisorsRecordData) {
                String writeInLine = advisorsRecord.Intake + "," + advisorsRecord.Spv1 + "," + advisorsRecord.Spv2 + "," +
                                     advisorsRecord.Spv3 + "," + advisorsRecord.SecondMkr1 + "," +
                                     advisorsRecord.SecondMkr2 + "," + advisorsRecord.SecondMkr3 + "," +
                                     advisorsRecord.RMCP_Lecturer;
                write.println(writeInLine);
            }
            write.close();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"!Write text file error!");
        }
    }
        
    // Get the index of Advisor Records based on inatke from ArrayList
    public static int checkIntake(String intake){
        for (int i=0; i< AdvisorsRecordData.size(); i++){
            if(intake.equals(AdvisorsRecordData.get(i).Intake)){
                return i;
            }
        }
        throw new IllegalArgumentException("Student ID not found: " + intake);
    }
    
    // Edit existing lecturer data in LectData ArrayList
    public static void edit(int index, AdvisorsRecord editedData){
        AdvisorsRecordData.set(index, editedData);
        writeToTxt(); // Update text file
    }
}