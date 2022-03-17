package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;
import user.domain.Course;
import user.domain.Student;




/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class StudentDao {
	
	
	public void add(Student student) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
		
			Connection connect = DBUtil.getConnection();
			
			
			String sql = "insert into student values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,student.getNetID());
		    preparestatement.setString(2,student.getStudentName());
		    preparestatement.setInt(3,student.getUIN());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Student> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Student> list = new ArrayList<>();
		try {
			Connection connect = DBUtil.getConnection();
			
			String sql = "select * from student";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Student student = new Student();
				student.setNetID(resultSet.getString(1));
	    		student.setStudentName(resultSet.getString(2));
	    		student.setUIN(resultSet.getInt(3));
	    		list.add(student);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
        
        public void update(Student student) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
		
			Connection connect = DBUtil.getConnection();
			String sql = "UPDATE student set StudentName=?, UIN=? WHERE NetID=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		   
		    preparestatement.setString(1,student.getStudentName());
		    preparestatement.setInt(2,student.getUIN());
                     preparestatement.setString(3,student.getNetID());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
        
         public void delete(String courseID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
		
			Connection connect = DBUtil.getConnection();
			String sql = "DELETE FROM student WHERE NetID=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,courseID);
		  
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
		
}
