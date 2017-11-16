package Services;

import Models.UserSettings;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SettingService {
        public static void selectAll(List<UserSettings> targetList, DatabaseConnectionService database) {

            PreparedStatement statement = database.newStatement("SELECT SettingsID, DifficultyID, MusicVol, SoundVol, ScreenSizeID, LevelSeed FROM UserSettings ORDER BY Score");

            try {
                if (statement != null) {

                    ResultSet results = database.executeQuery(statement);

                    if (results != null) {
                        while (results.next()) {
                            targetList.add(new UserSettings(results.getInt("SettingsID"), results.getInt("DifficultyID"), results.getInt("MusicVol"), results.getInt("SoundVol"), results.getInt("ScreenSizeID"), results.getString("LevelSeed")));
                        }
                    }
                }
            } catch (SQLException resultsException) {
                System.out.println("Database select all error: " + resultsException.getMessage());
            }
        }

        public static void save(UserSettings itemToSave, DatabaseConnectionService database) {

            UserSettings existingItem = null;
            if (itemToSave.getSettingsID() != 0) existingItem = selectById(itemToSave.getSettingsID(), database);
            try {
                if (existingItem == null) {
                    PreparedStatement statement = database.newStatement("INSERT INTO UserSettings (DifficultyID, MusicVol, SoundVol, ScreenSizeID, LevelSeed) VALUES (?, ?, ?, ?, ?)");
                    statement.setInt(1, itemToSave.getDifficultyID());
                    statement.setInt(2, itemToSave.getMusicVol());
                    statement.setInt(3, itemToSave.getSoundVol());
                    statement.setInt(4, itemToSave.getScreenSizeID());
                    statement.setString(5, itemToSave.getLastSeed());
                    database.executeUpdate(statement);
                }
                else {
                    PreparedStatement statement = database.newStatement("UPDATE UserSettings SET DifficultyID, MusicVol, SoundVol, ScreenSizeID, LevelSeed WHERE SettingsID = ?");
                    statement.setInt(1, itemToSave.getDifficultyID());
                    statement.setInt(2, itemToSave.getMusicVol());
                    statement.setInt(3, itemToSave.getSoundVol());
                    statement.setInt(4, itemToSave.getScreenSizeID());
                    statement.setString(5, itemToSave.getLastSeed());
                    statement.setInt(6, itemToSave.getSettingsID());
                    database.executeUpdate(statement);
                }
            } catch (SQLException resultsException) {
                System.out.println("Database saving error: " + resultsException.getMessage());
            }
        }

        public static UserSettings selectById(int id, DatabaseConnectionService database) {

            UserSettings result = null;

            PreparedStatement statement = database.newStatement("SELECT SettingsID, DifficultyID, MusicVol, SoundVol, ScreenSizeID, LevelSeed FROM UserSettings WHERE SettingsID = ?");

            try {
                if (statement != null) {

                    statement.setInt(1, id);
                    ResultSet results = database.executeQuery(statement);

                    if (results != null) {
                        result = new UserSettings(results.getInt("SettingsID"), results.getInt("DifficultyID"), results.getInt("MusicVol"), results.getInt("SoundVol"), results.getInt("ScreenSizeID"), results.getString("LevelSeed"));
                    }
                }
            } catch (SQLException resultsException) {
                System.out.println("Database select by id error: " + resultsException.getMessage());
            }

            return result;
        }
    }

