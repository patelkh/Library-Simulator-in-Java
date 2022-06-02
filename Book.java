package library;

// Book is a subclass of LibraryItem
public class Book extends LibraryItem {
    private String author;
    private int check_out_length;

    //Constructor
    public Book(int id, String title, String author) {
        super(id, title);
        this.author = author;
        this.check_out_length = 21;
    }

    public int get_checkout_length() {
        return this.check_out_length;
    }

}
