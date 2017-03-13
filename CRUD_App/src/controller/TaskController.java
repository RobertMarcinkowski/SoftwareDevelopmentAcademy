package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.commons.lang3.StringUtils;

import model.Task;
import resource.TaskRepository;

/**
 * Servlet implementation class TaskController
 */
@WebServlet(loadOnStartup = 1, urlPatterns = { "/list", "/newtask", "/view", "/delete", "/edit" })
public class TaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String LIST_PATH = "/list";
	private static final String NEWTASK_PATH = "/newtask";
	private static final String VIEW_PATH = "/view";
	private static final String DELETE_PATH = "/delete";
	private static final String EDIT_PATH = "/edit";

	@Inject
	TaskRepository taskRepository;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		String url = "";
		if (LIST_PATH.equals(path)) {
			request.setAttribute("tasks", taskRepository.getAllTask());
			url = "WEB-INF/view/list.jsp";
		} else if (NEWTASK_PATH.equals(path)) {

			url = "WEB-INF/view/newtask.jsp";
		} else if (VIEW_PATH.equals(path)) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("task", taskRepository.getTask(id));
			url = "WEB-INF/view/view.jsp";
		} else if (DELETE_PATH.equals(path)) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			taskRepository.removeTask(id);
			request.setAttribute("tasks", taskRepository.getAllTask());
			url = "WEB-INF/view/list.jsp";
		} else if (EDIT_PATH.equals(path)) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("task", taskRepository.getTask(id));
			url = "WEB-INF/view/newtask.jsp";
		}

		request.getRequestDispatcher(url).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("inputName");
		String description = request.getParameter("inputDescription");
		String comment = request.getParameter("inputComment");
		Integer priority = null;
		try {
			priority = Integer.parseInt(request.getParameter("inputPriority"));
		} catch (NumberFormatException e1) {
			priority = null;
		}
		String dateCreated = request.getParameter("inputDateCreated");
		String deadline = request.getParameter("inputDeadline");

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dateCreatedAsDate = null;
		try {
			dateCreatedAsDate = sdf.parse(dateCreated);
		} catch (ParseException e) {
			dateCreatedAsDate = null;
		}
		Date deadlineAsDate = null;
		try {
			deadlineAsDate = sdf.parse(deadline);
		} catch (ParseException e) {
			deadlineAsDate = null;
		}

		Task task = new Task();
		task.setId(taskRepository.getAllTask().size());
		task.setName(name);
		task.setDescription(description);
		task.setComment(comment);
		task.setPriority(priority);
		task.setDateCreated(dateCreatedAsDate);
		task.setDeadline(deadlineAsDate);

		Integer id = null;
		try {
			id = Integer.parseInt(request.getParameter("inputId"));
		} catch (NumberFormatException e1) {
			id = null;
		}
		
		
		System.out.println(id);
		if (id == null || id>=taskRepository.getAllTask().size()) {
			taskRepository.addTask(task);
		} else {
			task.setId(id);
			taskRepository.editTask(task);
		}

		request.setAttribute("tasks", taskRepository.getAllTask());
		request.getRequestDispatcher("WEB-INF/view/list.jsp").forward(request, response);

	}

}
