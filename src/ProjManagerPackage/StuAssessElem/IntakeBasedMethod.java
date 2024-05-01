
package ProjManagerPackage.StuAssessElem;

import StuPackage.StuData_IO;
import StuPackage.Student;
import java.util.ArrayList;

public class IntakeBasedMethod {
    
    public static ArrayList getIntake(){
        ArrayList<String> intakeList = new ArrayList<>();
        
        for (Student stu:StuData_IO.StuData){
            String scanIntake = stu.intake;
            
            //Checking whether the intake is exist, if not add into array
            if (!intakeList.contains(scanIntake)) {
                intakeList.add(scanIntake);
            }
        }
        return intakeList;
    }
    
    public static String getAssessment(String intake){
        int checkNum = 0;
        String assessment = "";
        
        for (Student stu:StuData_IO.StuData){
            if(stu.intake.equals(intake)){
                
                //Move to next loop when assessment is "-"
                if (!stu.assessment.equals("-")) {
                    if (checkNum == 0) {
                        assessment = stu.assessment;
                    }
                    
                    if (stu.assessment.equals(assessment)) {
                        checkNum ++;
                    }
                    else{
                        assessment = stu.assessment;
                        checkNum = 1;
                    }
                }
            }
            if (checkNum == 3) {
                return assessment;
            }
        }
        assessment = "-";
        return assessment;
    }
    
    public static void editAssessment(String intake, String selectedAss){
        
        for (int Index = 0; Index < StuData_IO.StuData.size();Index ++){
            if (StuData_IO.StuData.get(Index).intake.equals(intake)) {
                //Get all the selected student data
                String Name = StuData_IO.StuData.get(Index).name;
                int Age = StuData_IO.StuData.get(Index).age;
                String stuID = StuData_IO.StuData.get(Index).id;
                String Intake = intake;
                String Assessment = selectedAss;
                String Supervisor = StuData_IO.StuData.get(Index).supervisor;
                String SecondMaker = StuData_IO.StuData.get(Index).secondMarker;

                //Update the edited data into ArrayList
                Student Edited_Student = new Student(Name, Age, stuID, Intake, Assessment, Supervisor, SecondMaker);
                StuData_IO.edit(Index, Edited_Student);
            }
        }
    }
    
    public static boolean checkAssessment(String stuIntake, String selectedAss){
        String actualAss = getAssessment(stuIntake);
        
        if (selectedAss.equals(actualAss) || selectedAss.equals("-") || actualAss.equals("-")){
            return true;
        }
        return false;
    }
}
