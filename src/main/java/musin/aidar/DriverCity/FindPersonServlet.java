package musin.aidar.DriverCity;

import musin.aidar.DriverCity.connetDB.FindPerson;
import musin.aidar.DriverCity.myObject.Car;
import musin.aidar.DriverCity.myObject.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@WebServlet(name = "FindPersonServlet", value = "/find")
public class FindPersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter pw = response.getWriter();

        if (session.getAttribute("userProject") == null) {
            getServletContext().getRequestDispatcher("/userspage.jsp").forward(request, response);

        } else {

            List<String> checkList = new ArrayList<>();
            String plug = "%";
            boolean checkVar = false;
            String surname = request.getParameter("surname") + plug;
            String name = request.getParameter("name") + plug;
            String patronymic = request.getParameter("patronymic") + plug;
            String city = request.getParameter("city") + plug;
            String car = request.getParameter("car") + plug;

            checkList = Stream.of(surname, name, patronymic, city, car).collect(Collectors.toList());


            for (String str : checkList) {
                if (!str.equals(plug)) {
                    checkVar = true;
                }
            }

            if (!checkVar) {
                getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
            }


            //StringJoiner stringJoiner = new StringJoiner(",");

            FindPerson findPerson = new FindPerson();
            Map<Person, List<Car>> personMap = null;

            try {
                personMap = findPerson.findPersonInDB(surname, name, patronymic, city, car);
                session.setAttribute("personList", personMap);


                pw.println("<!DOCTYPE html");
                pw.println("<html contentType=\"text/html;charset=UTF-8\"><head><title>  Result  </title></head><body><div>");

                personMap.forEach((k, v) -> pw.println("<h3>" + k.getName() + " " +
                        k.getSurname() + " - " +
                        k.getCity() + " : " +
                        v.stream().map(Car::getName).collect(Collectors.joining(", ")) + "</h3>"));

                pw.println("</div></body></html>");


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }
}
