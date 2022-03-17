package user.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.dao.CourseDao;
import user.dao.ProfessorDao;
import user.dao.QuestionDao;
import user.dao.StudentDao;
import user.domain.Course;
import user.domain.Professor;
import user.domain.Question;
import user.domain.Student;

/**
 *
 * @author 
 */
public class AddServlet extends HttpServlet {

    private StudentDao studentDao = new StudentDao();
    private ProfessorDao professorDao = new ProfessorDao();
    private CourseDao courseDao = new CourseDao();
    private QuestionDao questionDao=new QuestionDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String command = request.getParameter("method");
        if ("courseAdd".equals(command)) {
            try {
                String courseID = request.getParameter("courseID");
                String courseName = request.getParameter("courseName");;
                int maxParticipants = Integer.parseInt(request.getParameter("maxParticipants"));
                Course course = new Course(courseID, courseName, maxParticipants);
                 courseDao.add(course);
                response.sendRedirect(request.getContextPath()+"/CourseFindAll");
               
            } catch (Exception ex) {
                ex.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/jsps/course/add.jsp?msg=" + ex.getMessage());
            }
        } else if ("courseEdit".equals(command)) {
            try {
                String courseID = request.getParameter("courseID");
                String courseName = request.getParameter("courseName");;
                int maxParticipants = Integer.parseInt(request.getParameter("maxParticipants"));
                Course course = new Course(courseID, courseName, maxParticipants);
                courseDao.update(course);
                response.sendRedirect(request.getContextPath()+"/CourseFindAll");
                
            } catch (Exception ex) {
                ex.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/jsps/course/add.jsp?msg=" + ex.getMessage());
            }

        } else if ("professorAdd".equals(command)) {
            try {
                String profID = request.getParameter("profID");
                String profName = request.getParameter("profName");
                String courseID = request.getParameter("courseID");
               Professor professor= new Professor(profID,profName,courseID);
               professorDao.add(professor);
                response.sendRedirect(request.getContextPath()+"/ProfessorFindAll");
            } catch (Exception ex) {
                ex.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/jsps/professor/add.jsp?msg=" + ex.getMessage());
            }

        } else if ("professorEdit".equals(command)) {
            try {
                String profID = request.getParameter("profID");
                String profName = request.getParameter("profName");
                String courseID = request.getParameter("courseID");
               Professor professor= new Professor(profID,profName,courseID);
               professorDao.update(professor);
                response.sendRedirect(request.getContextPath()+"/ProfessorFindAll");
            } catch (Exception ex) {
                ex.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/jsps/professor/add.jsp?msg=" + ex.getMessage());
            }

        } else if ("studentAdd".equals(command)) {
            try {
                String netID = request.getParameter("netID");
                String studentName = request.getParameter("studentName");;
                int UIN = Integer.parseInt(request.getParameter("UIN"));
                String courseId=request.getParameter("courseId");
                Student student=new Student(netID,studentName,UIN,courseId);
                studentDao.add(student);
                response.sendRedirect(request.getContextPath()+"/StudentFindAll");
            
            } catch (Exception ex) {
                ex.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/jsps/student/add.jsp?msg=" + ex.getMessage());
            }

        } else if ("studentEdit".equals(command)) {

            try {
                String netID = request.getParameter("netID");
                String studentName = request.getParameter("studentName");;
                int UIN = Integer.parseInt(request.getParameter("UIN"));
                 String courseId=request.getParameter("courseId");
                Student student=new Student(netID,studentName,UIN,courseId);
                studentDao.update(student);
                response.sendRedirect(request.getContextPath()+"/StudentFindAll");
            
            } catch (Exception ex) {
                ex.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/jsps/student/add.jsp?msg=" + ex.getMessage());
            }
            
        }else if ("questionAdd".equals(command)) {
            try {
                //String questionID = request.getParameter("questionID");
                String question = request.getParameter("question");;
                String studentID = request.getParameter("studentID");
                String courseID=request.getParameter("courseID");
                Question question1=new Question(0, question, courseID,studentID);
                questionDao.add(question1);
                response.sendRedirect(request.getContextPath()+"/QuestionFindAll");
            
            } catch (Exception ex) {
                ex.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/jsps/question/add.jsp?msg=" + ex.getMessage());
            }

        } else if ("questionEdit".equals(command)) {

            try {
                int questionID = Integer.parseInt(request.getParameter("questionID"));
                String question = request.getParameter("question");;
                String studentID = request.getParameter("studentID");
                String courseID=request.getParameter("courseID");
                Question question1=new Question(questionID, question, courseID,studentID);
                questionDao.update(question1);
                response.sendRedirect(request.getContextPath()+"/QuestionFindAll");
            
            } catch (Exception ex) {
                ex.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/jsps/student/add.jsp?msg=" + ex.getMessage());
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
