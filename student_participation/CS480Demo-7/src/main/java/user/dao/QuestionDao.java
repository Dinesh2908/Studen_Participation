package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import user.domain.Question;

/**
 * DDL functions performed in database
 *
 * 
 *
 */
public class QuestionDao {

    public void add(Question question) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {

            Connection connect = DBUtil.getConnection();

            String sql = "insert into questions values(?,?,?,?)";
            PreparedStatement preparestatement = connect.prepareStatement(sql);
            preparestatement.setInt(1, 0);
            preparestatement.setString(2, question.getQuestion());
            preparestatement.setString(3, question.getCourseid());
            preparestatement.setString(4, question.getStudentid());
            preparestatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Question> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        List<Question> list = new ArrayList<>();
        try {
            Connection connect = DBUtil.getConnection();

            String sql = "select * from questions";
            PreparedStatement preparestatement = connect.prepareStatement(sql);
            ResultSet resultSet = preparestatement.executeQuery();

            while (resultSet.next()) {
                Question question = new Question();
                question.setQuestionid(resultSet.getInt(1));
                question.setQuestion(resultSet.getString(2));
                question.setCourseid(resultSet.getString(3));
                question.setStudentid(resultSet.getString(4));
                list.add(question);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

//    public static int getQuestionPostedCountByStudentId(String studentId) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
//        int count = 0;
//        try {
//            Connection connect = DBUtil.getConnection();
//
//            String sql = "select count(questionid) from questions where studentid=?";
//            PreparedStatement preparestatement = connect.prepareStatement(sql);
//            preparestatement.setString(1, studentId);
//            ResultSet resultSet = preparestatement.executeQuery();
//
//            if (resultSet.next()) {
//                count = resultSet.getInt(1);
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return count;
//    }

    public void update(Question question) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {

            Connection connect = DBUtil.getConnection();
            String sql = "UPDATE questions set question=?, courseid=?, studentid=? WHERE questionid=?";
            PreparedStatement preparestatement = connect.prepareStatement(sql);

            preparestatement.setString(1, question.getQuestion());
            preparestatement.setString(2, question.getCourseid());
            preparestatement.setString(3, question.getStudentid());
            preparestatement.setInt(4, question.getQuestionid());
            preparestatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int questionID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {

            Connection connect = DBUtil.getConnection();
            String sql = "DELETE FROM questions WHERE questionid=?";
            PreparedStatement preparestatement = connect.prepareStatement(sql);
            preparestatement.setInt(1, questionID);

            preparestatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
