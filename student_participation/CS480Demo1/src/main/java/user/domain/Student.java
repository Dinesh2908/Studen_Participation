

package user.domain;

/**
 *
 * @author kundankumar
 */
public class Student {

    private String netID;
    
    private String studentName;
    
    private int UIN;

    public Student() {
    }

    public Student(String netID, String studentName, int UIN) {
        this.netID = netID;
        this.studentName = studentName;
        this.UIN = UIN;
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
    
    
    
}
