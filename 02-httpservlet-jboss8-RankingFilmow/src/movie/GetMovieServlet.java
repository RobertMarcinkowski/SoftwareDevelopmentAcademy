package movie;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class GetMovieServlet extends HttpServlet {

	@Inject
	MovieContainer movieContainer;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {

		String tytulDoPobrania = req.getParameter("tytulDoPobrania");

		// SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		ServletOutputStream out = response.getOutputStream();
		out.print("<html>");
		out.print("<body>");
		out.print("<table>" + "<thead>" + "<th>Tytul</th>" + "<th>Producent</th>" + "<th>Dlugosc</th>" + "<th>Rok</th>"
				+ "</thead><tbody>");

		for (Movie m : movieContainer.getMovies()) {
			if (m.getTytul().equals(tytulDoPobrania)) {
				out.print("<tr><th>" + m.getTytul() + "</th><th>" + m.getProducent() + "</th><th>" + m.getDlugosc()
						+ "</th><th>" + m.getRok() + "</th></tr>");
			}
		}
		out.print("</table>");
		out.print("</body></html>");

		out.close();
	}

}
