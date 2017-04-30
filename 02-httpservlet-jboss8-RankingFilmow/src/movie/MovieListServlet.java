package movie;

import java.io.IOException;
import java.util.Calendar;

import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MovieListServlet extends HttpServlet {

	@Inject
	MovieContainer movieContainer;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {

		response.setContentType("text/html; charset=UTF-8");
		Calendar c = Calendar.getInstance();
		c.set(2000, 8, 12);

		// Actor actor = new Actor(1, "Keanu", "Reeves", 52);
		// List<Actor> actors = new ArrayList<Actor>();
		// actors.add(actor);

		// SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");

		ServletOutputStream out = response.getOutputStream();
		out.print("<html>");
		out.print("<body>");
		out.print("<table>" + "<thead>" + "<th>Tytul</th>" + "<th>Rok</th>" + "</thead><tbody>");
		for (Movie m : movieContainer.getMovies()) {
			out.print("<tr><th>" + m.getTytul() + "</th><th>" + m.getRok() + "</th></tr>");
		}
		out.print("</table>");
		out.print("</body></html>");
		out.close();

	}

}
