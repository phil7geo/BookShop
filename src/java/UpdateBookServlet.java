import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");  
        
        PrintWriter out=response.getWriter();  
        out.println("<h1 style='text-align: center; color:coral; font-size: 35px;'>Update Book</h1>");
        
        int id = Integer.parseInt(request.getParameter("id"));
          
        Book book = null;
        try {
            book = BookDao.getBookById(id);
        } catch (SQLException ex) {
        }
        
        out.print("<form action='UpdateBookServlet2' method='post' style='margin: auto auto auto 600px;' >");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='" + book.getId() + "'/></td></tr>");  
        out.print("<tr><td>Title:</td><td><input type='text' name='title' value='" + book.getTitle() + "'/></td></tr>");  
        out.print("<tr><td>Author:</td><td><input type='text' name='author' value='" + book.getAuthor() + "'/></td></tr>");
        out.print("<tr><td>Price:</td><td><input type='text' name='price' value='" + book.getPrice() + "'/></td></tr>"); 
        out.print("<tr><td>Publisher:</td><td><input type='text' name='publisher' value='" + book.getPublisher() + "'/></td></tr>"); 
        out.print("<tr><td>Quantity:</td><td><input type='text' name='quantity' value='" + book.getQuantity() + "'/></td></tr>"); 
        
        out.print("<tr style='text-align: center;'><td colspan='2'><input type='submit' value='Edit & Save' style='height: 40px; width: 45%; color: white; background-color: coral; margin: 15px auto auto 60px;' /></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
        
        out.print("<footer style='background: #ccc; border-top: 3px solid #908e8e; margin: 540px auto auto auto;'>");
        out.print("<p style='color: #616161; font-size: 13px; text-align: center; margin: 0; padding: 20px 0;'>(c) My BookShop </p>");
        out.print("</footer>");
          
        out.close();
        
    }

   
}
