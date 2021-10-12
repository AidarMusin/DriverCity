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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter pw = response.getWriter();

        if (session.getAttribute("userProject") == null) {
            getServletContext().getRequestDispatcher("/userspage.jsp").forward(request, response);

        } else {

            ArrayList<String> checkList = new ArrayList<>();
            String plug = "%";
            boolean checkVar = false;
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

            for (String str :  checkList) {
                if (!str.equals(plug)) {
                    checkVar = true;
                }
            }

            if (!checkVar) {
                getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
            }


            FindPerson findPerson = new FindPerson();
            ArrayList<Person> personList = null;
            try {
                personList = findPerson.findPersonInDB(surname, name, patronymic, city, car);
                session.setAttribute("personList",personList);

                //getServletContext().getRequestDispatcher("/result.jsp").forward(request,response);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            for (Person p : personList ) {
                pw.println("<!DOCTYPE html");
                pw.println("<html contentType=\"text/html;charset=UTF-8\"><head><title>  Result  </title></head><body><div>"   );


                pw.println("<h3>" + p.getSurname() + " - " + p.getName() + " : " + p.getCity() + " " + " - " + p.getValueCars() + "</h3>");
                pw.println("</div></body></html>" );
            }
        }
    }
}
