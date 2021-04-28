import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ViewAvailableBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        out.println("<button style='font-size:18px; background-color:coral;'><a href='index.html' style='color:white;'><span style='content:2190;'>&#8592;</span>Add New book</a></button>"); 
        out.println("<h1 style='text-align: center; color:coral; font-size: 35px;'>Available Books List</h1>");
        
                List<Book> list1 = null;
        try {
            list1 = BookDao.getAvailableBooks();
        } catch (SQLException ex) {
        }
        
        out.print("<table border='1' width='100%' style='text-align:center; background-color:#e6faf9; color:coral; height: 150px; margin: 50px auto auto auto;'"); 
        out.print("<tr><th>Id</th><th>Title</th><th>Author</th><th>Price</th><th>Publisher</th><th>Quantity</th><th>Edit</th><th>Delete</th><th>0rder</th></tr>"); 

          for(Book e:list1){  
           out.print("<tr><td>"
                   + e.getId() + "</td><td>"
                     + e.getTitle() + "</td><td>"
                     + e.getAuthor() + "</td><td>"
                     + e.getPrice() + "</td><td>"
                     + e.getPublisher() + "</td><td>"
                     + e.getQuantity() + "</td><td><a href='UpdateBookServlet?id="
                     + e.getId() + "' style='color: black; font-size: 20px;' >edit</a></td><td><a href='DeleteBookServlet?id=" 
                     + e.getId() + "' style='color: black; font-size: 20px;' >delete</a></td><td><a href='OrderBookServlet2?id=" 
                     + e.getId() + "' style='color: black; font-size: 20px;' >order</a></td></tr>"); 
          }  
          out.print("</table>");  

            out.print("<footer style='background: #ccc; border-top: 3px solid #908e8e; margin: 500px auto auto auto;'>");
            out.print("<p style='color: #616161; font-size: 13px; text-align: center; margin: 0; padding: 20px 0;'>(c) My BookShop </p>");
            out.print("</footer>");
          
          out.close();

    }

}
