package musin.aidar.DriverCity;

import musin.aidar.DriverCity.connetDB.SearchUserInDB;
import musin.aidar.DriverCity.setingsPJ.UserPJ;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "SearchUserInDBServlet", value = "/user-search")
public class SearchUserInDBServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String nameUser = request.getParameter("login");
        String passUser = request.getParameter("pass");
        String rememberMe = request.getParameter("remember-me");
        int idUser;


        UserPJ userPJ = (UserPJ) session.getAttribute("user");

        if (userPJ == null) {
            userPJ = new UserPJ(nameUser, passUser);
        }

        if (userPJ.getUserId() != null) {
            getServletContext().getRequestDispatcher("/homepage.jsp").forward(request,response);
        }

        SearchUserInDB searchUserInDB = new SearchUserInDB();

//        Cookie cookieID;
//        Cookie cookieName;
//        Cookie cookiePass;

        try {
            idUser = searchUserInDB.findUserId(userPJ);

            if (idUser != 0) {
                userPJ.setUserId(idUser);

                session.setAttribute("user", userPJ);

//                if (rememberMe != null) {
//                    cookieID = new Cookie("id_usCc", userPJ.getUserId());
//                    cookieName = new Cookie("name_usCc", nameUser);
//                    cookiePass = new Cookie("pass_usCc", passUser);
//
//                    cookieID.setMaxAge(24*2*60*60);
//                    cookieName.setMaxAge(24*2*60*60);
//                    cookiePass.setMaxAge(24*2*60*60);
//
//                    response.addCookie(cookieID);
//                    response.addCookie(cookieName);
//                    response.addCookie(cookiePass); //понимаю, что так делать нельзя. Потом придумаю, что то другое.
//                }
                getServletContext().getRequestDispatcher("/homepage.jsp").forward(request,response);
            } else {
                getServletContext().getRequestDispatcher("/userspage.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}