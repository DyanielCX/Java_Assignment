/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_Assignment;

/**
 *
 * @author User
 */
public class Session {
     private static String username;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Session.username = username;
    }

    public static void clearSession() {
        username = null;
    }

    public static boolean isLoggedIn() {
        return username != null;
    }
}
