

package user.domain;

/**
 *
 * @author kundankumar
 */
public class Course {

    private String courseID;
    
    private String courseName;
    
    private int maxParticipants;

    public Course() {
    }

    public Course(String courseID, String courseName, int maxParticipants) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.maxParticipants = maxParticipants;
    }
    
    

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }
    
    
}
