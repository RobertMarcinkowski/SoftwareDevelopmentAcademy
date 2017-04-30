package movie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MovieListServlet extends HttpServlet{

//	@Inject
//	MovieContainer movieContainer;
//	
//	@Inject
//	MovieRepository movieRepository;
	
	@Override
	public void doGet(HttpServletRequest req,
			HttpServletResponse response) throws IOException{
		
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sdAcademy-JPA");
//		EntityManager em =  emf.createEntityManager();
//		
//		String sql = "SELECT e FROM Movie ";
//		Query query = em.createQuery(sql);
//		List<Movie> movie  = query.getResultList();
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		Calendar c = Calendar.getInstance();
		c.set(1999, 5, 7);
		
		//movieRepository.findAll();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		ServletOutputStream out = response.getOutputStream();
		out.print("<html>");
		out.print("<body>");
		out.print("<table>"
				+ "<thead>"
				+ "<th>Tytul</th>"
				+ "<th>Rok</th>"
				+ "</thead><tbody>");
		
//		for(Movie m :movieContainer.getMovies()){
//			out.print("<tr><th>"+m.getTytul()+"</th><th>"+
//				sdf.format(m.getRok())+"</th></tr>");
//		}
				
				out.print("</table>");
		

		out.print("</body></html>");
		//out.close();
	}
}
