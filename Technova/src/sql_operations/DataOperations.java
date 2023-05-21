package sql_operations;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DataOperations {
    void connect();
    void disconnect() throws SQLException;
    void save(int cwid, String name, String major) throws SQLException;
    void delete(int cwid) throws SQLException;
    void update(int cwid, String major) throws SQLException;
    String findStudentName(int cwid) throws SQLException;
    ArrayList<String> findStudentId(String name);
    ArrayList<String> listAll();
    void insertAll(String filename);
    ArrayList<String> listByMajor(String major);
}
