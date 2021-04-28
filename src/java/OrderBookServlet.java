import java.io.IOException;
import java.io.PrintWriter;
//import static java.lang.System.out;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OrderBookServlet extends HttpServlet {

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int id = Integer.parseInt(request.getParameter("id"));

        Book book = new Book();
        
        book.setQuantity(quantity);
        book.setId(id);
        
        int status = 0;
        try {
           status = BookDao.orderBookById(book, quantity, id);
        } catch (SQLException ex) {
        }
       

        if (status > 0 ){
             out.print("Succesfull order");
            response.sendRedirect("ViewBookServlet");
        } else out.print("Order Error");
        
        out.close();
    }

}
