package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;
import user.domain.Course;




/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class CourseDao {
	
	
	
	
	/**
	 * insert Course
	 * @param course
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(Course course) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
		
			Connection connect = DBUtil.getConnection();
			
			
			String sql = "insert into course values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,course.getCourseID());
		    preparestatement.setString(2,course.getCourseName());
		    preparestatement.setInt(3,course.getMaxParticipants());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Course> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Course> list = new ArrayList<>();
		try {
			Connection connect = DBUtil.getConnection();
			
			String sql = "select * from course";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Course course = new Course();
				course.setCourseID(resultSet.getString(1));
	    		course.setCourseName(resultSet.getString(2));
	    		course.setMaxParticipants(resultSet.getInt(3));
	    		list.add(course);
			 }
			 
		} catch(SQLException e) {
                    e.printStackTrace();
			throw new RuntimeException(e);
		}
		return list;
		
	}
        
        public void update(Course course) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
		
			Connection connect = DBUtil.getConnection();
			String sql = "UPDATE course set courseName=?, maxParticipants=? WHERE courseID=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		   
		    preparestatement.setString(1,course.getCourseName());
		    preparestatement.setInt(2,course.getMaxParticipants());
                     preparestatement.setString(3,course.getCourseID());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
        
         public void delete(String courseID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
		
			Connection connect = DBUtil.getConnection();
			String sql = "DELETE FROM course WHERE courseID=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,courseID);
		  
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
		
}
