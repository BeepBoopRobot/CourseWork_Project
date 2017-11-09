package Services;

import Models.ScreenSize;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ScreenService {

    public static void selectAll(List<ScreenSize> targetList, DatabaseConnectionService database) {

        PreparedStatement statement = database.newStatement("SELECT ScreenSizeID, Width, Height FROM ScreenSize ORDER BY ScreenSizeID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new ScreenSize(results.getInt("ScreenSizeID"), results.getInt("Width"), results.getInt("Height")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }
}
