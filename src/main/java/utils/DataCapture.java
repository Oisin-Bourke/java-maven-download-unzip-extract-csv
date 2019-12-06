package utils;

import model.User;
import java.time.LocalDateTime;

/**
 * Util data capture class that stores the required data
 */

public class DataCapture {

    //Static variables to store required data
    private static long user_count = 0;
    private static long device_resolution_count = 0;
    private static long total_spend = 0;
    private static String firstUserId = null;

    private static LocalDateTime firstUserDate = LocalDateTime.MAX;

    //Update all data
    public static void updateData(User user){
        updateUserCount();
        updateDeviceResolutionCount640_960(user);
        updateTotalSpend(user);
        updateFirstUser(user);
    }

    //Update static variables methods
    private static void updateUserCount() {
        user_count++;
    }

    private static void updateDeviceResolutionCount640_960(User user){
        if (user.getDevice_height() == 960 && user.getDevice_width() == 640) {
            device_resolution_count++;
        }
    }

    private static void updateTotalSpend(User user){
        total_spend += user.getSpend();
    }

    private static void updateFirstUser(User user){
        if (user.getDate_joined().isBefore(firstUserDate)) {
            firstUserDate = user.getDate_joined();
            firstUserId = user.getUser_id();
        }
    }

    //Getters for static variables
    public static long getUserCount(){
        return user_count;
    }

    public static long getDeviceResolutionCount(){
        return device_resolution_count;
    }

    public static long getTotalSpend(){
        return total_spend;
    }

    public static String getFirstUserId(){
        return firstUserId;
    }

}
