package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import user.domain.Professor;

/**
 * DDL functions performed in database
 *
 * @author changxin bai
 *
 */
public class ProfessorDao {

    public void add(Professor professor) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {

            Connection connect = DBUtil.getConnection();

            String sql = "insert into Professor values(?,?,?)";
            PreparedStatement preparestatement = connect.prepareStatement(sql);
            preparestatement.setString(1, professor.getProfID());
            preparestatement.setString(2, professor.getProfName());
            preparestatement.setString(3, professor.getCourseID());
            preparestatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Professor> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        List<Professor> list = new ArrayList<>();
        try {
            Connection connect = DBUtil.getConnection();

            String sql = "select * from Professor";
            PreparedStatement preparestatement = connect.prepareStatement(sql);
            ResultSet resultSet = preparestatement.executeQuery();

            while (resultSet.next()) {
                Professor professor = new Professor();
                professor.setProfID(resultSet.getString(1));
                professor.setProfName(resultSet.getString(2));
                professor.setCourseID(resultSet.getString(3));
                list.add(professor);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;

    }

    public void update(Professor student) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {

            Connection connect = DBUtil.getConnection();
            String sql = "UPDATE Professor set ProfName=?, CourseID=? WHERE ProfID=?";
            PreparedStatement preparestatement = connect.prepareStatement(sql);

            preparestatement.setString(1, student.getProfName());
            preparestatement.setString(2, student.getCourseID());
            preparestatement.setString(3, student.getProfID());
            preparestatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String ProfID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {

            Connection connect = DBUtil.getConnection();
            String sql = "DELETE FROM Professor WHERE ProfID=?";
            PreparedStatement preparestatement = connect.prepareStatement(sql);
            preparestatement.setString(1, ProfID);

            preparestatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
