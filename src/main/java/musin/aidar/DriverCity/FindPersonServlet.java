package musin.aidar.DriverCity;

import musin.aidar.DriverCity.connectDB.FindPerson;
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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@WebServlet(name = "FindPersonServlet", value = "/find")
public class FindPersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();

        try (PrintWriter pw = response.getWriter()) {

            if (session.getAttribute("userProject") == null) {
                getServletContext().getRequestDispatcher("/userspage.jsp").forward(request, response);

            } else {

                List<String> personRequest = Stream.of(request.getParameter("surname"),
                        request.getParameter("name"),
                        request.getParameter("patronymic"),
                        request.getParameter("city"),
                        request.getParameter("car")).collect(Collectors.toList());

                String plug = "";
                boolean checkVar = false;

                for (String str : personRequest) {
                    if (!str.equals(plug)) {
                        checkVar = true;
                    }
                }


                if (!checkVar) {
                    getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
                }


                FindPerson findPerson = new FindPerson();
                Map<Person, List<Car>> personMap = null;


                personMap = findPerson.findPersonInDB(personRequest);
                session.setAttribute("personList", personMap);


                pw.println("<!DOCTYPE html");
                pw.println("<html contentType=\"text/html;charset=UTF-8\"><head><title>  Result  </title></head><body><div>");

                personMap.forEach((k, v) -> pw.println("<h3>" + k.getName() + " " +
                        k.getSurname() + " - " +
                        k.getCity() + " : " +
                        v.stream().map(Car::getName).collect(Collectors.joining(", ")) + "</h3>"));

                pw.println("</div></body></html>");
            }

        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }
    }
}
