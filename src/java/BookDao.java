import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookDao {
    
        public static Connection getConnection() throws SQLException {
        Connection con = null;
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bookstore", "Georgantzos", "lolas7");
        } catch (ClassNotFoundException | SQLException ex) {           
        }
        return con;
    }
        
     public static int save(Book book) throws SQLException {
        int status = 0;
        Connection con = BookDao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO book(title, author, price, publisher, quantity) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1,book.getTitle());  
            ps.setString(2,book.getAuthor());  
            ps.setFloat(3,book.getPrice());
            ps.setString(4,book.getPublisher());
            ps.setInt(5,book.getQuantity());
            
            status=ps.executeUpdate();                
            con.close();
        } catch (SQLException ex) {            
        }
        return status;
    }
     
      public static int update(Book book) throws SQLException {
        int status = 0;
        Connection con = BookDao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE book SET title=?, author=?, price=?, publisher=?, quantity=?  WHERE id=?");
            ps.setString(1,book.getTitle());  
            ps.setString(2,book.getAuthor());
            ps.setFloat(3,book.getPrice());
            ps.setString(4,book.getPublisher());
            ps.setInt(5,book.getQuantity());
            ps.setInt(6,book.getId());
            
            status=ps.executeUpdate();                
            con.close();
        } catch (SQLException ex) {            
        }
        return status;
    }
      
       public static int delete(int id) throws SQLException {
        int status = 0;
        Connection con = BookDao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM book WHERE id=?");
            ps.setInt(1, id);
            status=ps.executeUpdate();                
            con.close();
        } catch (SQLException ex) {            
        }
        return status;
    }
       
      public static Book getBookById(int id) throws SQLException {
        Book book = new Book();
        Connection con = BookDao.getConnection();        
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM book WHERE id=?");
            ps.setInt(1,id);  
            ResultSet rs = ps.executeQuery();  
            if(rs.next()){  
                book.setId(rs.getInt(1));  
                book.setTitle(rs.getString(2));  
                book.setAuthor(rs.getString(3));
                book.setPrice(rs.getFloat(4)); 
                book.setPublisher(rs.getString(5)); 
                book.setQuantity(rs.getInt(6)); 
            }  
            con.close();  
        } catch (SQLException ex) {            
        }
        return book;
    }
      
      public static List<Book> getAvailableBooks() throws SQLException {
        List<Book> list1 = new ArrayList<>();
        Connection con = BookDao.getConnection();
        
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM book WHERE quantity > 0"); 
//            ps.setInt(1, quantity);
            ResultSet rs = ps.executeQuery();  
            while (rs.next()){ 
               Book book = new Book();
                 
                book.setId(rs.getInt(1));  
                book.setTitle(rs.getString(2));  
                book.setAuthor(rs.getString(3));
                book.setPrice(rs.getFloat(4)); 
                book.setPublisher(rs.getString(5)); 
                book.setQuantity(rs.getInt(6)); 
                list1.add(book);
            }  
            con.close();  
        } catch (SQLException ex) {            
        }
        return list1;
    }
      
      public static List<Book> getAllBooks() throws SQLException {
        List<Book> list = new ArrayList<>();
        Connection con = BookDao.getConnection();  
        
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM book");
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Book book = new Book();  
                
                book.setId(rs.getInt(1));  
                book.setTitle(rs.getString(2));  
                book.setAuthor(rs.getString(3));
                book.setPrice(rs.getFloat(4)); 
                book.setPublisher(rs.getString(5)); 
                book.setQuantity(rs.getInt(6));   
                list.add(book);  
            }  
            con.close(); 
        } catch (SQLException ex) {
            
        }
        return list;
    }    
      
       public static int orderBookById (Book book, int quantity, int id) throws SQLException {
           int status = 0;
           Connection con = BookDao.getConnection();        
           try {
                PreparedStatement ps = con.prepareStatement("UPDATE book SET quantity = quantity-?  WHERE id=?");
                ps.setInt(1,book.getQuantity()); 
                ps.setInt(2,book.getId());
                status=ps.executeUpdate();  
                con.close(); 

           }
           catch (SQLException ex) {
                
           }
            return status;
        }
        
}
