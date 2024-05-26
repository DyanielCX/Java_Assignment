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
     private static String userID;

    public static String getUserID() {
        return userID;
    }

    public static void setUserID(String userID) {
        Session.userID = userID;
    }

    public static void clearSession() {
        userID = null;
    }

    public static boolean isLoggedIn() {
        return userID != null;
    }
}
