package StuPackage;



public class Student {
    
    public String name,id,intake,assessment,supervisor,secondMarker,RMCP_lecture,password;
    public int age;
    
    
    //Create a student object
    public Student(String Name, int Age, String StuID, String Intake, String Assessment, String Supervisor, String SecondMarker, String RMCP_Lecture, String Password){
        name = Name;
        age = Age;
        id = StuID;
        intake = Intake;
        assessment = Assessment;
        supervisor = Supervisor;
        secondMarker = SecondMarker;
        RMCP_lecture = RMCP_Lecture;
        password = Password;
    }
}
