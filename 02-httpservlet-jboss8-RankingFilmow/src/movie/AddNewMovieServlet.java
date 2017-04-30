package movie;

import java.io.IOException;
import java.util.Calendar;

import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddNewMovieServlet extends HttpServlet{

	
	@Inject
	MovieContainer movieContainer;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException{
		
		String info ="";
		if( !(req.getParameter("rok") != null && req.getParameter("rok").trim().length() > 0 &&
				req.getParameter("tytul") != null && req.getParameter("tytul").trim().length() > 0 &&
				req.getParameter("dlugosc") != null && req.getParameter("dlugosc").trim().length() > 0 &&
		req.getParameter("producent") != null && req.getParameter("producent").trim().length() > 0))
		{
			 info = "Uzupelnij formularz";
		}
		
		String tytul =  req.getParameter("tytul");
		if(tytul == null){
			tytul = "";
		}
		ServletOutputStream out = response.getOutputStream();
		String html = 
	"<!DOCTYPE html> " +
	"<html> " +
"<head> " +
"<meta charset=\"UTF-8\"> " +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" /> " +

  "<title>Nowy film</title> " +
"</head> " +
 
"<body> " +
"<h2>Nowy film</h2> " +
	info +
  "<form method=\"post\" action=\"newMovie\"> " +
 " <label>Tytul</label> " +
  "<input type=\"text\" name=\"tytul\"  value='" +tytul + "'> " +
  "<label>Rok</label> " +
  "<input type=\"number\" name=\"rok\" value='" +req.getParameter("rok") + "'> " +
  "<label>Producent</label> "+
  "<input type=\"text\" name=\"producent\" value='" +req.getParameter("producent") + "'> " +
  "<label>Dlugosc</label> "+
  "<input type=\"number\" name=\"dlugosc\" value='" +req.getParameter("dlugosc") + "'> " +
  
  "<button type=\"submit\">Dodaj</button> " +
  "</form> " +
"</body> " +
"</html>";
		out.print(html);
		out.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException{
		if( req.getParameter("rok") != null && req.getParameter("rok").trim().length() > 0 &&
				req.getParameter("tytul") != null && req.getParameter("tytul").trim().length() > 0 &&
				req.getParameter("dlugosc") != null && req.getParameter("dlugosc").trim().length() > 0 &&
		req.getParameter("producent") != null && req.getParameter("producent").trim().length() > 0)
		{
			
			
		
		
		
		Movie movie = new Movie(req.getParameter("tytul"), null,
				"2016", Integer.valueOf(req.getParameter("dlugosc")), null);
		
		movieContainer.getMovies().add(movie);
		
		ServletOutputStream out = response.getOutputStream();
		out.print("Dodano!");
		out.close();
		
		}else{
			doGet(req, response);
		}
	}
	
	
}
