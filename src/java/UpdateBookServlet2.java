import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateBookServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        
        
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");  
        String author=request.getParameter("author");
        float price = Float.parseFloat(request.getParameter("price")); 
        String publisher = request.getParameter("publisher"); 
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        Book book = new Book();
        
        book.setId(id);
        book.setTitle(title);  
        book.setAuthor(author); 
        book.setPrice(price);
        book.setPublisher(publisher);
        book.setQuantity(quantity);
        
        int status = 0; 
        try {
            status = BookDao.update(book);
        } catch (SQLException ex) {
            
        }
        
        if(status > 0) {  
            out.println("Update Completed");
            response.sendRedirect("ViewBookServlet");  
              
        }else {  
            out.println("Update Error");  
        }  
          
        out.close();
        
    }

}
