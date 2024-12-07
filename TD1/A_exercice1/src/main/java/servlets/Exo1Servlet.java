package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class Exo1Servlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login.equals("enzo") && password.equals("1234")) {
            request.setAttribute("login", login);
            request.getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);

        }
//TODO récupérer le login et le mdp et les comparer avec la paire stockée statiquement; appeler la jsp bonjour en cas de succès et la jsp de login sinon
    }
}
