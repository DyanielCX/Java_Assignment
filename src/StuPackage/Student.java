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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntake() {
        return intake;
    }

    public void setIntake(String intake) {
        this.intake = intake;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getSecondMarker() {
        return secondMarker;
    }

    public void setSecondMarker(String secondMarker) {
        this.secondMarker = secondMarker;
    }

    public String getRMCP_lecture() {
        return RMCP_lecture;
    }

    public void setRMCP_lecture(String RMCP_lecture) {
        this.RMCP_lecture = RMCP_lecture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
