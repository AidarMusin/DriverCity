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


        UserProject userProject = (UserProject) session.getAttribute("userProject");

        if (userProject == null) {
            SearchUserInDB searchUserInDB = new SearchUserInDB();
            boolean checkUserProject = false;
            String userProjectName = request.getParameter("login");
            String userProjectPass = request.getParameter("pass");



            try {
                checkUserProject = searchUserInDB.findUser(userProjectName, userProjectPass);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            if (checkUserProject) {
                try {
                    userProject = new UserProject(userProjectName, userProjectPass);
                    userProject.setUserProjectId(searchUserInDB.findUserId(userProjectName, userProjectPass));

                    session.setAttribute("userProject", userProject);

                    getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                getServletContext().getRequestDispatcher("/userspage.jsp").forward(request, response);
            }
        } else {
            getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}