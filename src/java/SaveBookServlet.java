import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SaveBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); 
        PrintWriter out=response.getWriter();  
  
        String title = request.getParameter("title");  
        String author=request.getParameter("author");
        float price = Float.parseFloat(request.getParameter("price")); 
        String publisher = request.getParameter("publisher"); 
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        Book book = new Book();

        book.setTitle(title);  
        book.setAuthor(author);  
        book.setPrice(price);
        book.setPublisher(publisher);
        book.setQuantity(quantity);
        
        int status = 0;
        try {
            status = BookDao.save(book);
        } catch (SQLException ex) {
            
        }
        
        if(status>0){  
            out.print("<p>Book saved successfully!</p>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        } else {  
            out.println("Sorry! unable to save this book");  
        }            
        out.close();
        
    }    

}
