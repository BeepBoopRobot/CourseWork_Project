package Services;

import Models.ObstacleData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ObstacleService {
    public static ObstacleData selectById(int id, DatabaseConnectionService database) {

        ObstacleData result = null;

        PreparedStatement statement = database.newStatement("SELECT ObstacleID, ObstacleName, ObstacleSpeed, ObstacleHP FROM ObstacleData WHERE ObstacleID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new ObstacleData(results.getInt("ObstacleID"), results.getString("ObstacleName"), results.getInt("ObstacleSpeed"), results.getInt("ObstacleHP"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }
}
