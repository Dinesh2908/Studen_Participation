package user.domain;

/**
 *
 * 
 */
public class Question {

    private int questionid;

    private String question;

    private String courseid;

    private String studentid;

    public Question() {
    }

    public Question(int questionid, String question, String courseid, String studentid) {
        this.questionid = questionid;
        this.question = question;
        this.courseid = courseid;
        this.studentid = studentid;
    }
    
    

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

}
