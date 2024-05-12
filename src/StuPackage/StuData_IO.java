package StuPackage;



import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class StuData_IO {
    // ArrayList to store student data
    public static ArrayList<Student> StuData = new ArrayList<>();
    
    // Read all student data from text file
    public static void readFrTxt(){
        try{
            Scanner scan = new Scanner(new File("StuData.txt"));

            // Read all lines
            while(scan.hasNext()){
                String currentLine = scan.nextLine();
                String[] StuData_Array = currentLine.split(",");
                
                // Save the data into variables
                String Name = StuData_Array[0];
                int Age = Integer.parseInt(StuData_Array[1]);
                String StuID = StuData_Array[2];
                String Intake = StuData_Array[3];
                String Assessment = StuData_Array[4];
                String Supervisor = StuData_Array[5];
                String SecondMarker = StuData_Array[6];
                String RMCP_Lecture = StuData_Array[7];
                String Password = StuData_Array[8];

                // Add into ArrayList
                StuData.add(new Student(Name, Age, StuID, Intake, Assessment, Supervisor, SecondMarker, RMCP_Lecture, Password));
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,"!Read text file error!");
        }
    }
    
    // Write all student data from ArrayList into text file
        public static void writeToTxt() {
            try {
                PrintWriter write = new PrintWriter(new FileWriter("StuData.txt"));

                // Write all student data from the ArrayList into the text file
                for (Student student : StuData) {
                    String writeInLine = student.name + "," + student.age + "," + student.id + "," +
                                         student.intake + "," + student.assessment + "," +
                                         student.supervisor + "," + student.secondMarker + "," +
                                         student.RMCP_lecture + "," + student.password;
                    write.println(writeInLine);
                }
                write.close();
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"!Write text file error!");
            }
        }
    
    // Get the index of student based on StuID from ArrayList
    public static int checkStu(String StuID){
        for (int i=0; i< StuData.size(); i++){
            if(StuID.equals(StuData.get(i).id)){
                return i;
            }
        }
        throw new IllegalArgumentException("Student ID not found: " + StuID);
    }
    
    // Add new student data into StuData ArrayList
    public static void add(Student newStudent){
        StuData.add(newStudent);
        writeToTxt(); // Update text file
    }
    
    // Edit existing student data in StuData ArrayList
    public static void edit(int index, Student editedData){
        StuData.set(index, editedData);
        writeToTxt(); // Update text file
    }
    
    // Remove existing student data from StuData ArrayList
    public static void remove(String stuID){
        try {
            int studentIndex = -1;
            for (int i = 0; i < StuData.size(); i++) {
                if (stuID.equals(StuData.get(i).id)) {
                    studentIndex = i;
                    break;
                }
            }
            if (studentIndex != -1) {
                StuData.remove(studentIndex);
                writeToTxt(); // Update text file
                System.out.println("Student removed successfully.");
            } else {
                System.out.println("Student ID not found: " + stuID);
            }
        } catch (Exception ex) {
            System.out.println("Error removing student: " + ex.getMessage());
        }
    }
}
