package musin.aidar.DriverCity;

import musin.aidar.DriverCity.connetDB.FindPerson;
import musin.aidar.DriverCity.setingsPJ.People;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet(name = "FindPersonServlet", value = "/find")
public class FindPersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String plug = "%";
        String surname = request.getParameter("surname") + plug;
        String name = request.getParameter("name") + plug;
        String patronymic = request.getParameter("patronymic") + plug;
        String city = request.getParameter("city") + plug;
        String car = request.getParameter("car") + plug;


        FindPerson findPerson = new FindPerson();
        ArrayList<People> peopleList = null;
        try {
            peopleList = findPerson.findPerson(surname, name, patronymic, city, car);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        PrintWriter pw = response.getWriter();

        pw.println("<html><body>");
        pw.println("<h1> FIND PERSON " + peopleList.size() +  " " + name + " " + car + " " + city + " </h1>");
        pw.println("</br>");

        for (People peop : peopleList) {
            pw.println("<h2> " + peop.getSurname() + " " + peop.getName() +  " " + peop.getPatronymic()
                    + " - " + peop.getCity() + " - " + peop.getValueCars() + " </h2>");
        }

        pw.println("<h1> the search is over </h1>");
        pw.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
