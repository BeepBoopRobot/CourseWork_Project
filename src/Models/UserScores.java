package Models;

public class UserScores {
    private int scoreID;
    private int userID;
    private String score;
    private int topKS;
    private String LevelSeed;

    @Override
    public String toString() {
        return "UserScores{" +
                "scoreID=" + scoreID +
                ", userID=" + userID +
                ", score='" + score + '\'' +
                ", topKS=" + topKS +
                ", LevelSeed='" + LevelSeed + '\'' +
                '}';
    }

    public UserScores(int scoreID, int userID, String score, int topKS, String levelSeed) {
        this.scoreID = scoreID;
        this.userID = userID;
        this.score = score;
        this.topKS = topKS;
        LevelSeed = levelSeed;
    }

    public int getScoreID() {

        return scoreID;
    }

    public void setScoreID(int scoreID) {
        this.scoreID = scoreID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getTopKS() {
        return topKS;
    }

    public void setTopKS(int topKS) {
        this.topKS = topKS;
    }

    public String getLevelSeed() {
        return LevelSeed;
    }

    public void setLevelSeed(String levelSeed) {
        LevelSeed = levelSeed;
    }
}
