package Models;

public class Users {
   private int userID;
   private String userName;
   private String highScore;
   private int topKS;
   private int settingID;

    @Override
    public String toString() {
        return "Users{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", highScore='" + highScore + '\'' +
                ", topKS=" + topKS +
                ", settingID=" + settingID +
                '}';
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHighScore() {
        return highScore;
    }

    public void setHighScore(String highScore) {
        this.highScore = highScore;
    }

    public int getTopKS() {
        return topKS;
    }

    public void setTopKS(int topKS) {
        this.topKS = topKS;
    }

    public int getSettingID() {
        return settingID;
    }

    public void setSettingID(int settingID) {
        this.settingID = settingID;
    }

    public Users(int userID, String userName, String highScore, int topKS, int settingID) {

        this.userID = userID;
        this.userName = userName;
        this.highScore = highScore;
        this.topKS = topKS;
        this.settingID = settingID;
    }
}
