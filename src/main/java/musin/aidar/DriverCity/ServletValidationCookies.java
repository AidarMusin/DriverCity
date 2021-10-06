package musin.aidar.DriverCity;

import musin.aidar.DriverCity.setingsPJ.UserPJ;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "ServletValidationCookies", value = "/servlet-validation")
public class ServletValidationCookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = null;
        String userName = null;
        String userPass= null;
        UserPJ userPJ;
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("id_usCc")) {
                userId = cookie.getValue();
            } else if (cookie.getName().equals("name_usCc")) {
                userName = cookie.getValue();
            } else if (cookie.getName().equals("pass_usCc")) {
                userPass = cookie.getValue();
            }
        }
            userPJ = new UserPJ(userName, userPass);
            userPJ.setUserId(Integer.parseInt(userId));
            session.setAttribute("user", userPJ);

            getServletContext().getRequestDispatcher("/user-search").forward(request,response);

    }
}
