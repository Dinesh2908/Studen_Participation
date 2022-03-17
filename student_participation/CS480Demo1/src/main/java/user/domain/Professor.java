

package user.domain;

/**
 *
 * @author kundankumar
 */
public class Professor {

    private String profID;
    private String profName;
    private String courseID;

    public Professor() {
    }

    public Professor(String profID, String profName, String courseID) {
        this.profID = profID;
        this.profName = profName;
        this.courseID = courseID;
    }
    
    

    public String getProfID() {
        return profID;
    }

    public void setProfID(String profID) {
        this.profID = profID;
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    
    
}
