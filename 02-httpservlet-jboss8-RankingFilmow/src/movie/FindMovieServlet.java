package movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/findMovie")
public class FindMovieServlet extends HttpServlet {

	@Inject
	MovieContainer movieContainer;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		Integer rokOd = new Integer(0);
		if (req.getParameter("rokOd") != null && req.getParameter("rokOd").length() > 0) {
			rokOd = Integer.parseInt(req.getParameter("rokOd"));
		}

		List<Movie> movies = filterByYear(rokOd);
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ServletOutputStream out = res.getOutputStream();
		out.print("<html><body><h1>Katalog filmow</h1>");
		out.print("<div><form action='FindMovie' method='get'>" + "<label>Rok od:</label>"
				+ "<input type='number' name='rokOd' />" + "<input type='submit' />" + "</form></div>");
		out.print("<table>" + "<thead>" + "<th>Tytul</th>" + "<th>Rok</th>" + "</thead><tbody>");

		for (Movie m : movies) {
			out.print("<tr><th>" + m.getTytul() + "</th><th>" + m.getRok() + "</th></tr>");
		}

		out.print("</table>");
		out.print("</body></html>");
		out.close();

	}

	private List<Movie> filterByYear(Integer rokOd) {
		List<Movie> movies = new ArrayList<Movie>();

		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		for (Movie m : movieContainer.getMovies()) {
			if (Integer.parseInt(m.getRok()) > rokOd) {
				movies.add(m);
			}
		}

		return movies;

		// return movieContainer.getMovies().stream().filter(x ->
		// x.getRok().getYear() > rokOd)
		// .collect(Collectors.toList());
	}

}
