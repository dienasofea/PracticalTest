
package com.Servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.SessionDAO;
import com.Model.Session;
import com.bean.SessionBean;

@WebServlet("/")
public class ScheduleServlet extends HttpServlet{
     private SessionDAO sessionDAO;
     @Override
        public void init() {
        sessionDAO = new SessionDAO();
        }
     @Override
        protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
        }
        protected void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
        String action = request.getServletPath();
        try {
        switch (action) {
        case "/new":
        showNewForm(request, response);
        break;
        case "/insert":
        insertSession(request, response);
        break;
        case "/delete":
        deleteSession(request, response);
        break;
        case "/edit":
        showEditForm(request, response);
        break;
        case "/update":
        updateSession(request, response);
        break;
        default:
        listSession(request, response);
        break;
        }
        } catch (SQLException ex) {
        throw new ServletException(ex);
        }
        }
        
        private void listSession(HttpServletRequest request,
            HttpServletResponse response)
            throws SQLException, IOException, ServletException {
            List < Session > listSession =
            sessionDAO.selectAllSessions();
            request.setAttribute("listSession", listSession);
            RequestDispatcher dispatcher =
            request.getRequestDispatcher("schedule.jsp");
            dispatcher.forward(request, response);
        }
        
        private void showNewForm(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
            RequestDispatcher dispatcher =
            request.getRequestDispatcher("book_session.jsp");
            dispatcher.forward(request, response);
        }

        private void showEditForm(HttpServletRequest request,
        HttpServletResponse response)
        throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Session existingSession = sessionDAO.selectSession(id);
        RequestDispatcher dispatcher =
        request.getRequestDispatcher("book_session.jsp");
        request.setAttribute("session", existingSession);
        dispatcher.forward(request, response);
        }

        private void insertSession(HttpServletRequest request,
            HttpServletResponse response)
            throws SQLException, IOException {
            String name = request.getParameter("name");
            String branch = request.getParameter("branch");
            String type = request.getParameter("type");
            String status = request.getParameter("status");
            Session newSession = new Session(name, branch, type, status);
            sessionDAO.insertSession(newSession);
            response.sendRedirect("list");
        }

        private void updateSession(HttpServletRequest request,
            HttpServletResponse response)
            throws SQLException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String branch = request.getParameter("branch");
            String type = request.getParameter("type");
            String status = request.getParameter("status");
            Session session = new Session(id, name, branch, type, status);
            sessionDAO.updateSession(session);
            response.sendRedirect("list");
        }

        private void deleteSession(HttpServletRequest request,
            HttpServletResponse response)
            throws SQLException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            sessionDAO.deleteSession(id);
            response.sendRedirect("list");
        }
          
}

