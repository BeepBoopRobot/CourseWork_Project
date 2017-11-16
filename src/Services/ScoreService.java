package Services;

import Models.UserScores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ScoreService  {
    public static void selectAll(List<UserScores> targetList, DatabaseConnectionService database) {

        PreparedStatement statement = database.newStatement("SELECT ScoreID, UserID, Score, TopKS, LevelSeed FROM UserScores ORDER BY Score");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new UserScores(results.getInt("ScoreID"), results.getInt("UserID"), results.getString("Score"), results.getInt("TopKS"), results.getString("LevelSeed")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

    public static void save(UserScores itemToSave, DatabaseConnectionService database) {

        UserScores existingItem = null;
        if (itemToSave.getScoreID() != 0) existingItem = selectById(itemToSave.getScoreID(), database);
        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO UserScores (UserID, Score, TopKS, LevelSeed) VALUES (?, ?, ?, ?)");
                statement.setInt(1, itemToSave.getUserID());
                statement.setString(2, itemToSave.getScore());
                statement.setInt(3, itemToSave.getTopKS());
                statement.setString(4, itemToSave.getLevelSeed());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE UserScores SET UserID = ?, Score = ?, TopKS = ?, LevelSeed = ? WHERE ScoreID = ?");
                statement.setInt(1, itemToSave.getUserID());
                statement.setString(2, itemToSave.getScore());
                statement.setInt(3, itemToSave.getTopKS());
                statement.setString(4, itemToSave.getLevelSeed());
                statement.setInt(5, itemToSave.getScoreID());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }

    public static UserScores selectById(int id, DatabaseConnectionService database) {

        UserScores result = null;

        PreparedStatement statement = database.newStatement("SELECT ScoreID, UserID, Score, TopKS, LevelSeed FROM UserScores WHERE ScoreID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new UserScores(results.getInt("ScoreID"), results.getInt("UserID"), results.getString("Score"), results.getInt("TopKS"), results.getString("LevelSeed"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }
}
