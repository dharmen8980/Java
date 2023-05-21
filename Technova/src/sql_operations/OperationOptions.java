package sql_operations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class OperationOptions implements DataOperations{
    Connection con = null;
    @Override
    public void connect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Technova", "root", "sharma55.");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect(){
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(int cwid, String name, String major){
        try {
            String query = "INSERT INTO students(cwid, name, major) VALUES(?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setInt(1, cwid);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, major);

            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("The student with the given CWID already exist in the database");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int cwid) {
        String query = "DELETE FROM students where cwid = ?";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, cwid);
            int rowsAffected = statement.executeUpdate();

            System.out.println(rowsAffected == 0 ? "No students found with the given cwid: " + cwid
                    : "Student with the CWID: " + cwid + " successfully deleted");

            statement.close();
        } catch (SQLException e) {
            System.out.println("An error occured");
        }
    }

    @Override
    public void update(int cwid, String major){
        String query = "UPDATE students SET major = ? where cwid = ?";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, major);
            statement.setInt(2, cwid);
            int rowsAffected = statement.executeUpdate();

            System.out.println(rowsAffected != 0 ?
                    "Major of the student with the given cwid successfully updated."
                    : "No students found with the given cwid: " + cwid);

            statement.close();
        } catch (Exception e){
            System.out.println("An error occured! Please try again");
        }
    }

    @Override
    public String findStudentName(int cwid) throws SQLException {
        String query = "SELECT * FROM students WHERE cwid = ?";

        PreparedStatement statement = con.prepareStatement(query);

        statement.setInt(1, cwid);
//        Statement statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery();
        String studentInfo = "No student exists with the given cwid";
        while(resultSet.next()){
            studentInfo = String.format("%-10d %-20s %-20s",resultSet.getInt("cwid"), resultSet.getString("name"), resultSet.getString("major"));

        }
        resultSet.close();
        statement.close();
        return studentInfo;
    }

    @Override
    public ArrayList<String> findStudentId(String name) {
        ArrayList<String> data = new ArrayList<>();
        String query = "SELECT * FROM students where name LIKE ? ";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, name+"%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                data.add(String.format("%-10d %-20s %-20s",resultSet.getInt("cwid"), resultSet.getString("name"), resultSet.getString("major")));
            }
            resultSet.close();
            statement.close();

            return data;
        } catch (SQLException e){
//            System.out.println("An error occurred");
            e.printStackTrace();
        }
        return data;
    }
    @Override
    public ArrayList<String> listAll(){
        ArrayList<String> data = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM students;");

            while(result.next()){
                data.add(String.format("%-10d %-20s %-20s",result.getInt("cwid"), result.getString("name"), result.getString("major")));
            }
            result.close();
            statement.close();
            return data;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertAll(String filename) {
        try {
            // Read the file and perform operation
            try(BufferedReader reader = new BufferedReader(new FileReader(filename))){

                String line;
                String insertQuery = "INSERT INTO students (cwid, name, major) VALUES (?, ?, ?)";
                PreparedStatement statement = con.prepareStatement(insertQuery);

                while((line = reader.readLine()) != null) {
                    String[] data = line.split(",");

                    //set parameter values
                    for(int i=0; i<data.length; i++){
                        if(i == 0) {
                            statement.setInt(i + 1, Integer.parseInt(data[i]));
                        } else {
                            statement.setString(i + 1, data[i]);
                        }
                    }
                    statement.addBatch();
                }

                statement.executeBatch();
                statement.close();
                con.close();
                System.out.println("All data added successfully");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e){
            System.out.println("An error occured");
        }
    }

    @Override
    public ArrayList<String> listByMajor(String major){
        ArrayList<String> data = new ArrayList<>();
        String query = "SELECT * FROM students where major = ? ";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, major);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                data.add(String.format("%-10d %-20s %-20s",resultSet.getInt("cwid"), resultSet.getString("name"), resultSet.getString("major")));
            }
            resultSet.close();
            statement.close();

            return data;
        } catch (SQLException e){
//            System.out.println("An error occurred");
            e.printStackTrace();
        }
        return data;
    }
}
