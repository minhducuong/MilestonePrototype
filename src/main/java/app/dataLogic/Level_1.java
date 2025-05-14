package app.dataLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// 1. getMember 12-52

public class Level_1 extends JDBCmain {

 public ArrayList<memberClass> getMember(){
        ArrayList<memberClass> members = new ArrayList<memberClass>();
        try {
            // Connect to JDBC data base
            Connection connection = DriverManager.getConnection(DATABASE_Member);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM Members";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String sID  = results.getString("sID");
                String name  = results.getString("Full_name");
                String gender  = results.getString("gender");
                

                // Create a temperature Object
                memberClass member = new memberClass(sID, name, gender);

                // Add the lga object to the array
                members.add(member);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        }
        return members;
    }
}
