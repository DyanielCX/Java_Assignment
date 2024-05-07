/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ProjManagerPackage;

/**
 *
 * @author PC
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Intake, Spv1, Spv2, Spv3, SecondMkr1, SecondMkr2, SecondMkr3, RMCP_Lecturer
        String Intake = "UCDF2109";
        String Spv1 = "-";
        String Spv2 = "-";
        String Spv3 = "-";
        String SecondMkr1 = "-";
        String SecondMkr2 = "-";
        String SecondMkr3 = "-";
        String RMCP_Lecturer = "-";
        
        AdvisorsRecord newRecord = new AdvisorsRecord(Intake, Spv1, Spv2, Spv3, SecondMkr1, SecondMkr2, SecondMkr3, RMCP_Lecturer);
        AdvisorsRecord.AdvisorsRecordData.add(newRecord);
        AdvisorsRecord.writeToTxt();
    }
    
}
