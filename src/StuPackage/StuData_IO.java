package StuPackage;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class StuData_IO {
    public static ArrayList<Student> StuData = new ArrayList<>();
    
    //Read all student data from text file
    public static void readFrTxt(){
        try{
            Scanner scan = new Scanner(new File("StuData.txt"));

            //read all line
            while(scan.hasNext()){
                String currentLine = scan.nextLine();
                String[] StuData_Array = currentLine.split(",");
                
                //save the data into variable
                String Name = StuData_Array[0];
                int Age = Integer.parseInt(StuData_Array[1]);
                String StuID = StuData_Array[2];
                String Intake = StuData_Array[3];
                String Assessment = StuData_Array[4];
                String Supervisor = StuData_Array[5];
                String SecondMaker = StuData_Array[6];

                //add into array list
                StuData.add(new Student(Name, Age, StuID, Intake, Assessment, Supervisor,SecondMaker));
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,"!Read text file error!");
        }
    }
    
    //Write all student data from ArrayList into text file
    public static void writeToTxt() {
        try {
            PrintWriter write = new PrintWriter("StuData.txt");

            //write the drink detail into text file
            for (int i=0; i< StuData.size(); i++){
                String Name = StuData.get(i).name;
                String Age = Integer.toString(StuData.get(i).age);
                String StuID = StuData.get(i).id;
                String Intake = StuData.get(i).intake;
                String Assessment = StuData.get(i).assessment;
                String Supervisor = StuData.get(i).supervisor;
                String SecondMaker = StuData.get(i).secondMaker;
                
                //Write all StuData in a line and write into text file
                String writeInLine = Name + "," + Age+ "," + StuID + "," + Intake + "," + Assessment + "," + Supervisor + "," + SecondMaker;
                write.println(writeInLine);
            }
            write.close();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"!Write text file error!");
        }
    }
    
    //Get the index of student based on StuID from ArrayList
    public static int checkStu(String StuID){
        for (int i=0; i< StuData.size(); i++){
            if(StuID.equals(StuData.get(i).id)){
                return i;
            }
        }
        throw new IllegalArgumentException("Student ID not found: " + StuID);
    }
    
    
    
    //Add new student data into StuData ArrayList
    public static void add(){
        
    }
    
    //..
    //Edit existed student data in StuData ArrayList
    public static void edit(int Index, Student EditedData){
        StuData.set(Index, EditedData);
        writeToTxt();
    }
    
    //Remove existed student data from StuData ArrayList
    public static void remove(){
        
    }
}
