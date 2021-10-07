package musin.aidar.DriverCity.authorization;

import musin.aidar.DriverCity.connetDB.SearchUserInDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SearchUserInDBServlet", value = "/user-search")
public class SearchUserInDBServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();

        //String rememberMe = request.getParameter("remember-me");

        int idUserProject = 0;

        UserProject userProject = (UserProject) session.getAttribute("userProject");


        if (userProject == null) {
            userProject = new UserProject(request.getParameter("login"), request.getParameter("pass"));
        }


        SearchUserInDB searchUserInDB = new SearchUserInDB();

        try {
            idUserProject = searchUserInDB.findUserId(userProject);

            if (idUserProject != 0) {
                userProject.setUserProjectId(idUserProject);

                session.setAttribute("userProject", userProject);
                getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);

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