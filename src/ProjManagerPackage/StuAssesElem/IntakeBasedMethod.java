
package ProjManagerPackage.StuAssesElem;

import StuPackage.StuData_IO;
import StuPackage.Student;
import java.util.ArrayList;

public class IntakeBasedMethod {
    
    // Collect all exist intake
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
    
    
    // Get the assessment based on selected intake
    public static String getAssessment(String selectedIntake){
        int checkNum = 0;
        String assessment = "";
        
        for (Student stu:StuData_IO.StuData){
            if(stu.intake.equals(selectedIntake)){
                
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
    
   
    // check the assessment based on student intake
    public static boolean checkAssessment(String stuIntake, String selectedAss){
        String actualAss = getAssessment(stuIntake);
        
        if (selectedAss.equals(actualAss) || selectedAss.equals("-") || actualAss.equals("-")){
            return true;
        }
        return false;
    }
}
