package musin.aidar.DriverCity;

import musin.aidar.DriverCity.connetDB.FindPerson;
import musin.aidar.DriverCity.setingsPJ.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet(name = "FindPersonServlet", value = "/find")
public class FindPersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String text = "Мой тестер";
//
//        response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
//        response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
//        response.getWriter().write(text);       // Write response body.

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("userProject") == null) {
            getServletContext().getRequestDispatcher("/homepage.jsp");
        }

        PrintWriter pw = response.getWriter();

        ArrayList<String> checkList = new ArrayList<>();
        String plug = "%";
        boolean chechVar = false;
        String surname = request.getParameter("surname") + plug;
        String name = request.getParameter("name") + plug;
        String patronymic = request.getParameter("patronymic") + plug;
        String city = request.getParameter("city") + plug;
        String car = request.getParameter("car") + plug;

        checkList.add(surname);
        checkList.add(name);
        checkList.add(patronymic);
        checkList.add(city);
        checkList.add(car);

        for (String str :
                checkList) {
            if (!str.equals(plug)) {
                chechVar = true;
            }
        }

        if (!chechVar) {
            getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
        }


        FindPerson findPerson = new FindPerson();
        ArrayList<Person> personList = null;
        try {
            personList = findPerson.findPerson(surname, name, patronymic, city, car);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        pw.println("<html><body>");
        pw.println("</br>");
        for (Person peop : personList) {
            pw.println("<h3> " + peop.getSurname() + " " + peop.getName() + " " + peop.getPatronymic()
                    + " - " + peop.getCity() + " - " + peop.getValueCars() + " </h2>");
        }
        pw.println("<h1> the search is over </h1>");
        pw.println("</body></html>");
    }
}
