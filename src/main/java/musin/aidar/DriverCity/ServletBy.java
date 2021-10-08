package musin.aidar.DriverCity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletBy", value = "/ServletBy")
public class ServletBy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("userProject") != null) {

            session.invalidate();
            getServletContext().getRequestDispatcher("/by.jsp").forward(request, response);
        }
        else {
            getServletContext().getRequestDispatcher("/userspage.jsp");
        }
    }
}
