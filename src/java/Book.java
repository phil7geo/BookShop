public class Book {
    protected int id;
    protected String title;
    protected String author;
    protected float price;
    protected String publisher;
    protected int quantity;
    
//    public Book() {
//    }
//    
//    public Book(int id){
//        this.id = id;
//    }
//    
//    public Book(int id, String title, String author, float price, String publisher, int quantity){
//        this(title, author, price, publisher, quantity);
//        this.id = id;
//    }
//    
//     public Book(String title, String author, float price, String publisher, int quantity) {
//        this.title = title;
//        this.author = author;
//        this.price = price;
//        this.publisher = publisher;
//        this.quantity = quantity;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
     
     
     
}
