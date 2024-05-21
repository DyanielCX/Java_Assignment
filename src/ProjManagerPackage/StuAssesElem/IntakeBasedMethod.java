
package ProjManagerPackage.StuAssesElem;

import AdminPackage.IntakeRecord;
import java.util.ArrayList;

public class IntakeBasedMethod {
    
    // Collect all exist intake
    public static ArrayList getIntake(){
        ArrayList<String> intakeList = new ArrayList<>();
        
        for (IntakeRecord intakeData:IntakeRecord.IntakeRecordData){
            String scanIntake = intakeData.Intake;
            intakeList.add(scanIntake);
        }
        return intakeList;
    }
    
    
    // Get the assessment based on selected intake
    public static String getAssessment(String selectedIntake){
        int intakeIndex = IntakeRecord.checkIntake(selectedIntake);
        String assessment = IntakeRecord.IntakeRecordData.get(intakeIndex).Assessment;
        
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
