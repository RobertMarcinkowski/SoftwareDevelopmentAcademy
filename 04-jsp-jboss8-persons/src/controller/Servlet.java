package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mock.MockGenerator;
import model.Person;

/**
 * Servlet implementation class Servlet *
 */

@WebServlet(loadOnStartup = 1, urlPatterns = { "/start", "/form", "/persons" })
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String START_PATH = "/start";
	private static final String FORM_PATH = "/form";
	private static final String PERSONS_PATH = "/persons";

	// Wa¿ne trzeba zainicjalizowac liste, bo inaczej nie dzia³a³o :P
	private List<Person> persons = new ArrayList<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		persons.addAll(MockGenerator.generateMockData());

	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		String url = "";
		if (START_PATH.equals(path)) {
			String yourName = request.getParameter("name");
			request.setAttribute("name", yourName);
			url = "start.jsp";
		} else if (FORM_PATH.equals(path)) {
			url = "form.jsp";
		} else if (PERSONS_PATH.equals(path)) {
			request.setAttribute("persons", this.persons);
			url = "persons.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		Integer age = Integer.parseInt(request.getParameter("age"));

		Person person = new Person(name, surname, age);
		request.setAttribute("person", person);

		request.getRequestDispatcher("person.jsp").forward(request, response);
	}

}
