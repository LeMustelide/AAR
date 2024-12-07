package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/TodoServlet"})
public class TodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doWhatever(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doWhatever(request,response);
    }

    private void doWhatever(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String todo=request.getParameter("TODO");

        request.setAttribute("previoustodo",todo);
        if (todo==null) {
            request.setAttribute("msg","Choisissez une action...");
        } else {
            switch (todo) {
                case "bonjour" :
                    request.setAttribute("msg","Bien le bonjour!");
                    break;
                case "beau" :
                    request.setAttribute("msg","Il fait toujours beau quand c'est le Spring!");
                    break;
                default:
                    request.setAttribute("msg","Qu'avez vous dit?");
            }
        }
        request.getRequestDispatcher("/WEB-INF/todo.jsp").forward(request,response);

    }


}
