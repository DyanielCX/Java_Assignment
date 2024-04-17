package assignment_ood;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
public class Admin {
   
    private List<Lecturer> lecturers;

    public Admin() {
        
        lecturers = new ArrayList<>();
    }

   

    public void registerLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
        saveLecturersToFile();
    }

    

    public void amendLecturerDetails(String name, String newLecturerId, boolean newIsProjectManager) {
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getName().equals(name)) {
                lecturer.setId(newLecturerId);
                lecturer.setIsProjectManager(newIsProjectManager);
                // You can add more amendments here if needed
                break;
            }
        }
        saveLecturersToFile();
    }

    

    public void removeLecturer(String name) {
        lecturers.removeIf(lecturer -> lecturer.getName().equals(name));
        saveLecturersToFile();
    }

    

    private void saveLecturersToFile() {
       try (FileWriter writer = new FileWriter("lecturers.txt")) {
            for (Lecturer lecturer : lecturers) {
                writer.write(lecturer.getName() + "," + lecturer.getId() + "," + lecturer.isIsProjectManager() + "\n");
            }
            System.out.println("Lecturer data saved to file.");
        } catch (IOException e) {
            System.err.println("Error writing to lecturers file: " + e.getMessage());
        }
    }

   
}
