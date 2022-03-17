package user.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.dao.CourseDao;
import user.dao.ProfessorDao;
import user.dao.StudentDao;

/**
 *
 * @author kundankumar
 */
public class DeleteServlet extends HttpServlet {

    private StudentDao studentDao = new StudentDao();
    private ProfessorDao professorDao = new ProfessorDao();
    private CourseDao courseDao = new CourseDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String command = request.getParameter("command");
        String id = request.getParameter("id");
        if ("professorDelete".equals(command)) {
            try {
                professorDao.delete(id);
                response.sendRedirect(request.getContextPath() + "/ProfessorFindAll");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if ("studentDelete".equals(command)) {
            try {
                studentDao.delete(id);
                response.sendRedirect(request.getContextPath() + "/StudentFindAll");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if ("courseDelete".equals(command)) {
            try {
                courseDao.delete(id);
                response.sendRedirect(request.getContextPath() + "/CourseFindAll");
            } catch (Exception ex) {
                ex.printStackTrace();
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
