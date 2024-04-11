package StuPackage;

public class Student {
    
    public String name,id,intake,assessment,supervisor,secondMaker;
    public int age;
    
    
    //Create a student object
    public Student(String Name, int Age, String StuID, String Intake, String Assessment, String Supervisor, String SecondMaker){
        name = Name;
        age = Age;
        id = StuID;
        intake = Intake;
        assessment = Assessment;
        supervisor = Supervisor;
        secondMaker = SecondMaker;
    }
}
