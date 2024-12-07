import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SecondServlet", urlPatterns =  {"/SecondServlet"} )
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // on récupère la chaîne stockée en session sous le nom "memosession"
        String memo=(String)request.getSession().getAttribute("memosession");
        // on la passe à la jsp sous le nom "memoattribute"
        request.setAttribute("memoattribute",memo);
        // on appelle la jsp
        request.getRequestDispatcher("/WEB-INF/second.jsp").forward(request,response);
    }

}
