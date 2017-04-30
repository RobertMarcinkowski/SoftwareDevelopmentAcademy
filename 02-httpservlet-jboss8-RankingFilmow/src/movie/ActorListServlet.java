package movie;

import java.io.IOException;
import java.util.Calendar;

import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showActors")
public class ActorListServlet extends HttpServlet {

	@Inject
	ActorContainer actorContainer;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {

		response.setContentType("text/html; charset=UTF-8");
		Calendar c = Calendar.getInstance();
		c.set(2000, 8, 12);

		// Actor actor = new Actor(Long.valueOf(1), "Keanu", "Reeves", 52);
		// List<Actor> actors = new
		// ArrayList<Actor>();
		// actors.add(actor);

		// SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");

		ServletOutputStream out = response.getOutputStream();
		out.print("<html>");
		out.print("<body>");
		out.print("<table>" + "<thead>" + "<th>Id</th>" + "<th>Imie</th>" + "<th>Nazwisko</th>" + "<th>Wiek</th>"
				+ "</thead><tbody>");
		for (Actor a : actorContainer.getActors()) {
			out.print("<tr><th>" + a.getId() + "</th><th>" + a.getImie() + "</th><th>" + a.getNazwisko() + "</th><th>"
					+ a.getWiek() + "</th></tr>");
		}
		out.print("</table>");
		out.print("</body></html>");
		out.close();

	}

}
