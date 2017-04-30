package movie;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNewMovieServlet extends HttpServlet {

	@Inject
	MovieContainer movieContainer;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
		String info = "";
		if (!(req.getParameter("rok") != null && req.getParameter("rok").trim().length() > 0
				&& req.getParameter("tytul") != null && req.getParameter("tytul").trim().length() > 0
				&& req.getParameter("dlugosc") != null && req.getParameter("dlugosc").trim().length() > 0
				&& req.getParameter("producent") != null && req.getParameter("producent").trim().length() > 0)) {
			info = "Uzupelnij formularz";
		}

		String html = "<!DOCTYPE html>" + "<html>" + "<head>" + "<meta charset=\"UTF-8\">" + "<title>Nowy film</title>"
				+ "</head>" + "<body><h2>New film</h2>" + info + "<form method=\"post\" action=\"newMovie\">"
				+ "<label>Tytul</label>" + "<input type=\"text\" name=\"tytul\" value='" + req.getParameter("tytul")
				+ "'>" + "<label>Rok</label>" + "<input type=\"text\" name=\"rok\" value='" + req.getParameter("rok")
				+ "'>" + "<label>Producent</label>" + "<input type=\"text\" name=\"producent\" value='"
				+ req.getParameter("producent") + "'>" + "<label>Dlugosc</label>"
				+ "<input type=\"number\" name=\"dlugosc\" value='" + req.getParameter("dlugosc") + "'>"
				+ "<button type=\"submit\">Dodaj film</button>" + "</form>" + "</body>" + "</html>";
		ServletOutputStream out = response.getOutputStream();
		out.print(html);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Movie movie = new Movie();

		if (req.getParameter("rok") != null && req.getParameter("rok").trim().length() > 0
				&& req.getParameter("tytul") != null && req.getParameter("tytul").trim().length() > 0
				&& req.getParameter("dlugosc") != null && req.getParameter("dlugosc").trim().length() > 0
				&& req.getParameter("producent") != null && req.getParameter("producent").trim().length() > 0) {

			// Calendar c = Calendar.getInstance();

			// c.set(Integer.parseInt(req.getParameter("rok")), 1, 1);
			movie.setTytul(req.getParameter("tytul"));
			movie.setRok(req.getParameter("rok"));
			movie.setProducent(req.getParameter("producent"));
			movie.setDlugosc(Integer.parseInt(req.getParameter("dlugosc")));
			movie.setActors(null);

			movieContainer.getMovies().add(movie);

			ServletOutputStream out = res.getOutputStream();
			out.print("Dodane");
			out.close();
		} else {
			doGet(req, res);
			// ServletOutputStream out = res.getOutputStream();

			// out.print("<html><body>Uzupelnij formularz <a
			// href='newMovie'>Wstecz! </a></body></html>");

			// out.close();
		}

	}

}
