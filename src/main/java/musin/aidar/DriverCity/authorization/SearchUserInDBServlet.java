package musin.aidar.DriverCity.authorization;

import musin.aidar.DriverCity.connectDB.SearchUserInDB;
import musin.aidar.DriverCity.myObject.UserProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger logger = LoggerFactory.getLogger(SearchUserInDBServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        HttpSession session = request.getSession();
        UserProject userProject = (UserProject) session.getAttribute("userProject");

        try {
            if (userProject == null) {
                SearchUserInDB searchUserInDB = new SearchUserInDB();

                String userProjectName = request.getParameter("login");
                String userProjectPass = request.getParameter("pass");


                boolean  checkUserProject = searchUserInDB.findUser(userProjectName, userProjectPass);

                if (checkUserProject) {
                    logger.info("A user with the name  {} has logged in.", userProjectName);
                    userProject = new UserProject(userProjectName, userProjectPass);
                    userProject.setUserProjectId(searchUserInDB.findUserId(userProjectName, userProjectPass));

                    session.setAttribute("userProject", userProject);

                    getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);

                } else {
                    logger.info("User {} is not found in DB.", userProjectName);
                    String errorUser = "Invalid username and password, please try again";
                    session.setAttribute("errorUser", errorUser);
                    getServletContext().getRequestDispatcher("/userspage.jsp").forward(request, response);
                }

            } else {
                getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
            }

        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage(), e);
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage(), sqlException);
        } catch (IOException ioException) {
            logger.error(ioException.getMessage(), ioException);
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}