package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import model.Task;
import resource.TaskRepository;

/**
 * Servlet implementation class TaskController
 */
@WebServlet(
		loadOnStartup = 1,
		urlPatterns = {"/list", "/new", "/edit", "/delete"})
public class TaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String START_PATH = "/list";
	private static final String VIEW_PATH = "/view";
	private static final String ADD_PATH = "/new";
	private static final String EDIT_PATH = "/edit";
	private static final String DELETE_PATH = "/delete";
	
	private static final String URL_PATTERN = "WEB-INF/view/";
	
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		String url = "";
		
		if (START_PATH.equals(path)) {		
			request.setAttribute("tasks", taskRepository.getAllTask());
			url = "list.jsp";
		} else if (VIEW_PATH.equals(path)) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("task", taskRepository.getTask(id));
			url = "view.jsp";
		} else if (ADD_PATH.equals(path)) {
			request.setAttribute("task", new Task());
			url = "new.jsp";
		} else if (EDIT_PATH.equals(path)) {
			String idString = request.getParameter("id");
			if (!StringUtils.isEmpty(idString)) {
				Integer id = Integer.parseInt(idString);
				request.setAttribute("task", taskRepository.getTask(id));
				url = "new.jsp";
			}
		} else if (DELETE_PATH.equals(path)) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			taskRepository.deleteTask(id);
			request.setAttribute("tasks", taskRepository.getAllTask());
			url = "list.jsp";
		}
		request.getRequestDispatcher(URL_PATTERN + url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Task task = new Task();
		task.setName(request.getParameter("name"));
		task.setDescription(request.getParameter("description"));
		task.setComment(request.getParameter("comment"));
		Integer priority = Integer.parseInt(request.getParameter("priority"));
		task.setPriority(priority);
		String idString = request.getParameter("id");
		if (!StringUtils.isEmpty(idString)) {
			task.setId(Integer.parseInt(idString));
		}
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date dateCreated = new Date();
		Date deadline = new Date();
		try {
			if (!StringUtils.isEmpty(request.getParameter("dateCreated"))) {
				dateCreated =  df.parse(request.getParameter("dateCreated"));
			}
			deadline =  df.parse(request.getParameter("deadline"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		task.setDateCreated(dateCreated);
		task.setDeadline(deadline);

		if (task.getId() == null) {
			task.setDateCreated(new Date());
			taskRepository.addTask(task);
		} else {
			taskRepository.editTask(task);
		}
		
		request.setAttribute("tasks", taskRepository.getAllTask());
		request.getRequestDispatcher(URL_PATTERN + "list.jsp").forward(request, response);
	}

}
