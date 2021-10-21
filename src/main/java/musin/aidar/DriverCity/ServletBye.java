package musin.aidar.DriverCity;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletBy", value = "/ServletBy")
public class ServletBye extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(ServletBye.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        HttpSession session = request.getSession();
        session.invalidate();

        logger.info("session close!");

        try {
            getServletContext().getRequestDispatcher("/bye.jsp").forward(request, response);

        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
