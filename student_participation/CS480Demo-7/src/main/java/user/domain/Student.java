

package user.domain;

/**
 *
 * 
 */
public class Student {

    private String netID;
    
    private String studentName;
    
    private int UIN;
    
     private String course;
     
     private int questionCount;

    public Student() {
    }

    public Student(String netID, String studentName, int UIN, String course) {
        this.netID = netID;
        this.studentName = studentName;
        this.UIN = UIN;
        this.course = course;
    }
    

    public String getNetID() {
        return netID;
    }

    public void setNetID(String NetID) {
        this.netID = NetID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String StudentName) {
        this.studentName = StudentName;
    }

    public int getUIN() {
        return UIN;
    }

    public void setUIN(int UIN) {
        this.UIN = UIN;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }
    
}
