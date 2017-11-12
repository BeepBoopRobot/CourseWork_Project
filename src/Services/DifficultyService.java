package Services;

import Models.DifficultySettings;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DifficultyService {
    public static DifficultySettings selectById(int id, DatabaseConnectionService database) {

        DifficultySettings result = null;

        PreparedStatement statement = database.newStatement("SELECT DifficultyID, LevelTime, ObstFreq, PlayerHP FROM Table WHERE DifficultyID");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new DifficultySettings(results.getInt("DifficultyID"), results.getInt("LevelTime"), results.getInt("ObstFreq"), results.getInt("PlayerHP"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }
}
