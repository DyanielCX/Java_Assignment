/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package StuPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author minya
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fileName = "ConsultationData.txt";
        
        try {
            // Create a File object
            File file = new File(fileName);
            
            // Check if the file already exists
            if (file.exists()) {
                System.out.println("File already exists.");
            } else {
                // Create a new file
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("Failed to create the file.");
                }
            }
            
            // Write content to the file
            FileWriter writer = new FileWriter(file);
            writer.write("Hello, this is a test file.");
            writer.close();
            
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    
}
