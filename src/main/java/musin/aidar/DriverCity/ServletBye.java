package musin.aidar.DriverCity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletBy", value = "/ServletBy")
public class ServletBye extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        HttpSession session = request.getSession();
        session.invalidate();

        try {
            getServletContext().getRequestDispatcher("/bye.jsp").forward(request, response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
