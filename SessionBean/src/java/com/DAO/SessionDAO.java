package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Model.Session;

public class SessionDAO {
    Connection connection = null;
    private final String jdbcURL = "jdbc:mysql://localhost:3306/drivesmart_db";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "";
    
    private static final String INSERT_TRAINING_SESSIONS_SQL= "INSERT INTO training_sessions (session_id, student_name, branch_location, lesson_type, status) VALUES " + " (?, ?, ?, ?, ?);";
    
    private static final String SELECT_TRAINING_SESSIONS_BY_ID = "select session_id, student_name, branch_location, lesson_type, status from training_sessions where session_id =?";
    private static final String SELECT_ALL_TRAINING_SESSIONS = "select * from training_sessions";
    private static final String DELETE_TRAINING_SESSIONS_SQL = "delete from training_sessions where session_id = ?;";
    private static final String UPDATE_TRAINING_SESSIONS_SQL = "update training_sessions set student_name = ?, branch_location= ?, lesson_type =?, status =? where session_id = ?;";
    private String INSERT_TRAINING_SESSION_SQL;

    public SessionDAO () {}
    
    protected Connection getAllSessions() {
        Connection connection = null;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL,
        jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
        e.printStackTrace();
        } catch (ClassNotFoundException e) {
        e.printStackTrace();
        }
        return connection;
        }
    
    public void insertSession(Session session) throws SQLException {
        System.out.println(INSERT_TRAINING_SESSIONS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getAllSessions();
        PreparedStatement preparedStatement = connection.
        prepareStatement(INSERT_TRAINING_SESSION_SQL)) {
        preparedStatement.setString(1, name.getName());
        preparedStatement.setString(2, branch.getBranch());
        preparedStatement.setString(3, type.getLessonType());
        preparedStatement.setString(4, status.getStatus());
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
        } catch (SQLException e) {
        printSQLException(e);
        }
        }
    
    public Session selectSession(int id) {
        Session session = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getAllSessions();
                // Step 2: Create a statement using connection object
        PreparedStatement preparedStatement = connection.
        prepareStatement(SELECT_TRAINING_SESSIONS_BY_ID);) {
        preparedStatement.setInt(1, id);
        System.out.println(preparedStatement);
        // Step 3: Execute the query or update query
        ResultSet rs = preparedStatement.executeQuery();
        // Step 4: Process the ResultSet object.
        while (rs.next()) {
            id = rs.getInt("id");
        String name = rs.getString("name");
        String branch = rs.getString("branch");
        String type = rs.getString("type");
        String status = rs.getString("status");
        session = new Session(id, name, branch, status);
        }
        } catch (SQLException e) {
        printSQLException(e);
        }
        return session;
        }
        
        public List < Session > selectAllSessions() throws SQLException {

            List < Session > sessions = new ArrayList < > ();
            // Step 1: Establishing a Connection
            try (Connection connection = getAllSessions();
            // Step 2: Create a statement using connection object
            PreparedStatement preparedStatement = connection.
            prepareStatement(SELECT_ALL_TRAINING_SESSIONS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String branch = rs.getString("branch");
            String type = rs.getString("type");
            String status = rs.getString("status");
            sessions.add(new Session(id, name, branch, type, status));
            }
            } catch (SQLException e) {
            printSQLException(e);
            }
            return sessions;
            }
        
       public boolean deleteSession(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getAllSessions();
        PreparedStatement statement = connection.
        prepareStatement(DELETE_TRAINING_SESSIONS_SQL);) {
        statement.setInt(1, id);
        rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
        } 
            
        public boolean updateSession(Session session) throws
            SQLException {
            boolean rowUpdated;
            try (Connection connection = getAllSessions();
            PreparedStatement statement = connection.
            prepareStatement(UPDATE_TRAINING_SESSIONS_SQL);) {
            statement.setString(1, session.getName());
            statement.setString(2, session.getBranch());
            statement.setString(3, session.getType());
            statement.setString(4, session.getStatus());
            statement.setInt(5, session.getId());
            rowUpdated = statement.executeUpdate() > 0;
            }
            return rowUpdated;
            }
        
        private void printSQLException(SQLException ex) {
            for (Throwable e: ex) {
            if (e instanceof SQLException) {
            e.printStackTrace(System.err);
            System.err.println("SQLState: " + ((SQLException)
            e).getSQLState());

            System.err.println("Error Code: " + ((SQLException)
           e).getErrorCode());
           System.err.println("Message: " + e.getMessage());
           Throwable t = ex.getCause();
           while (t != null) {
           System.out.println("Cause: " + t);
           t = t.getCause();
           }
        }
    }
   }

    private static class name {

        private static String getName() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public name() {
        }
    }

    private static class branch {

        private static String getBranch() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public branch() {
        }
    }

    private static class type {

        private static String getLessonType() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public type() {
        }
    }

    private static class status {

        private static String getStatus() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public status() {
        }
    }

}    
 