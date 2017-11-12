package Models;

public class ObstacleData {
    public String getObstacleName() {
        return ObstacleName;
    }

    public int getObstacleSpeed() {
        return ObstacleSpeed;
    }

    public int getObstacleHP() {
        return ObstacleHP;
    }

    public int ObstacleID;
    public String ObstacleName;
    public int ObstacleSpeed;
    public int ObstacleHP;

    @Override
    public String toString() {
        return "ObstacleData{" +
                "ObstacleID=" + ObstacleID +
                ", ObstacleName='" + ObstacleName + '\'' +
                ", ObstacleSpeed=" + ObstacleSpeed +
                ", ObstacleHP=" + ObstacleHP +
                '}';
    }

    public ObstacleData(int obstacleID, String obstacleName, int obstacleSpeed, int obstacleHP) {
        ObstacleID = obstacleID;
        ObstacleName = obstacleName;
        ObstacleSpeed = obstacleSpeed;
        ObstacleHP = obstacleHP;
    }

    public int getObstacleID() {

        return ObstacleID;
    }
}
