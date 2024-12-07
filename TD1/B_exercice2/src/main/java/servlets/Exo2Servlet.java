package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/")
public class Exo2Servlet extends HttpServlet {
    private final String[] options={"Beau","Couvert","Pluie","Neige"};

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        toJsp(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        toJsp(request,response);
    }

    private void toJsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("options",options);
        Map<String, Integer> counters;
        if(request.getSession().getAttribute("counters")!=null){
            counters=(Map<String, Integer>) request.getSession().getAttribute("counters");
        }
        else {
            counters = new HashMap<>();
            for (String option : options) {
                counters.put(option, 0);
            }
        }
        if (request.getParameter("meteo") != null) {
            String meteo = request.getParameter("meteo");
            counters.put(meteo, counters.get(meteo) + 1);
        }
        request.getSession().setAttribute("counters",counters);
        request.setAttribute("counters", counters);
        request.getRequestDispatcher("WEB-INF/meteo.jsp").forward(request,response);
    }
}
