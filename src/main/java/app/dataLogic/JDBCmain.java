package app.dataLogic;

public class JDBCmain {
 public static final String DATABASE = "jdbc:sqlite:database/database.db";
    public static final String DATABASE_Member = "jdbc:sqlite:database/Member.db";

    /**
     * This creates a JDBC Object so we can keep talking to the database
     */
    public JDBCmain() {
        System.out.println("Created JDBC Connection Object");
    }
}
