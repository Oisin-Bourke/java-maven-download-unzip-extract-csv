package model;

import utils.DataCapture;
import java.time.LocalDateTime;

/**
 * User data model class
 */
public class User extends UserInterface {

    private String user_id;
    private LocalDateTime date_joined;
    private long spend;
    private long milliseconds_played;
    private int device_height;
    private int device_width;

    public User() {

    }

    public User(String user_id, LocalDateTime date_joined, long spend, int device_height, int device_width) {
        this.user_id = user_id;
        this.date_joined = date_joined;
        this.spend = spend;
        this.device_height = device_height;
        this.device_width = device_width;
        DataCapture.updateData(this);
    }

    public String getUser_id() {
        return user_id;
    }

    public LocalDateTime getDate_joined() {
        return date_joined;
    }

    public long getSpend() {
        return spend;
    }

    public long getMilliseconds_played() {
        return milliseconds_played;
    }

    public int getDevice_height() {
        return device_height;
    }

    public int getDevice_width() {
        return device_width;
    }

}
