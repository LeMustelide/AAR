package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/"})
public class Exo3Servlet extends HttpServlet {
    private int nbEssaisRestants;
    private MotATrouver motATrouver;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pendu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mot = request.getParameter("mot");
        if (mot != null) {
            setaDeviner(mot);
        } else {
            String carac = request.getParameter("caractere");
            if (carac != null && !carac.isEmpty()) {
                if(!motATrouver.test(carac.charAt(0))) {
                    nbEssaisRestants--;
                }
            }
        }
        request.setAttribute("nbErreurs", 6 - nbEssaisRestants);
        request.setAttribute("devine", motATrouver.getMotDevine());

        request.getRequestDispatcher("/WEB-INF/essai.jsp").forward(request, response);
    }


    private void setaDeviner(String aDeviner) {
        this.motATrouver = new MotATrouver(aDeviner);
        this.nbEssaisRestants = 6;
    }

//    private boolean test(char carac) {
//        boolean res = false;
//        for (int last = aDeviner.indexOf(carac); last != -1; last = aDeviner.indexOf(carac, last + 1)) {
//            res = true;
//            devine.setCharAt(last, carac);
//        }
//        if (!res) {
//            nbEssaisRestants--;
//        }
//        return res;
//    }
}
