package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import user.domain.Student;

/**
 * DDL functions performed in database
 *
 * 
 *
 */
public class StudentDao {
    
  

    public void add(Student student) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {

            Connection connect = DBUtil.getConnection();

            String sql = "insert into student values(?,?,?,?)";
            PreparedStatement preparestatement = connect.prepareStatement(sql);
            preparestatement.setString(1, student.getNetID());
            preparestatement.setString(2, student.getStudentName());
            preparestatement.setInt(3, student.getUIN());
            preparestatement.setString(4, student.getCourse());
            preparestatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        List<Student> list = new ArrayList<>();
        try {
            Connection connect = DBUtil.getConnection();

            String sql = "SELECT s.NetID,s.StudentName,s.UIN,s.Course,count(q.questionid) as postedquestion FROM Student s LEFT OUTER join questions q on q.studentid=s.NetID group by s.NetID";
            PreparedStatement preparestatement = connect.prepareStatement(sql);
            ResultSet resultSet = preparestatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setNetID(resultSet.getString(1));
                student.setStudentName(resultSet.getString(2));
                student.setUIN(resultSet.getInt(3));
                student.setCourse(resultSet.getString(4));
                // Set question posted by each student
                student.setQuestionCount(resultSet.getInt(5));
                list.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
     public List<Student> findallWithOutCount() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        List<Student> list = new ArrayList<>();
        try {
            Connection connect = DBUtil.getConnection();

            String sql = "SELECT * FROM Student";
            PreparedStatement preparestatement = connect.prepareStatement(sql);
            ResultSet resultSet = preparestatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setNetID(resultSet.getString(1));
                student.setStudentName(resultSet.getString(2));
                student.setUIN(resultSet.getInt(3));
                student.setCourse(resultSet.getString(4));
                list.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


    public void update(Student student) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {

            Connection connect = DBUtil.getConnection();
            String sql = "UPDATE student set StudentName=?, UIN=?, Course=? WHERE NetID=?";
            PreparedStatement preparestatement = connect.prepareStatement(sql);

            preparestatement.setString(1, student.getStudentName());
            preparestatement.setInt(2, student.getUIN());
            preparestatement.setString(3, student.getCourse());
            preparestatement.setString(4, student.getNetID());
            preparestatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String courseID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {

            Connection connect = DBUtil.getConnection();
            String sql = "DELETE FROM student WHERE NetID=?";
            PreparedStatement preparestatement = connect.prepareStatement(sql);
            preparestatement.setString(1, courseID);

            preparestatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
