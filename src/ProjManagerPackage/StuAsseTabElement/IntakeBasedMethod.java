
package ProjManagerPackage.StuAsseTabElement;

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
}
