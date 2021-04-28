import java.io.IOException;
import static java.lang.System.out;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

          int id = Integer.parseInt(request.getParameter("id"));
        
      int status = 0;
        try {
            status = BookDao.delete(id);
        } catch (SQLException ex) {
            
        }
      
      if(status > 0){
        out.println("Delete Completed");
        response.sendRedirect("ViewBookServlet");
        
      } else 
          out.println("Delete Error");

    }
}
