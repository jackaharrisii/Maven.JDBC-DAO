package daos;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class ConnectionFactory {

    public static final String URL = "jdbc:postgresql://localhost:5432/jack";
    public static final String USER = "jack";
    public static final String PASS = "jah35209";
    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver() {
                public Connection connect(String s, Properties properties) throws SQLException {
                    return null;
                }

                public boolean acceptsURL(String s) throws SQLException {
                    return false;
                }

                public DriverPropertyInfo[] getPropertyInfo(String s, Properties properties) throws SQLException {
                    return new DriverPropertyInfo[0];
                }

                public int getMajorVersion() {
                    return 0;
                }

                public int getMinorVersion() {
                    return 0;
                }

                public boolean jdbcCompliant() {
                    return false;
                }

                public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                    return null;
                }
            });
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }


}
