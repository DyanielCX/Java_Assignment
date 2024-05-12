package ProjManagerPackage.AssignSupvElem;

import StuPackage.Student;
import assignment_ood.Lecturer;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class LectData_IO {
    // ArrayList to store student data
    public static ArrayList<Lecturer> LectData = new ArrayList<>();
    
    // Read all lecturer data from text file
    public static void readFrTxt(){
        try{
            Scanner scan = new Scanner(new File("LecData.txt"));

            // Read all lines
            while(scan.hasNext()){
                String currentLine = scan.nextLine();
                String[] LectData_Array = currentLine.split(",");
                
                // Save the data into variables
                String Name = LectData_Array[0];
                String LectID = LectData_Array[1];
                boolean isProjectManager = Boolean.parseBoolean(LectData_Array[2]);
                boolean isSecondMarker = Boolean.parseBoolean(LectData_Array[3]);
                boolean isSupervisor = Boolean.parseBoolean(LectData_Array[4]);
                String Password = LectData_Array[5];

                // Add into ArrayList
                LectData.add(new Lecturer(Name, LectID, isProjectManager, isSecondMarker, isSupervisor, Password));
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,"!Read text file error!");
        }
    }
    
    // Write all student data from ArrayList into text file
        public static void writeToTxt() {
            try {
                PrintWriter write = new PrintWriter(new FileWriter("LecData.txt"));

                // Write all student data from the ArrayList into the text file
                for (Lecturer lecturer : LectData) {
                    String writeInLine = lecturer.lectName + "," + lecturer.lectid + "," + lecturer.isProjectManager + "," +
                                         lecturer.isSecondMarker + "," + lecturer.isSupervisor + "," +
                                         lecturer.password;
                    write.println(writeInLine);
                }
                write.close();
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"!Write text file error!");
            }
        }
    
    // Get the index of student based on StuID from ArrayList
    public static int checkStu(String LectID){
        for (int i=0; i< LectData.size(); i++){
            if(LectID.equals(LectData.get(i).lectid)){
                return i;
            }
        }
        throw new IllegalArgumentException("Student ID not found: " + LectID);
    }
    
    // Add new student data into StuData ArrayList
    public static void add(Lecturer newLecturer){
        LectData.add(newLecturer);
        writeToTxt(); // Update text file
    }
    
    // Edit existing student data in StuData ArrayList
    public static void edit(int index, Lecturer editedData){
        LectData.set(index, editedData);
        writeToTxt(); // Update text file
    }
}
