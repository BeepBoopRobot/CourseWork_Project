package Services;

import Models.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService {
        public static void selectAll(List<Users> targetList, DatabaseConnectionService database) {

            PreparedStatement statement = database.newStatement("SELECT UserID, Username, HighScore, TopKS, SettingsID FROM Users ORDER BY Score");

            try {
                if (statement != null) {

                    ResultSet results = database.executeQuery(statement);

                    if (results != null) {
                        while (results.next()) {
                            targetList.add(new Users(results.getInt("UserID"), results.getString("Username"), results.getString("HighScore"), results.getInt("TopKS"), results.getInt("SettingsID")));
                        }
                    }
                }
            } catch (SQLException resultsException) {
                System.out.println("Database select all error: " + resultsException.getMessage());
            }
        }

        public static void save(Users itemToSave, DatabaseConnectionService database) {

            Users existingItem = null;
            if (itemToSave.getUserID() != 0) existingItem = selectById(itemToSave.getUserID(), database);
            try {
                if (existingItem == null) {
                    PreparedStatement statement = database.newStatement("INSERT INTO Users (Username, HighScore, TopKS, SettingsID) VALUES (?, ?, ?, ?)");
                    statement.setString(1, itemToSave.getUserName());
                    statement.setString(2, itemToSave.getHighScore());
                    statement.setInt(3, itemToSave.getTopKS());
                    statement.setInt(4, itemToSave.getSettingsID());
                    database.executeUpdate(statement);
                }
                else {
                    PreparedStatement statement = database.newStatement("UPDATE Users SET Username = ?, HighScore = ?, TopKS = ?, SettingsID = ? WHERE UserID = ?");
                    statement.setString(1, itemToSave.getUserName());
                    statement.setString(2, itemToSave.getHighScore());
                    statement.setInt(3, itemToSave.getTopKS());
                    statement.setInt(4, itemToSave.getSettingsID());
                    statement.setInt(5, itemToSave.getUserID());
                    database.executeUpdate(statement);
                }
            } catch (SQLException resultsException) {
                System.out.println("Database saving error: " + resultsException.getMessage());
            }
        }

        public static Users selectById(int id, DatabaseConnectionService database) {

            Users result = null;

            PreparedStatement statement = database.newStatement("SELECT UserID, Username, HighScore, TopKS, SettingsID FROM Users WHERE UserID = ?");

            try {
                if (statement != null) {

                    statement.setInt(1, id);
                    ResultSet results = database.executeQuery(statement);

                    if (results != null) {
                        result = new Users(results.getInt("UserID"), results.getString("Username"), results.getString("HighScore"), results.getInt("TopKS"), results.getInt("SettingsID"));
                    }
                }
            } catch (SQLException resultsException) {
                System.out.println("Database select by id error: " + resultsException.getMessage());
            }

            return result;
        }
    }

