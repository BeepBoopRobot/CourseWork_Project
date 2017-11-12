package Models;

import java.util.Date;

public class Game {
    private int instanceID;
    private int userID;
    private Date date;
    private String playTime;

    @Override
    public String toString() {
        return "Game{" +
                "instanceID=" + instanceID +
                ", userID=" + userID +
                ", date=" + date +
                ", playTime='" + playTime + '\'' +
                '}';
    }

    public int getInstanceID() {
        return instanceID;
    }

    public void setInstanceID(int instanceID) {
        this.instanceID = instanceID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return date;
    }

    public String getDateString() { return date.toString(); }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    public Game(int instanceID, int userID, Date date, String playTime) {

        this.instanceID = instanceID;
        this.userID = userID;
        this.date = date;
        this.playTime = playTime;
    }
}
