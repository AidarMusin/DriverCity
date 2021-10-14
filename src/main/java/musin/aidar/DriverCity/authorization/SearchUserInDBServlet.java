package musin.aidar.DriverCity.authorization;

import musin.aidar.DriverCity.connetDB.SearchUserInDB;
import musin.aidar.DriverCity.myObject.UserProject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SearchUserInDBServlet", value = "/user-search")
public class SearchUserInDBServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        UserProject userProject = (UserProject) session.getAttribute("userProject");

        try {

            if (userProject == null) {

                SearchUserInDB searchUserInDB = new SearchUserInDB();

                String userProjectName = request.getParameter("login");
                String userProjectPass = request.getParameter("pass");

                boolean  checkUserProject = searchUserInDB.findUser(userProjectName, userProjectPass);

                if (checkUserProject) {

                    userProject = new UserProject(userProjectName, userProjectPass);
                    userProject.setUserProjectId(searchUserInDB.findUserId(userProjectName, userProjectPass));

                    session.setAttribute("userProject", userProject);

                    getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);

                } else {
                    String errorUser = "Invalid username and password, please try again";
                    session.setAttribute("errorUser", errorUser);
                    getServletContext().getRequestDispatcher("/userspage.jsp").forward(request, response);
                }


            } else {
                getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}