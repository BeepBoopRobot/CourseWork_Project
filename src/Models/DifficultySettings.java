package Models;

public class DifficultySettings {
    private int difficultyID;
    private int levelTime;
    private int obstFreq;
    private int playerHP;

    @Override
    public String toString() {
        return "DifficultySettings{" +
                "difficultyID=" + difficultyID +
                ", levelTime=" + levelTime +
                ", obstFreq=" + obstFreq +
                ", playerHP=" + playerHP +
                '}';
    }

    public void setDifficultyID(int difficultyID) {
        this.difficultyID = difficultyID;
    }

    public int getDifficultyID() {

        return difficultyID;
    }

    public int getLevelTime() {
        return levelTime;
    }

    public int getObstFreq() {
        return obstFreq;
    }

    public int getPlayerHP() {
        return playerHP;
    }

    public DifficultySettings(int difficultyID, int levelTime, int obstFreq, int playerHP) {

        this.difficultyID = difficultyID;
        this.levelTime = levelTime;
        this.obstFreq = obstFreq;
        this.playerHP = playerHP;
    }
}
