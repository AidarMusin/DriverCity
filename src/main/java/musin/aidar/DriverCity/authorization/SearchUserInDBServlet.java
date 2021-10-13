package musin.aidar.DriverCity.authorization;

import musin.aidar.DriverCity.connetDB.SearchUserInDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@WebServlet(name = "SearchUserInDBServlet", value = "/user-search")
public class SearchUserInDBServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();


        UserProject userProject = (UserProject) session.getAttribute("userProject");
        try {
            if (userProject == null) {

                Properties pr = new Properties();
                File file = new File("setingsDB.properties");

                FileInputStream fis = new FileInputStream(file);
                pr.load(fis);
                Class.forName(pr.getProperty("driverJdbs"));

                Connection connection = DriverManager.getConnection(pr.getProperty("connectionUrl"), pr.getProperty("username"), pr.getProperty("password"));

                SearchUserInDB searchUserInDB = new SearchUserInDB();
                String userProjectName = request.getParameter("login");
                String userProjectPass = request.getParameter("pass");

                boolean checkUserProject = searchUserInDB.findUser(userProjectName, userProjectPass);

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
            //логирование
            //какие еще может кинуть exception
        } catch (SQLException sqlException) {
            //логирование
            //какие еще может кинуть exception
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}