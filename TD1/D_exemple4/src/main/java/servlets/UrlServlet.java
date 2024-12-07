package servlets;

import facades.Facade;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/UrlServlet/*"})
public class UrlServlet extends HttpServlet {
    // accès à la facade
    private Facade facade=Facade.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doWhatever(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doWhatever(request,response);
    }

    private void doWhatever(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String todo=request.getPathInfo();

        request.setAttribute("previoustodo",todo);
        if (todo==null) {
            request.setAttribute("msg","Choisissez une action...");
        } else {
            todo=todo.substring(1);   // le substring retire le / de début
            facade.ajout(todo);

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
        request.setAttribute("compteur",facade.getCompteurAsPairs());
        request.getRequestDispatcher("/WEB-INF/url.jsp").forward(request,response);

    }


}
