
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "FirstServlet", urlPatterns = {"/FirstServlet"})
public class FirstServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // on récupère le paramètre "memo" de la requête
        String memo=request.getParameter("memo");
        // on stocke sa valeur en session, sous le nom "memosession"
        request.getSession().setAttribute("memosession",memo);
        System.out.println(memo);
        request.getRequestDispatcher("/WEB-INF/first.jsp").forward(request,response);
    }
}
